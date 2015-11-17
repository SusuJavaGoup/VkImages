package ru.alexp.itschool.vkimages;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Александр on 16.11.2015.
 */
public class ImageManager {
    private static ImageManager istance;

    private ArrayList<VkImage> images = new ArrayList<>();

    public void parseImages(JSONArray array) throws JSONException {
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            try {
                final String title = jsonObj.getString("text");
                final int timestamp = jsonObj.getInt("date");
                final JSONArray attachments = jsonObj.getJSONArray("attachments");
                for (int j = 0; j < attachments.length(); j++) {
                    JSONObject attachment = attachments.getJSONObject(j);
                    if (attachment.getString("type").equalsIgnoreCase("photo")) {
                        final int width = attachment.getInt("width");
                        final Uri uri = Uri.parse(attachment.getString("photo_" + width));
                        images.add(new VkImage(title, timestamp, uri));
                    }
                }
            } catch (JSONException e) {
                // просто забей
            }
        }
    }

    public ArrayList<VkImage> getImages() {
        return images;
    }

    public boolean hasImages() {
        return images.size() > 0;
    }

    public static ImageManager getIstance() {
        if (istance == null)
            istance = new ImageManager();

        return istance;
    }
}
