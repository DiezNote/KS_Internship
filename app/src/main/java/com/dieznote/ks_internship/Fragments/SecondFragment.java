package com.dieznote.ks_internship.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dieznote.ks_internship.models.NetResponse;
import com.dieznote.ks_internship.R;
import com.dieznote.ks_internship.utils.Consts;


public class SecondFragment extends Fragment {

    // private Person person;
    private TextView pokeName, pokeType, pokeSpecies, pokeHeight, pokeWeight, pokeId, pokeUrl;
    private ImageView pokeIcon;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        pokeName = view.findViewById(R.id.secondFR_Poke_name);
        pokeType = view.findViewById(R.id.secondFR_Last_name);
        pokeSpecies = view.findViewById(R.id.secondFR_age);
        pokeHeight = view.findViewById(R.id.secondFR_height);
        pokeWeight = view.findViewById(R.id.secondFR_weight);
        pokeId = view.findViewById(R.id.secondFR_id);
        pokeUrl = view.findViewById(R.id.secondFR_info);

        pokeIcon = view.findViewById(R.id.secondFR_imageView);

        return view;
    }

    public void displayPersonInfo(NetResponse response) {

        pokeName.setText(response.getName());
        pokeType.setText(response.getPokeTypes().get(0).getType().getName());
        pokeHeight.setText(response.getHeight());
        pokeWeight.setText(response.getWeight());
        pokeSpecies.setText(response.getPokeSpecies().getName());
        pokeId.setText(String.valueOf(response.getId()));
        pokeUrl.setText(response.getPokeForms().get(0).getUrl());
        Glide
                .with(getContext())
                .load(response.getPokeSprites().getFront_default())
                .into(pokeIcon);
    }

    public void displayPersonInfo(String pokeNameString, String pokeTypeString, String pokeHeightString, String pokeWeightString, String pokeSpeciesString, int pokeIdString, String pokeUrlString, String pokeIconString) {

        pokeName.setText(pokeNameString);
        pokeType.setText(pokeTypeString);
        pokeHeight.setText(pokeHeightString);
        pokeWeight.setText(pokeWeightString);
        pokeSpecies.setText(pokeSpeciesString);
        pokeId.setText(String.valueOf(pokeIdString));
        pokeUrl.setText(pokeUrlString);
        Glide
                .with(getContext())
                .load(pokeIconString)
                .into(pokeIcon);
    }

}
