package com.gpaddy.module.model;

import com.google.gson.annotations.SerializedName;

public class ItemSendo {
    @SerializedName("id")
    private Long id;

    @SerializedName("url_key")
    private String urlKey;

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("final_price")
    private Long price;


    public Long getId() {
        return id;
    }
    public String getUrlKey() {
        return urlKey;
    }

    public String getName() { return name; }

    public Long getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
