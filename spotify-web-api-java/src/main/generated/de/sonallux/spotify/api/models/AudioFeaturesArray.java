package de.sonallux.spotify.api.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AudioFeaturesArray {
    private java.util.List<AudioFeatures> audio_features;
}