package com.greentech.quran.hardware;

import android.graphics.drawable.Drawable;

/**
 * Created by Umerfarooq on 8/11/2017.
 */

public class AppList {

    private String name;
    Drawable icon;

    public AppList(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }
}