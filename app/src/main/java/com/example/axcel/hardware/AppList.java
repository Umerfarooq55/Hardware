package com.example.axcel.hardware;

import android.graphics.drawable.Drawable;

/**
 * Created by Umerfarooq on 8/11/2017.
 */

public class AppList {

    Drawable icon;
    private String name;

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