package com.example.fragmentcontainerviewsample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DemoFragment2 extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo2, container, false);
        textView = view.findViewById(R.id.printNum);
        return view;
    }

    public void printNumber(int i) {
        textView.setText(String.valueOf(i));
    }
}