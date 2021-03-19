package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.models.*;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#category-library">Library API</a>
 */
public interface LibraryApi {

    /**
     * <h3>Check User's Saved Albums</h3>
     * <p>Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a> for the albums. Maximum: 50 IDs.</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains a JSON array of <code>true</code> or <code>false</code> values, in the same order in which the <code>ids</code> were specified.
     *         On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-check-users-saved-albums">Check User's Saved Albums</a>
     */
    @GET("/me/albums/contains")
    Call<java.util.List<Boolean>> checkUsersSavedAlbums(@Query("ids") String ids);

    /**
     * <h3>Check User's Saved Episodes</h3>
     * <p>Check if one or more episodes is already saved in the current Spotify user's 'Your Episodes' library.</p><p>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>..</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a> for the episodes. Maximum: 50 IDs.</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains a JSON array of <code>true</code> or <code>false</code> values, in the same order in which the <code>ids</code> were specified.
     *         On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-check-users-saved-episodes">Check User's Saved Episodes</a>
     */
    @GET("/me/episodes/contains")
    Call<java.util.List<Boolean>> checkUsersSavedEpisodes(@Query("ids") String ids);

    /**
     * <h3>Check User's Saved Shows</h3>
     * <p>Check if one or more shows is already saved in the current Spotify user's library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @param ids <p>A comma-separated list of the Spotify IDs for the shows. Maximum: 50 ids.</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains a JSON array of <code>true</code>or <code>false</code> values, in the same order in which the <code>ids</code> were specified. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#error-details">error object</a>.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-check-users-saved-shows">Check User's Saved Shows</a>
     */
    @GET("/me/shows/contains")
    Call<java.util.List<Boolean>> checkUsersSavedShows(@Query("ids") String ids);

    /**
     * <h3>Check User's Saved Tracks</h3>
     * <p>Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a> for the tracks. Maximum: 50 IDs.</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains a JSON array of <code>true</code> or <code>false</code> values, in the same order in which the <code>ids</code> were specified.
     *         On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-check-users-saved-tracks">Check User's Saved Tracks</a>
     */
    @GET("/me/tracks/contains")
    Call<java.util.List<Boolean>> checkUsersSavedTracks(@Query("ids") String ids);

    /**
     * <h3>Get User's Saved Albums</h3>
     * <p>Get a list of the albums saved in the current Spotify user's 'Your Music' library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains an array of <a href="https://developer.spotify.com/documentation/web-api/reference/#object-savedalbumobject">saved album objects</a> (wrapped in a <a href="https://developer.spotify.com/documentation/web-api/reference/#object-pagingobject">paging object</a>) in JSON format. Each album object is accompanied by a <a href="https://developer.spotify.com/documentation/web-api/#timestamps">timestamp</a> (<code>added_at</code>) to show when it was added. There is also an <strong>etag</strong> in the header that can be used in future <a href="https://developer.spotify.com/documentation/web-api/#conditional-requests">conditional requests</a>.</p>
     *         <p>On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-get-users-saved-albums">Get User's Saved Albums</a>
     */
    default Call<Paging<SavedAlbum>> getUsersSavedAlbums() {
        return getUsersSavedAlbums(java.util.Map.of());
    }

    /**
     * <h3>Get User's Saved Albums</h3>
     * <p>Get a list of the albums saved in the current Spotify user's 'Your Music' library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @param queryParameters <p>A map of optional query parameters</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains an array of <a href="https://developer.spotify.com/documentation/web-api/reference/#object-savedalbumobject">saved album objects</a> (wrapped in a <a href="https://developer.spotify.com/documentation/web-api/reference/#object-pagingobject">paging object</a>) in JSON format. Each album object is accompanied by a <a href="https://developer.spotify.com/documentation/web-api/#timestamps">timestamp</a> (<code>added_at</code>) to show when it was added. There is also an <strong>etag</strong> in the header that can be used in future <a href="https://developer.spotify.com/documentation/web-api/#conditional-requests">conditional requests</a>.</p>
     *         <p>On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-get-users-saved-albums">Get User's Saved Albums</a>
     */
    @GET("/me/albums")
    Call<Paging<SavedAlbum>> getUsersSavedAlbums(@QueryMap java.util.Map<String, Object> queryParameters);

    /**
     * <h3>Get User's Saved Episodes</h3>
     * <p>Get a list of the episodes saved in the current Spotify user's library.</p><p>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @return <ul>
     *         <li>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains an array of <a href="https://developer.spotify.com/documentation/web-api/reference/#object-savedepisodeobject">saved episode objects</a> (wrapped in a <a href="https://developer.spotify.com/documentation/web-api/reference/#object-pagingobject">paging object</a>) in JSON format. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>.</li>
     *         <li>Trying to get more than 2000 episodes for a user will return results for 2000 episodes. Only the 2000 returned episodes are sorted. This limitation will be removed in the near future.</li>
     *         </ul>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-get-users-saved-episodes">Get User's Saved Episodes</a>
     */
    default Call<Paging<SavedEpisode>> getUsersSavedEpisodes() {
        return getUsersSavedEpisodes(java.util.Map.of());
    }

    /**
     * <h3>Get User's Saved Episodes</h3>
     * <p>Get a list of the episodes saved in the current Spotify user's library.</p><p>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @param queryParameters <p>A map of optional query parameters</p>
     * @return <ul>
     *         <li>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains an array of <a href="https://developer.spotify.com/documentation/web-api/reference/#object-savedepisodeobject">saved episode objects</a> (wrapped in a <a href="https://developer.spotify.com/documentation/web-api/reference/#object-pagingobject">paging object</a>) in JSON format. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>.</li>
     *         <li>Trying to get more than 2000 episodes for a user will return results for 2000 episodes. Only the 2000 returned episodes are sorted. This limitation will be removed in the near future.</li>
     *         </ul>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-get-users-saved-episodes">Get User's Saved Episodes</a>
     */
    @GET("/me/episodes")
    Call<Paging<SavedEpisode>> getUsersSavedEpisodes(@QueryMap java.util.Map<String, Object> queryParameters);

    /**
     * <h3>Get User's Saved Shows</h3>
     * <p>Get a list of shows saved in the current Spotify user's library. Optional parameters can be used to limit the number of shows returned.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains an array of <a href="https://developer.spotify.com/documentation/web-api/reference/#object-savedshowobject">saved show objects</a> (wrapped in a <a href="https://developer.spotify.com/documentation/web-api/reference/#object-pagingobject">paging object</a>) in JSON format.
     *         If the current user has no shows saved, the response will be an empty array. If a show is unavailable in the given <code>market</code> it is filtered out. The <code>total</code> field in the paging object represents the number of all items, filtered or not, and thus might be larger than the actual total number of observable items.
     *         On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#error-details">error object</a>.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-get-users-saved-shows">Get User's Saved Shows</a>
     */
    default Call<Paging<SavedShow>> getUsersSavedShows() {
        return getUsersSavedShows(java.util.Map.of());
    }

    /**
     * <h3>Get User's Saved Shows</h3>
     * <p>Get a list of shows saved in the current Spotify user's library. Optional parameters can be used to limit the number of shows returned.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @param queryParameters <p>A map of optional query parameters</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains an array of <a href="https://developer.spotify.com/documentation/web-api/reference/#object-savedshowobject">saved show objects</a> (wrapped in a <a href="https://developer.spotify.com/documentation/web-api/reference/#object-pagingobject">paging object</a>) in JSON format.
     *         If the current user has no shows saved, the response will be an empty array. If a show is unavailable in the given <code>market</code> it is filtered out. The <code>total</code> field in the paging object represents the number of all items, filtered or not, and thus might be larger than the actual total number of observable items.
     *         On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#error-details">error object</a>.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-get-users-saved-shows">Get User's Saved Shows</a>
     */
    @GET("/me/shows")
    Call<Paging<SavedShow>> getUsersSavedShows(@QueryMap java.util.Map<String, Object> queryParameters);

    /**
     * <h3>Get User's Saved Tracks</h3>
     * <p>Get a list of the songs saved in the current Spotify user's 'Your Music' library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains an array of <a href="https://developer.spotify.com/documentation/web-api/reference/#object-savedtrackobject">saved track objects</a> (wrapped in a <a href="https://developer.spotify.com/documentation/web-api/reference/#object-pagingobject">paging object</a>) in JSON format. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-get-users-saved-tracks">Get User's Saved Tracks</a>
     */
    default Call<Paging<SavedTrack>> getUsersSavedTracks() {
        return getUsersSavedTracks(java.util.Map.of());
    }

    /**
     * <h3>Get User's Saved Tracks</h3>
     * <p>Get a list of the songs saved in the current Spotify user's 'Your Music' library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-read</code>
     *
     * @param queryParameters <p>A map of optional query parameters</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK and the response body contains an array of <a href="https://developer.spotify.com/documentation/web-api/reference/#object-savedtrackobject">saved track objects</a> (wrapped in a <a href="https://developer.spotify.com/documentation/web-api/reference/#object-pagingobject">paging object</a>) in JSON format. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-get-users-saved-tracks">Get User's Saved Tracks</a>
     */
    @GET("/me/tracks")
    Call<Paging<SavedTrack>> getUsersSavedTracks(@QueryMap java.util.Map<String, Object> queryParameters);

    /**
     * <h3>Remove Albums for Current User</h3>
     * <p>Remove one or more albums from the current user's 'Your Music' library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-modify</code>
     *
     * @param requestBody <p>The request body</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> Success. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>. Trying to remove an album when you do not have the user's authorization returns error <code>403</code> Forbidden.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-remove-albums-user">Remove Albums for Current User</a>
     */
    @HTTP(method = "DELETE", hasBody = true, path = "/me/albums")
    Call<Void> removeAlbumsUser(@Body RemoveAlbumsUserRequest requestBody);

    /**
     * <h3>Remove User's Saved Episodes</h3>
     * <p>Remove one or more episodes from the current user's library.</p><p>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-modify</code>
     *
     * @param requestBody <p>The request body</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> Success. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>. Trying to remove an episode when you do not have the user's authorization returns error <code>403</code> Forbidden.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-remove-episodes-user">Remove User's Saved Episodes</a>
     */
    @HTTP(method = "DELETE", hasBody = true, path = "/me/episodes")
    Call<Void> removeEpisodesUser(@Body RemoveEpisodesUserRequest requestBody);

    /**
     * <h3>Remove User's Saved Shows</h3>
     * <p>Delete one or more shows from current Spotify user's library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-modify</code>
     *
     * @param ids <p>A comma-separated list of Spotify IDs for the shows to be deleted from the user's library.</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK.
     *         On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#error-details">error object</a>. A <code>403 Forbidden</code> while trying to add a show when you do not have the user's authorisation.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-remove-shows-user">Remove User's Saved Shows</a>
     */
    default Call<Void> removeShowsUser(String ids) {
        return removeShowsUser(ids, null);
    }

    /**
     * <h3>Remove User's Saved Shows</h3>
     * <p>Delete one or more shows from current Spotify user's library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-modify</code>
     *
     * @param ids <p>A comma-separated list of Spotify IDs for the shows to be deleted from the user's library.</p>
     * @param market <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only shows that are available in that market will be removed.<br>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br><em>Note: If neither market or user country are provided, the content is considered unavailable for the client.</em><br>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK.
     *         On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#error-details">error object</a>. A <code>403 Forbidden</code> while trying to add a show when you do not have the user's authorisation.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-remove-shows-user">Remove User's Saved Shows</a>
     */
    @DELETE("/me/shows")
    Call<Void> removeShowsUser(@Query("ids") String ids, @Query("market") String market);

    /**
     * <h3>Remove User's Saved Tracks</h3>
     * <p>Remove one or more tracks from the current user's 'Your Music' library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-modify</code>
     *
     * @param requestBody <p>The request body</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> Success. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>. Trying to remove an album when you do not have the user's authorization returns error <code>403</code> Forbidden.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-remove-tracks-user">Remove User's Saved Tracks</a>
     */
    @HTTP(method = "DELETE", hasBody = true, path = "/me/tracks")
    Call<Void> removeTracksUser(@Body RemoveTracksUserRequest requestBody);

    /**
     * <h3>Save Albums for Current User</h3>
     * <p>Save one or more albums to the current user's 'Your Music' library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-modify</code>
     *
     * @param requestBody <p>The request body</p>
     * @return <p>On success, the HTTP status code in the response header is <code>201</code> Created. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>. Trying to add an album when you do not have the user's authorization returns error <code>403</code> Forbidden.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-save-albums-user">Save Albums for Current User</a>
     */
    @PUT("/me/albums")
    Call<Void> saveAlbumsUser(@Body SaveAlbumsUserRequest requestBody);

    /**
     * <h3>Save Episodes for User</h3>
     * <p>Save one or more episodes to the current user's library.</p><p>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-modify</code>
     *
     * @param requestBody <p>The request body</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>. Trying to add an episode when you do not have the user's authorization, returns error <code>403</code> Forbidden.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-save-episodes-user">Save Episodes for User</a>
     */
    @PUT("/me/episodes")
    Call<Void> saveEpisodesUser(@Body SaveEpisodesUserRequest requestBody);

    /**
     * <h3>Save Shows for Current User</h3>
     * <p>Save one or more shows to current Spotify user's library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-modify</code>
     *
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. Maximum: 50 IDs.</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#error-details">error object</a>. A <code>403 Forbidden</code> while trying to add a show when you do not have the user's authorisation or when the user already has have over 10,000 items saved in library.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-save-shows-user">Save Shows for Current User</a>
     */
    @PUT("/me/shows")
    Call<Void> saveShowsUser(@Query("ids") String ids);

    /**
     * <h3>Save Tracks for User</h3>
     * <p>Save one or more tracks to the current user's 'Your Music' library.</p>
     * <h3>Required OAuth scopes</h3>
     * <code>user-library-modify</code>
     *
     * @param requestBody <p>The request body</p>
     * @return <p>On success, the HTTP status code in the response header is <code>200</code> OK. On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a> and the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>. Trying to add a track when you do not have the user's authorization, or when you have over 10.000 tracks in Your Music, returns error <code>403</code> Forbidden.</p>
     * @see <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-save-tracks-user">Save Tracks for User</a>
     */
    @PUT("/me/tracks")
    Call<Void> saveTracksUser(@Body SaveTracksUserRequest requestBody);
}
