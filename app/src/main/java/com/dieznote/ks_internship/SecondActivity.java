package com.dieznote.ks_internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.dieznote.ks_internship.Fragments.SecondFragment;

public class SecondActivity extends AppCompatActivity {

    private Person person;
    private SecondFragment itemDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        person = (Person) getIntent().getParcelableExtra("person");
        itemDetailFragment = (SecondFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_two);
        itemDetailFragment.displayPersonInfo(person);
    }
}
