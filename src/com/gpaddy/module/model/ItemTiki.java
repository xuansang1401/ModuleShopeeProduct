package com.gpaddy.module.model;

import com.google.gson.annotations.SerializedName;

public class ItemTiki {
    @SerializedName("id")
    private Long id;

    @SerializedName("master_id")
    private String masterId;

    @SerializedName("name")
    private String name;

    @SerializedName("thumbnail_url")
    private String image;

    @SerializedName("price")
    private Long price;


    public Long getId() {
        return id;
    }
    public String getMasterId() {
        return masterId;
    }

    public String getName() { return name; }

    public Long getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
