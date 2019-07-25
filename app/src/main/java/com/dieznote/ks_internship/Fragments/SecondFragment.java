package com.dieznote.ks_internship.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dieznote.ks_internship.models.Person;
import com.dieznote.ks_internship.R;


public class SecondFragment extends Fragment {

    // private Person person;
    private TextView firstname, lastname, age, mail;

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
        firstname = view.findViewById(R.id.secondFR_First_name);
        lastname = view.findViewById(R.id.secondFR_Last_name);
        age = view.findViewById(R.id.secondFR_age);
        mail = view.findViewById(R.id.secondFR_mail);

        return view;
    }

    public void displayPersonInfo(Person person) {
        firstname.setText(person.getFirstName());
        lastname.setText(person.getLastName());
        age.setText(String.valueOf(person.getAge()));
        mail.setText(person.getMail());
    }
}
