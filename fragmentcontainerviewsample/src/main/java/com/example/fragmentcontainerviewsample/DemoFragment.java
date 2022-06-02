package com.example.fragmentcontainerviewsample;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DemoFragment extends Fragment {

    private DemoFragmentListener demoFragmentListener;
    Button add;
    EditText num1,num2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_demo, container, false);

        add = view.findViewById(R.id.add);
        num1 = view.findViewById(R.id.num1);
        num2 = view.findViewById(R.id.num2);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()){
                    Toast.makeText(getContext(),"Provide input numbers",Toast.LENGTH_SHORT).show();
                }
                else{

                    int n1 = Integer.parseInt(num1.getText().toString());
                    int n2 = Integer.parseInt(num2.getText().toString());

                    demoFragmentListener.messageFromFragment(n1,n2);
                }

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DemoFragmentListener) {
            demoFragmentListener = (DemoFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement DemoFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        demoFragmentListener = null;
    }

    public interface DemoFragmentListener {
        void messageFromFragment(int num1, int num2);
    }
}