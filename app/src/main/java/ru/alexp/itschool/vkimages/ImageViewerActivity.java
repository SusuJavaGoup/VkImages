package ru.alexp.itschool.vkimages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class ImageViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        loadImages();
    }

    private void loadImages() {
        final GridView grid = (GridView) findViewById(R.id.grid);
        final ArrayList<VkImage> images = ImageManager.getIstance().getImages();

        grid.setAdapter(new ImageAdapter(this, images));
    }
}
