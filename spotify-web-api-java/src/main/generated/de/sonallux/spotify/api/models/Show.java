package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference-beta/#object-showobject">ShowObject</a>
 */
@Getter
@Setter
@NoArgsConstructor
public class Show {
    /**
     * <p>A list of the countries in which the show can be played, identified by their <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> code.</p>
     */
    private java.util.List<String> available_markets;
    /**
     * <p>The copyright statements of the show.</p>
     */
    private java.util.List<Copyright> copyrights;
    /**
     * <p>A description of the show.</p>
     */
    private String description;
    /**
     * <p>A list of the show's episodes.</p>
     */
    private java.util.List<SimplifiedEpisode> episodes;
    /**
     * <p>Whether or not the show has explicit content (true = yes it does; false = no it does not OR unknown).</p>
     */
    private Boolean explicit;
    /**
     * <p>External URLs for this show.</p>
     */
    private ExternalUrl external_urls;
    /**
     * <p>A link to the Web API endpoint providing full details of the show.</p>
     */
    private String href;
    /**
     * <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> for the show.</p>
     */
    private String id;
    /**
     * <p>The cover art for the show in various sizes, widest first.</p>
     */
    private java.util.List<Image> images;
    /**
     * <p>True if all of the show's episodes are hosted outside of Spotify's CDN. This field might be <code>null</code> in some cases.</p>
     */
    private Boolean is_externally_hosted;
    /**
     * <p>A list of the languages used in the show, identified by their <a href="https://en.wikipedia.org/wiki/ISO_639">ISO 639</a> code.</p>
     */
    private java.util.List<String> languages;
    /**
     * <p>The media type of the show.</p>
     */
    private String media_type;
    /**
     * <p>The name of the episode.</p>
     */
    private String name;
    /**
     * <p>The publisher of the show.</p>
     */
    private String publisher;
    /**
     * <p>The object type: &quot;show&quot;.</p>
     */
    private String type;
    /**
     * <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify URI</a> for the show.</p>
     */
    private String uri;
}