package com.dieznote.ks_internship.Fragments;


import android.content.Context;
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

import com.dieznote.ks_internship.Listeners.ButtonSelectListener;
import com.dieznote.ks_internship.Person;
import com.dieznote.ks_internship.R;


public class FirstFragment extends Fragment {

    private EditText firstName, lastName, age;
    private Button btn;
    private Person person;

    private ButtonSelectListener buttonSelectListener;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            buttonSelectListener = (ButtonSelectListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onSomeEventListener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        firstName = v.findViewById(R.id.editTextName);
        lastName = v.findViewById(R.id.editTextLast);
        age = v.findViewById(R.id.editTextAge);
        btn = v.findViewById(R.id.buttonEnter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                    person = new Person(firstName.getText().toString().trim(), lastName.getText().toString().trim(), Integer.valueOf(age.getText().toString().trim()));
                    buttonSelectListener.onOkButtonSelected(person);
                } else {
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                            "Проверьте все поля", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        return v;
    }
}
