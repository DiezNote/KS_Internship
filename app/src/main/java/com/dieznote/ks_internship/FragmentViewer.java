package com.dieznote.ks_internship;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewer extends Fragment {

    //private AppCompatImageView imageView;
    private TextView textView;

    public FragmentViewer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second, container, false);
       // imageView = v.findViewById(R.id.image_view);
        textView = v.findViewById(R.id.secondFragmentTxt);
        return v;
    }

    public void displayText(String string) {
        textView.setText(string);
    }

}
