package de.sonallux.spotify.api;

import de.sonallux.spotify.api.models.ChangePlaylistDetailsRequest;
import de.sonallux.spotify.api.models.Episode;
import de.sonallux.spotify.api.models.RemoveTracksPlaylistRequest;
import de.sonallux.spotify.api.models.Track;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okio.Buffer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConversionTest {
    private MockWebServer webServer;
    private SpotifyWebApi api;

    @BeforeEach
    void setup() throws IOException {
        webServer = new MockWebServer();
        webServer.start();
        var baseUrl = webServer.url("/");
        api = new SpotifyWebApi(baseUrl);
    }

    @AfterEach
    void teardown() throws IOException{
        webServer.shutdown();
    }

    @Test
    void testResponseSnakeCaseToCamelCase() throws Exception {
        webServer.enqueue(loadMockResponse("get-playlist.json"));

        var playlist = api.callApiAndReturnBody(api.getPlaylistsApi().getPlaylist("foo"));
        assertEquals("37i9dQZF1DX4TiN7pMwV0Z", playlist.getId());
        assertEquals("MTYxNTI3MzcxMSwwMDAwMDAwMDcxOTM3NDM1NDIxMmIzODI4NGQzMDI0OGRiZGQ4M2Q4", playlist.getSnapshotId());
        assertFalse(playlist.isPublic());
        assertEquals("Spotify", playlist.getOwner().getDisplayName());
        var firstTrack = playlist.getTracks().getItems().get(0);
        assertNotNull(firstTrack);
        assertEquals(Instant.parse("2021-03-07T23:01:00Z"), firstTrack.getAddedAt());
        assertTrue(firstTrack.getTrack() instanceof Track);
        assertEquals(6, ((Track) firstTrack.getTrack()).getTrackNumber());
    }

    @Test
    void testRequestWithReservedKeyWord() throws Exception {
        webServer.enqueue(new MockResponse().setStatus("HTTP/1.1 200 OK"));

        var changePlaylistDetailsRequest = new ChangePlaylistDetailsRequest("Test", true, false, "Test description");
        var response = api.callApi(api.getPlaylistsApi().changePlaylistDetails("foo", changePlaylistDetailsRequest));
        assertTrue(response.isSuccessful());

        var request = webServer.takeRequest();
        assertEquals("application/json; charset=UTF-8", request.getHeader("Content-Type"));
        var actualBody = request.getBody().readUtf8();
        assertEquals("{\"name\":\"Test\",\"collaborative\":false,\"description\":\"Test description\",\"public\":true}", actualBody);
    }

    @Test
    void testRequestWithEmptyBodyObject() throws Exception {
        webServer.enqueue(new MockResponse().setStatus("HTTP/1.1 200 OK"));

        var response = api.callApi(api.getPlaylistsApi().changePlaylistDetails("foo"));
        assertTrue(response.isSuccessful());

        var request = webServer.takeRequest();
        assertEquals("application/json; charset=UTF-8", request.getHeader("Content-Type"));
        var actualBody = request.getBody().readUtf8();
        assertEquals("{}", actualBody);
    }

    @Test
    void testRequestWithSnakeCaseToCamelCase() throws Exception {
        webServer.enqueue(new MockResponse().setStatus("HTTP/1.1 200 OK").setBody("{\"snapshot_id\":\"12ab34cd\"}"));

        var removeTracksRequest = new RemoveTracksPlaylistRequest(List.of(), "ab12cd34");
        var newSnapshotId = api.callApiAndReturnBody(api.getPlaylistsApi().removeTracksPlaylist("foo", removeTracksRequest));
        assertEquals("12ab34cd", newSnapshotId.getSnapshotId());

        var request = webServer.takeRequest();
        assertEquals("application/json; charset=UTF-8", request.getHeader("Content-Type"));
        var actualBody = request.getBody().readUtf8();
        assertEquals("{\"tracks\":[],\"snapshot_id\":\"ab12cd34\"}", actualBody);
    }

    @Test
    void testUnionTypeHandlingWithAdditionalTypesParameter() throws Exception {
        webServer.enqueue(loadMockResponse("get-playlists-tracks-union.json"));

        var response = api.callApiAndReturnBody(api.getPlaylistsApi().getPlaylistsTracks("foo", "DE"));
        var track = response.getItems().get(0).getTrack();
        assertNotNull(track);
        assertEquals("track", track.getType());
        assertTrue(track instanceof Track);

        var episode = response.getItems().get(1).getTrack();
        assertNotNull(episode);
        assertEquals("episode", episode.getType());
        assertTrue(episode instanceof Episode);

        var request = webServer.takeRequest();
        // TODO: adjust when additional_types is set by default
        assertEquals("/playlists/foo/tracks?market=DE", request.getPath());
    }

    @Test
    void testUnionTypeHandlingWithoutAdditionalTypesParameter() throws Exception {
        webServer.enqueue(loadMockResponse("get-playlists-tracks.json"));

        var response = api.callApiAndReturnBody(api.getPlaylistsApi().getPlaylistsTracks("foo", "DE", Map.of("additional_types", "track")));
        var track = response.getItems().get(0).getTrack();
        assertNotNull(track);
        assertEquals("track", track.getType());
        assertTrue(track instanceof Track);

        var episode = response.getItems().get(1).getTrack();
        assertNotNull(episode);
        assertEquals("episode", episode.getType());
        assertTrue(episode instanceof Episode);

        var request = webServer.takeRequest();
        assertEquals("/playlists/foo/tracks?market=DE&additional_types=track", request.getPath());
    }

    private MockResponse loadMockResponse(String fileName) throws Exception {
        var stream = ConversionTest.class.getResourceAsStream("/responses/" + fileName);
        var buffer = new Buffer().readFrom(stream);
        return new MockResponse()
            .setStatus("HTTP/1.1 200 OK")
            .addHeader("Content-Type", "application/json; charset=utf-8")
            .setBody(buffer);
    }
}
