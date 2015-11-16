package ru.alexp.itschool.vkimages;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Александр on 16.11.2015.
 */
public final class Vars {
    private static Map<String, String> gvars = new HashMap<>();

    public static Map<String, String> getMap() {
        return gvars;
    }

    public static String getValue(String key, String defaultValue) {
        String ret = null;
        try {
            if (gvars.containsKey(key)) {
                ret = gvars.get(key);
            }
        } catch (Exception e) {
        }
        return (ret == null) ? defaultValue : ret;
    }

    public static String getValue(String key) {
        return getValue(key, null);
    }

    public static void putValue(String key, String value) {
        gvars.put(key, value);
    }

    public static boolean hasKey(String key) {
        return gvars.containsKey(key);
    }
}
