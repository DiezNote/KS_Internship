package com.dieznote.ks_internship.models;

import com.google.gson.annotations.SerializedName;

public class PokeItem {
    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
