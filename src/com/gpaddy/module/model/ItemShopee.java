package com.gpaddy.module.model;
import com.google.gson.annotations.SerializedName;

import java.util.logging.Logger;

public class ItemShopee {
    @SerializedName("itemid")
    private Long itemid;

    @SerializedName("shopid")
    private String shopId;

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("price")
    private Long price;


    public Long getItemid() {
        return itemid;
    }
    public String getShopId() {
        return shopId;
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
