package com.gpaddy.module.model;

import com.google.gson.annotations.SerializedName;

public class DataSendo {
    @SerializedName("data")
    private ItemSendo data;

    @SerializedName("error")
    private String error;

    public ItemSendo getItem() {
        return data;
    }
}
