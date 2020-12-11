package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#image-object">ImageObject</a>
 */
@Getter
@Setter
@NoArgsConstructor
public class Image {
    /**
     * <p>The image height in pixels. If unknown: null or not returned.</p>
     */
    private Integer height;
    /**
     * <p>The source URL of the image.</p>
     */
    private String url;
    /**
     * <p>The image width in pixels. If unknown: null or not returned.</p>
     */
    private Integer width;
}