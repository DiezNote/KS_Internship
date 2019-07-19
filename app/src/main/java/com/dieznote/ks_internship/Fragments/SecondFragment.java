package com.dieznote.ks_internship.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dieznote.ks_internship.Person;
import com.dieznote.ks_internship.R;


public class SecondFragment extends Fragment {

   // private Person person;
    private TextView Ans;
    private Button ok;

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
        Ans =view.findViewById(R.id.secondFragmentTxt);
        ok = view.findViewById(R.id.second_fragment_buttonOk);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }
    public void displayPersonInfo(Person person) {
        Ans.setText(person.toString());
    }
}
