package com.gpaddy.module;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("item")
    private Item item;

    @SerializedName("error")
    private String error;

    public Item getItem() {
        return item;
    }
}
