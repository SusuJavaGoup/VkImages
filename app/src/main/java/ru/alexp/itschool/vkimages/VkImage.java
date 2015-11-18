package ru.alexp.itschool.vkimages;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Александр on 16.11.2015.
 */
public class VkImage {
    private final String title;
    private String descr;
    private final int timestamp;
    private int[] coords;
    private final URL url;
    private Bitmap bitmap;

    public VkImage(String title, int timestamp, URL image) {
        this.title = title;
        this.timestamp = timestamp;
        this.url = image;
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

    public URL getURL() {
        return url;
    }

    public void createBitmap() {
        try {
            bitmap = BitmapFactory.decodeStream(getURL().openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getBitmap() {
        if (bitmap == null)
            createBitmap();
        return bitmap;
    }

    public ImageView getImageView(Context context) {
        ImageView iv = new ImageView(context);
        iv.setImageBitmap(getBitmap());
        return iv;
    }
}
