package com.gpaddy.module;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("itemid")
    private Long itemid;


    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("price")
    private Long price;


    public Long getItemid() {
        return itemid;
    }
    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
