package com.hiconsolution.streetsop17.models;

/**
 * Created by cresset on 11/08/2017.
 */

public class StoreProductModel {
    private String name;
    private String price;
    private int thumbnail;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
