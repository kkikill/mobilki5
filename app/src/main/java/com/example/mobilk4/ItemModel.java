package com.example.mobilk4;

public class ItemModel {
    private int imageResId;
    private String name;

    public ItemModel(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }
}
