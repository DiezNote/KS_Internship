package com.dieznote.ks_internship;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btn = getActivity().findViewById(R.id.buttonEnter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String TAG = MainActivity.class.getSimpleName();
                EditText firstName = getActivity().findViewById(R.id.editTextName);
                EditText lastName = getActivity().findViewById(R.id.editTextLast);
                EditText age = getActivity().findViewById(R.id.editTextAge);
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

                    //Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                    //intent.putExtra("PersonObject",person);
                    //intent.putExtra("FirstName", stringFirstName);
                    //intent.putExtra("LastName", stringLastName);
                    //intent.putExtra("Age", intAge);

                    Log.w(TAG, stringFirstName + " " + stringLastName + " " + intAge);
                    Log.w(TAG, person.toString());
                    TextView textView = getActivity().findViewById(R.id.secondFragmentTxt);
                    textView.setText(person.toString());
                    //startActivity(intent);

                } else {
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                            "Проверьте все поля", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

}
