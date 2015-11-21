package ru.alexp.itschool.vkimages;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

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
    private ImageView iv;
    private final int id;

    public VkImage(String title, int timestamp, int id, URL image) {
        this.title = title;
        this.timestamp = timestamp;
        this.url = image;
        this.id = id;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bitmap getBitmap() {
        if (bitmap == null)
            createBitmap();
        return bitmap;
    }

    public ImageView getImageView(final Context context) {
        if (iv == null) {
            iv = new ImageView(context);
            iv.setImageBitmap(getBitmap());
            iv.setClickable(true);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SingleImageViewerActivity.class);
                    intent.putExtra("imgToShow", getId());
                    context.startActivity(intent);
                }
            });
        }
        return iv;
    }

    public int getId() {
        return id;
    }
}
