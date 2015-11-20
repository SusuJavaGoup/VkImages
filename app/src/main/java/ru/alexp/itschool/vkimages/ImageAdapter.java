package ru.alexp.itschool.vkimages;

import android.content.Context;
import android.view.LayoutInflater;
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
    private final Context content;
    private LayoutInflater layoutInflater;

    public ImageAdapter(Context content, ArrayList<VkImage> images) {
        this.content = content;
        this.images = images;
    }

    public int getCount() {
        return images.size();
    }

    public Object getItem(int position) {
        return images.get(position).getImageView(content);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = images.get(position).getImageView(content);
        iv.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, 300));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setPadding(10, 10, 10, 10);
        iv.setImageBitmap(images.get(position).getBitmap());
        return iv;
    }
}