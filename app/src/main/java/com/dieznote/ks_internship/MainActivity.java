package com.dieznote.ks_internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dieznote.ks_internship.Fragments.FirstFragment;
import com.dieznote.ks_internship.Fragments.SecondFragment;
import com.dieznote.ks_internship.Listeners.ButtonSelectListener;
import com.dieznote.ks_internship.Listeners.OnTaskRecyclerItemClickListener;
import com.dieznote.ks_internship.models.NetResponse;
import com.dieznote.ks_internship.models.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ButtonSelectListener {

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    boolean inLandscapeMode;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        inLandscapeMode = findViewById(R.id.fragment_2) != null;

        firstFragment = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_1);
        if (inLandscapeMode) {
            secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_2);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(NetResponse response) {
        if (inLandscapeMode) {
            //показать в фрагменте справа

            secondFragment.displayPersonInfo(response);
        } else {
            //передать в фрагменте в новом активити

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("pokeNameString", response.getName());
            intent.putExtra("pokeTypeString", response.getPokeTypes().get(0).getType().getName());
            intent.putExtra("pokeHeightString", response.getHeight());
            intent.putExtra("pokeWeightString", response.getWeight());
            intent.putExtra("pokeSpeciesString", response.getPokeSpecies().getName());
            intent.putExtra("pokeIdString", response.getId());
            intent.putExtra("pokeUrlString", response.getPokeForms().get(0).getUrl());
            intent.putExtra("pokeIconString", response.getPokeSprites().getFront_default());
            startActivity(intent);
        }
    }
}
