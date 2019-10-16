package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class BoatModel implements BoatContract.IBoatModel {
    private SharedPreferences userSettings;
    private final String nameSettings = "userSettings";

    BoatModel(Context context) {
        userSettings = context.getSharedPreferences(nameSettings, Context.MODE_PRIVATE);
    }

    @Override
    public boolean getSettings() {
        return userSettings.getBoolean(nameSettings, false);
    }

    @Override
    public void setSettings(boolean settings) {
        userSettings.edit().putBoolean("switchBoat", settings).apply();
    }
}
