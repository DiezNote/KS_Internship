package com.dieznote.ks_internship.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dieznote.ks_internship.Listeners.ButtonSelectListener;
import com.dieznote.ks_internship.Listeners.OnTaskRecyclerItemClickListener;
import com.dieznote.ks_internship.MainActivity;
import com.dieznote.ks_internship.adapters.TaskRecyclerAdapter;
import com.dieznote.ks_internship.models.Person;
import com.dieznote.ks_internship.R;

import java.util.ArrayList;


public class FirstFragment extends Fragment {

    ArrayList<Person> persons;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    TaskRecyclerAdapter adapter;
    private static final String TAG = MainActivity.class.getSimpleName();


    private ButtonSelectListener buttonSelectListener;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, " OnCreate Fragment ");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        Log.e(TAG, " onAttach Fragment ");
        super.onAttach(context);
        try {
            buttonSelectListener = (ButtonSelectListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "A!");
        }
    }

    @Override
    public void onStart() {
        Log.e(TAG, " onStart Fragment ");
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(TAG, " onCreateView Fragment ");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);


        persons = new ArrayList<>();
        persons.add(new Person("Даниил", "Горпенко", 23, "dieznote@gmail.com"));
        persons.add(new Person("Даниил1", "Горпенко1", 23, "dieznote1@gmail.com"));
        persons.add(new Person("Даниил2", "Горпенко2", 23, "dieznote2@gmail.com"));
        persons.add(new Person("Даниил3", "Горпенко3", 23, "dieznote3@gmail.com"));
        persons.add(new Person("Даниил4", "Горпенко4", 23, "dieznote4@gmail.com"));
        persons.add(new Person("Даниил5", "Горпенко5", 23, "dieznote5@gmail.com"));
        persons.add(new Person("Даниил6", "Горпенко", 23, "dieznote@gmail.com"));
        persons.add(new Person("Даниил7", "Горпенко1", 23, "dieznote1@gmail.com"));
        persons.add(new Person("Даниил8", "Горпенко2", 23, "dieznote2@gmail.com"));
        persons.add(new Person("Даниил9", "Горпенко3", 23, "dieznote3@gmail.com"));
        persons.add(new Person("Даниил10", "Горпенко4", 23, "dieznote4@gmail.com"));
        persons.add(new Person("Даниил11", "Горпенко5", 23, "dieznote5@gmail.com"));

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new TaskRecyclerAdapter(persons, getContext());

        adapter.setListener(new OnTaskRecyclerItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {

                buttonSelectListener.onOkButtonSelected(persons.get(position));
            }
        });

        recyclerView.setAdapter(adapter);

        return v;
    }
}
