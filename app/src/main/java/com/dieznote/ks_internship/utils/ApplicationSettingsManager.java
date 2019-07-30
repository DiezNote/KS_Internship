package com.dieznote.ks_internship.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.dieznote.ks_internship.api.RestClient;
import com.dieznote.ks_internship.models.NetResponse;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ApplicationSettingsManager {

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(Consts.PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static void setSearchByUserEnabled(Context context, boolean isEnabled) {
        getPrefs(context).edit().putBoolean(Consts.PREFS_POKE, isEnabled).apply();
    }

    public static boolean isSearchByUserEnabled(Context context) {
        return getPrefs(context).getBoolean(Consts.PREFS_POKE, false);
    }

    public static void setDontClearListEnabled(Context context, boolean isEnabled) {
        getPrefs(context).edit().putBoolean(Consts.PREFS_DONT_CLEAR_LIST, isEnabled).apply();
    }

    public static boolean isDontClearListEnabled(Context context) {
        return getPrefs(context).getBoolean(Consts.PREFS_DONT_CLEAR_LIST, false);
    }

    public static void cacheLoadedItems(Context context, List<NetResponse> items) {
        getPrefs(context).edit().putString(Consts.PREFS_POKE_LIST, RestClient.getInstance().getGson().toJson(items)).apply();
    }

    public static List<NetResponse> getCachedItems(Context context) {

        Type listType = new TypeToken<List<NetResponse>>() {
        }.getType();

        return RestClient.getInstance().getGson().fromJson(getPrefs(context).getString(Consts.PREFS_POKE_LIST, ""), listType);
    }

}
