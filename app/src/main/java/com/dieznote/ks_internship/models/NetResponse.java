package com.dieznote.ks_internship.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NetResponse {
    //GitResponse

    @SerializedName("abilities")
    private List<PokeAbilities> pokeAbilities;

    @SerializedName("base_experience")
    private String base_experience;

    @SerializedName("forms")
    private List<PokeForms> pokeForms;

    @SerializedName("height")
    private String height;//todo mb i String

    @SerializedName("held_items")
    private List<PokeHeldItems> pokeHeldItems;

    @SerializedName("id")
    private int id;

    @SerializedName("is_default")
    private boolean is_default;

    @SerializedName("location_area_encounters")
    private String location_area_encounters;

    @SerializedName("moves")
    private List<PokeMoves> pokeMoves;

    @SerializedName("name")
    private String name;

    @SerializedName("species")
    private PokeSpecies pokeSpecies;//вид

    @SerializedName("sprites")
    private PokeSprites pokeSprites;

    @SerializedName("stats")
    private List<PokeStats> pokeStats;

    @SerializedName("types")
    private List<PokeTypes> pokeTypes;

    @SerializedName("weight")
    private String weight;

    public List<PokeAbilities> getPokeAbilities() {
        return pokeAbilities;
    }

    public void setPokeAbilities(List<PokeAbilities> pokeAbilities) {
        this.pokeAbilities = pokeAbilities;
    }

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public List<PokeForms> getPokeForms() {
        return pokeForms;
    }

    public void setPokeForms(List<PokeForms> pokeForms) {
        this.pokeForms = pokeForms;
    }
    /*public void setPokeForms(String pokeForms) {
        this.pokeForms.add(new PokeForms(pokeForms));
    }*/

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<PokeHeldItems> getPokeHeldItems() {
        return pokeHeldItems;
    }

    public void setPokeHeldItems(List<PokeHeldItems> pokeHeldItems) {
        this.pokeHeldItems = pokeHeldItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    public void setLocation_area_encounters(String location_area_encounters) {
        this.location_area_encounters = location_area_encounters;
    }

    public List<PokeMoves> getPokeMoves() {
        return pokeMoves;
    }

    public void setPokeMoves(List<PokeMoves> pokeMoves) {
        this.pokeMoves = pokeMoves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokeSpecies getPokeSpecies() {
        return pokeSpecies;
    }

    public void setPokeSpecies(PokeSpecies pokeSpecies) {
        this.pokeSpecies = pokeSpecies;
    }
    public void setPokeSpecies(String stringPokeSpecies) {
        this.pokeSpecies=new PokeSpecies(stringPokeSpecies);
    }

    public PokeSprites getPokeSprites() {
        return pokeSprites;
    }

    public void setPokeSprites(PokeSprites pokeSprites) {
        this.pokeSprites = pokeSprites;
    }
    public void setPokeSprites(String pokeSprites) {
        this.pokeSprites = new PokeSprites(pokeSprites);
    }

    public List<PokeStats> getPokeStats() {
        return pokeStats;
    }

    public void setPokeStats(List<PokeStats> pokeStats) {
        this.pokeStats = pokeStats;
    }

    public List<PokeTypes> getPokeTypes() {
        return pokeTypes;
    }

    public void setPokeTypes(List<PokeTypes> pokeTypes) {
        this.pokeTypes = pokeTypes;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public NetResponse() {

    }
}
