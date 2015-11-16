package ru.alexp.itschool.vkimages;

import java.util.ArrayList;

/**
 * Created by Александр on 16.11.2015.
 */
public class ImageManager {
    private ArrayList<VkImage> images = new ArrayList<>();

    public void parseImages() {
        /**
         * Тут происходит магия
         * и массив заполняется.
         */
    }

    public ArrayList<VkImage> getImages() {
        return images;
    }

    public boolean hasImages() {
        return images.size() > 0;
    }
}
