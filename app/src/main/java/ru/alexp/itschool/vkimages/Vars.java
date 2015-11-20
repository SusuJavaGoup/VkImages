package ru.alexp.itschool.vkimages;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Александр on 16.11.2015.
 */
public final class Vars {
    private static Map<String, Object> gvars = new HashMap<>();

    public static Map<String, Object> getMap() {
        return gvars;
    }

    public static String getString(String key, String defaultValue) {
        String ret = null;
        try {
            if (gvars.containsKey(key)) {
                ret = gvars.get(key).toString();
            }
        } catch (Exception e) {
        }
        return (ret == null) ? defaultValue : ret;
    }

    public static String getString(String key) {
        return getString(key, null);

    }

    public static Object getObject(String key, Object defaultValue) {
        Object ret = null;
        try {
            if (gvars.containsKey(key)) {
                ret = gvars.get(key);
            }
        } catch (Exception e) {
        }
        return (ret == null) ? defaultValue : ret;
    }

    public static Object getObject(String key) {
        return getString(key, null);

    }

    public static void putValue(String key, String value) {
        gvars.put(key, value);
    }

    public static void putValue(String key, Object value) {
        gvars.put(key, value);
    }

    public static boolean hasKey(String key) {
        return gvars.containsKey(key);
    }
}
