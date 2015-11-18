package ru.alexp.itschool.vkimages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridLayout;

import java.util.ArrayList;

public class ImageWeaverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_weaver);
        loadImages();
    }

    private void loadImages() {
        GridLayout grid = (GridLayout) findViewById(R.id.grid);
        ArrayList<VkImage> images = ImageManager.getIstance().getImages();
        for (VkImage image : images) {
            grid.addView(image.getImageView(this));
        }
    }
}
