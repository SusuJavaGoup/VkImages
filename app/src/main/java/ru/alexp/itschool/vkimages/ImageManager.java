package ru.alexp.itschool.vkimages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Александр on 16.11.2015.
 */
public class ImageManager {
    private static ImageManager istance;

    private ArrayList<VkImage> images = new ArrayList<>();

    public void parseImages(JSONArray array) throws JSONException {
        images.clear();
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObj = array.getJSONObject(i);
            try {
                final String title = jsonObj.getString("text");
                final int timestamp = jsonObj.getInt("date");
                final JSONArray attachments = jsonObj.getJSONArray("attachments");
                for (int j = 0; j < attachments.length(); j++) {
                    JSONObject attachment = attachments.getJSONObject(j);
                    if (attachment.getString("type").equalsIgnoreCase("photo")) {
                        attachment = attachment.getJSONObject("photo");
                        final int id = attachment.optInt("id", -1);
                        Iterator<String> it = attachment.keys();
                        String field = "";
                        while (it.hasNext()) {
                            String ff = it.next();
                            if (ff.startsWith("photo_")) {
                                field = ff;
                            }
                        }
                        images.add(new VkImage(title, timestamp, id, new URL(attachment.getString(field))));
                    }
                }
            } catch (JSONException | MalformedURLException e) {
                e.printStackTrace();
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

    public VkImage getImageById(int id) {
        for (VkImage image : images) {
            if (image.getId() == id)
                return image;
        }
        return null;
    }
}
