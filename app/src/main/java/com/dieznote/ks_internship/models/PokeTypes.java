package com.dieznote.ks_internship.models;

import com.google.gson.annotations.SerializedName;

public class PokeTypes {
    @SerializedName("slot")
    private String slot;

    @SerializedName("type")
    private PokeType type;

    public PokeTypes(PokeType type) {
        this.type = type;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public PokeType getType() {
        return type;
    }

    public void setType(PokeType type) {
        this.type = type;
    }
}
