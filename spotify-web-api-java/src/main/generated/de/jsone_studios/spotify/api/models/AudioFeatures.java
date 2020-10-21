package de.jsone_studios.spotify.api.models;

import lombok.*;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference-beta/#object-audiofeaturesobject">AudioFeaturesObject</a>
 */
@Getter
@Setter
@NoArgsConstructor
public class AudioFeatures {
    /**
     * <p>A confidence measure from 0.0 to 1.0 of whether the track is acoustic. 1.0 represents high confidence the track is acoustic.</p>
     */
    private Float acousticness;
    /**
     * <p>An HTTP URL to access the full audio analysis of this track. An access token is required to access this data.</p>
     */
    private String analysis_url;
    /**
     * <p>Danceability describes how suitable a track is for dancing based on a combination of musical elements including tempo, rhythm stability, beat strength, and overall regularity. A value of 0.0 is least danceable and 1.0 is most danceable.</p>
     */
    private Float danceability;
    /**
     * <p>The duration of the track in milliseconds.</p>
     */
    private Integer duration_ms;
    /**
     * <p>Energy is a measure from 0.0 to 1.0 and represents a perceptual measure of intensity and activity. Typically, energetic tracks feel fast, loud, and noisy. For example, death metal has high energy, while a Bach prelude scores low on the scale. Perceptual features contributing to this attribute include dynamic range, perceived loudness, timbre, onset rate, and general entropy.</p>
     */
    private Float energy;
    /**
     * <p>The Spotify ID for the track.</p>
     */
    private String id;
    /**
     * <p>Predicts whether a track contains no vocals. &quot;Ooh&quot; and &quot;aah&quot; sounds are treated as instrumental in this context. Rap or spoken word tracks are clearly &quot;vocal&quot;. The closer the instrumentalness value is to 1.0, the greater likelihood the track contains no vocal content. Values above 0.5 are intended to represent instrumental tracks, but confidence is higher as the value approaches 1.0.</p>
     */
    private Float instrumentalness;
    /**
     * <p>The key the track is in. Integers map to pitches using standard <a href="https://en.wikipedia.org/wiki/Pitch_class">Pitch Class notation</a> . E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on.</p>
     */
    private Integer key;
    /**
     * <p>Detects the presence of an audience in the recording. Higher liveness values represent an increased probability that the track was performed live. A value above 0.8 provides strong likelihood that the track is live.</p>
     */
    private Float liveness;
    /**
     * <p>The overall loudness of a track in decibels (dB). Loudness values are averaged across the entire track and are useful for comparing relative loudness of tracks. Loudness is the quality of a sound that is the primary psychological correlate of physical strength (amplitude). Values typical range between -60 and 0 db.</p>
     */
    private Float loudness;
    /**
     * <p>Mode indicates the modality (major or minor) of a track, the type of scale from which its melodic content is derived. Major is represented by 1 and minor is 0.</p>
     */
    private Integer mode;
    /**
     * <p>Speechiness detects the presence of spoken words in a track. The more exclusively speech-like the recording (e.g. talk show, audio book, poetry), the closer to 1.0 the attribute value. Values above 0.66 describe tracks that are probably made entirely of spoken words. Values between 0.33 and 0.66 describe tracks that may contain both music and speech, either in sections or layered, including such cases as rap music. Values below 0.33 most likely represent music and other non-speech-like tracks.</p>
     */
    private Float speechiness;
    /**
     * <p>The overall estimated tempo of a track in beats per minute (BPM). In musical terminology, tempo is the speed or pace of a given piece and derives directly from the average beat duration.</p>
     */
    private Float tempo;
    /**
     * <p>An estimated overall time signature of a track. The time signature (meter) is a notational convention to specify how many beats are in each bar (or measure).</p>
     */
    private Integer time_signature;
    /**
     * <p>A link to the Web API endpoint providing full details of the track.</p>
     */
    private String track_href;
    /**
     * <p>The object type: &quot;audio_features&quot;</p>
     */
    private String type;
    /**
     * <p>The Spotify URI for the track.</p>
     */
    private String uri;
    /**
     * <p>A measure from 0.0 to 1.0 describing the musical positiveness conveyed by a track. Tracks with high valence sound more positive (e.g. happy, cheerful, euphoric), while tracks with low valence sound more negative (e.g. sad, depressed, angry).</p>
     */
    private Float valence;
}
