package ru.alexp.itschool.vkimages;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Александр on 20.11.2015.
 */
public class ImageAdapter extends BaseAdapter {
    private final ArrayList<VkImage> images;
    private final Context mContext;

    public ImageAdapter(Context c, ArrayList<VkImage> arr) {
        mContext = c;
        images = arr;
    }

    public int getCount() {
        return images.size();
    }

    public Object getItem(int position) {
        return images.get(position).getImageView(mContext);
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(images.get(position).getBitmap());
        return imageView;
    }
}