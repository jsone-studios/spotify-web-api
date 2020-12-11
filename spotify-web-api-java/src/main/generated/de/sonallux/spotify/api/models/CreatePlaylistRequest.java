package de.sonallux.spotify.api.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CreatePlaylistRequest {
    /**
     * <p>The name for the new playlist, for example <code>&quot;Your Coolest Playlist&quot;</code> . This name does not need to be unique; a user may have several playlists with the same name.</p>
     */
    @NonNull
    private String name;
    /**
     * <p>Defaults to <code>true</code> . If <code>true</code> the playlist will be public, if <code>false</code> it will be private. To be able to create private playlists, the user must have granted the <code>playlist-modify-private</code> <a href="https://developer.spotify.com/documentation/general/guides/authorization-guide/#list-of-scopes">scope</a></p>
     */
    @com.fasterxml.jackson.annotation.JsonProperty("public")
    private Boolean _public;
    /**
     * <p>Defaults to <code>false</code> . If <code>true</code> the playlist will be collaborative. Note that to create a collaborative playlist you must also set <code>public</code> to <code>false</code> . To create collaborative playlists you must have granted <code>playlist-modify-private</code> and <code>playlist-modify-public</code> <a href="https://developer.spotify.com/documentation/general/guides/authorization-guide/#list-of-scopes">scopes</a> .</p>
     */
    private Boolean collaborative;
    /**
     * <p>value for playlist description as displayed in Spotify Clients and in the Web API.</p>
     */
    private String description;
}