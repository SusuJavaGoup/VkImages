package ru.alexp.itschool.vkimages;

import android.net.Uri;

/**
 * Created by Александр on 16.11.2015.
 */
public class VkImage {
    private final String title;
    private String descr;
    private final int timestamp;
    private int[] coords;
    private final Uri image;

    public VkImage(String title, int timestamp, Uri image) {
        this.title = title;
        this.timestamp = timestamp;
        this.image = image;
    }

    public VkImage setCoords(int[] coords) {
        this.coords = coords;
        return this;
    }

    public VkImage setDescription(String descr) {
        this.descr = descr;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return descr;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int[] getCoords() {
        return coords;
    }

    public Uri getURI() {
        return image;
    }
}
