package com.gpaddy.module.model;
import com.google.gson.annotations.SerializedName;

public class DataShopee {
    @SerializedName("item")
    private ItemShopee item;

    @SerializedName("error")
    private String error;

    public ItemShopee getItem() {
        return item;
    }
}
