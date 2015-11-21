package ru.alexp.itschool.vkimages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SingleImageViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_image_viewer);

        final ImageView iv = (ImageView)findViewById(R.id.FullImageView);
        final int imageId = getIntent().getExtras().getInt("imgToShow");
        final VkImage image = ImageManager.getIstance().getImageById(imageId);

        iv.setImageBitmap(image.getBitmap());
    }

}
