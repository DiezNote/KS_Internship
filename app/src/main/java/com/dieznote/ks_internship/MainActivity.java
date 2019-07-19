package com.dieznote.ks_internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dieznote.ks_internship.Fragments.FirstFragment;
import com.dieznote.ks_internship.Fragments.SecondFragment;
import com.dieznote.ks_internship.Listeners.ButtonSelectListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ButtonSelectListener {

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    //private ButtonSelectListener buttonSelectListener;
    boolean inLandscapeMode;

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inLandscapeMode = findViewById(R.id.fragment2) != null;

        firstFragment = (FirstFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_1);
        if (inLandscapeMode) {
            secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        }

    }

    /*private void onClick(Person person) {

        if (inLandscapeMode) {
            secondFragment.displayPersonInfo(person);
        } else {
            Intent viewIntent = new Intent(MainActivity.this, SecondActivity.class);
            viewIntent.putExtra("person", person);
            startActivity(viewIntent);
        }
/*
        String stringFirstName = "";
        String stringLastName = "";
        int intAge = 0;
        int isOk = 0;

        if (firstName.getText().toString().trim().isEmpty()) {
            firstName.setError("Empty!");
        } else {
            isOk++;
            stringFirstName = firstName.getText().toString().trim();
        }
        if (lastName.getText().toString().trim().isEmpty()) {
            lastName.setError("Empty!");
        } else {
            isOk++;
            stringLastName = lastName.getText().toString().trim();
        }
        if (age.getText().toString().trim().isEmpty()) {
            age.setError("Empty!");
        } else {
            isOk++;
            intAge = Integer.valueOf(age.getText().toString().trim());
        }
        if (isOk > 2) {

            Person person = new Person(firstName.getText().toString().trim(), lastName.getText().toString().trim(), Integer.valueOf(age.getText().toString().trim()));

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("PersonObject",person);
            intent.putExtra("FirstName", stringFirstName);
            intent.putExtra("LastName", stringLastName);
            intent.putExtra("Age", intAge);

            Log.w(TAG, stringFirstName + " " + stringLastName + " " + intAge);
            Log.w(TAG, person.toString());

            startActivity(intent);

        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Проверьте все поля", Toast.LENGTH_SHORT);
            toast.show();
        }*/

    /*}*/

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_EMAIL, emailText);
        outState.putString(KEY_PASSWORD, passText);
        outState.putBoolean(KEY_SOUL_TRADE, soulChecked);
        outState.putBoolean(KEY_SPAM_AGREED, spamChecked);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // This One Called after "onStart()". "savedInstanceState" guaranteed not to be null.
        super.onRestoreInstanceState(savedInstanceState);
    }*/
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
    public void onOkButtonSelected(Person person) {
        if (inLandscapeMode) {
            secondFragment.displayPersonInfo(person);
        } else {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("person", person);
            startActivity(intent);
        }
    }
}
