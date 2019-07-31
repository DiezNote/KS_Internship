package com.dieznote.ks_internship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dieznote.ks_internship.Fragments.SecondFragment;
import com.dieznote.ks_internship.models.Person;

public class SecondActivity extends AppCompatActivity {

    private SecondFragment itemDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String responseUrl = getIntent().getStringExtra("responseUrl");
        //person = (Person) getIntent().getParcelableExtra("person");
        itemDetailFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_two);
        String pokeNameString = getIntent().getStringExtra("pokeNameString");
        String pokeHeightString = getIntent().getStringExtra("pokeHeightString");
        String pokeWeightString = getIntent().getStringExtra("pokeWeightString");
        String pokeSpeciesString = getIntent().getStringExtra("pokeSpeciesString");
        int pokeIdString = getIntent().getIntExtra("pokeIdString",0);
        String pokeUrlString = getIntent().getStringExtra("pokeUrlString");
        String pokeIconString = getIntent().getStringExtra("pokeIconString");
        itemDetailFragment.displayPersonInfo(pokeNameString,pokeHeightString,pokeWeightString,pokeSpeciesString,pokeIdString,pokeUrlString,pokeIconString);
    }
}
