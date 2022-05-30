package com.example.fragmentnav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        Button gotoFrag2 = view.findViewById(R.id.gotoFragment2);
        gotoFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = Fragment1Directions.actionFragment2ToFragment3();

                Navigation.findNavController(v).navigate(R.id.action_fragment2_to_fragment3);
            }
        });
        return view;
    }


}