package de.sonallux.spotify.parser;

import de.sonallux.spotify.core.model.SpotifyWebApiCategory;
import de.sonallux.spotify.core.model.SpotifyScope;
import de.sonallux.spotify.core.model.SpotifyAuthorizationScopes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

class ApiScopesParser {

    private static final String DEFAULT_SCOPES_URL = "https://developer.spotify.com/documentation/general/guides/scopes";

    private String scopesUrl;

    SpotifyAuthorizationScopes parseScopes() throws IOException, ApiParseException {
        return parseScopes(DEFAULT_SCOPES_URL);
    }

    SpotifyAuthorizationScopes parseScopes(String scopesUrl) throws IOException, ApiParseException {
        this.scopesUrl = scopesUrl;
        var document = Jsoup.connect(scopesUrl).get();
        return parseScopes(document);
    }

    private SpotifyAuthorizationScopes parseScopes(Document document) throws ApiParseException {
        var scopes = new TreeMap<String, SpotifyScope>();

        var content = document.body().selectFirst("div.post-content").children();
        var scopeElements = ParseUtils.splitAt(content, "h2").get(1);
        for (var scopeElement : scopeElements.select("div")) {
            var scope = parseScope(scopeElement);
            if (scopes.containsKey(scope.getId())) {
                throw new ApiParseException("Scope is defined twice: " + scope.getId());
            }
            scopes.put(scope.getId(), scope);
        }
        return new SpotifyAuthorizationScopes(scopesUrl, scopes);
    }

    private SpotifyScope parseScope(Element scopeElement) throws ApiParseException {
        String id = scopeElement.attributes().get("id");
        String link = scopesUrl + "/#" + id;
        String text = scopeElement.select("h3").text();
        if (!id.equals(text)) {
            throw new ApiParseException("Scope has id " + id + " and text " + text);
        }

        var tableEntries = scopeElement.select("tr");
        if (tableEntries.size() != 3) {
            throw new ApiParseException("Expected three table entries for scope: " + id);
        }
        var description = tableEntries.get(0).child(1).text();
        var userDescription = tableEntries.get(1).child(1).text();
        var endpoints = new ArrayList<SpotifyScope.EndpointLink>();
        for (var element : tableEntries.get(2).select("li > a")) {
            endpoints.add(parseEndpointLink(element));
        }
        return new SpotifyScope(id, link, description, userDescription, endpoints);
    }

    private SpotifyScope.EndpointLink parseEndpointLink(Element element) throws ApiParseException {
        var absUrl = element.absUrl("href");
        var url = element.attributes().get("href");
        var urlSegments = url.split("/");
        if (urlSegments.length < 3) {
            throw new ApiParseException("Unknown link for scope: " + url);
        }
        else if ("web-api".equals(urlSegments[2])){
            //Links to web-api have following schema: `/documentation/web-api/reference/#<endpoint>`
            var endpoint = urlSegments[urlSegments.length - 1].substring(1);
            if (endpoint.length() == 0) {
                throw new ApiParseException("Scope has unknown link to web-api: " + url);
            }
            return new SpotifyScope.EndpointLink(absUrl, urlSegments[2], endpoint);
        } else {
            //Links to other apis have following schema: `/documentation/<api>`
            return new SpotifyScope.EndpointLink(absUrl, urlSegments[2]);
        }
    }

    void validateScopes(SpotifyAuthorizationScopes scopes, SortedMap<String, SpotifyWebApiCategory> categories) throws ApiParseException {
        var error = new StringBuilder();

        //Validate if endpoints referenced by scopes are present
        for (var scope : scopes.getScopeList()) {
            for (var link : scope.getEndpoints()) {
                if (link.getEndpoint() == null) {
                    continue;
                }
                var endpoint = categories.values().stream()
                        .flatMap(c -> c.getEndpointList().stream())
                        .filter(e -> e.getId().equals(link.getEndpoint()))
                        .findFirst();
                if (endpoint.isEmpty()) {
                    error.append(String.format("Scope %s has unknown endpoint reference: %s", scope.getId(), link.getEndpoint())).append("\n");
                }
            }
        }

        //Validate if scopes referenced by endpoints are present
        var endpointScopes = categories.values().stream().flatMap(c -> c.getEndpointList().stream())
                .flatMap(e -> e.getScopes().stream())
                .distinct()
                .collect(Collectors.toList());
        for (var endpointScope : endpointScopes) {
            var scope = scopes.getScope(endpointScope);
            if (scope.isEmpty()) {
                error.append(String.format("Endpoint has unknown scope: %s", endpointScope)).append("\n");
            }
        }
        var errorText = error.toString();
        if (!errorText.isEmpty()) {
            throw new ApiParseException(errorText);
        }
    }
}
