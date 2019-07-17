package com.dieznote.ks_internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView Ans;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Ans = findViewById(R.id.textViewAns);
        intent = getIntent();

        Person person = intent.getParcelableExtra("PersonObject");

        Ans.setText(person.toString());
        //Ans.setText("Имя: "+getIntent().getStringExtra("FirstName")+"\n"+"Фамилия: "+getIntent().getStringExtra("LastName")+"\n"+"Возраст: "+String.valueOf(getIntent().getIntExtra("Age",0)));
    }
    public void onClick(View view){
        finish();
    }
}
