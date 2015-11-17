package ru.alexp.itschool.vkimages;

import android.app.Application;
import android.content.Context;

import com.vk.sdk.VKSdk;

/**
 * Created by Александр on 17.11.2015.
 */
public class VkImagesApplication extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        VKSdk.initialize(getAppContext());
    }

    public static Context getAppContext() {
        return context;
    }
}
