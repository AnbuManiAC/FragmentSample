package com.example.fragmentresultapi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

    View mView1;
    EditText num1,num2;
    Button submit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView1 = inflater.inflate(R.layout.fragment_1, container, false);
        return mView1;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submit = view.findViewById(R.id.Submit);
        num1 = view.findViewById(R.id.num1);
        num2 = view.findViewById(R.id.num2);

        submit.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Bundle bundle = new Bundle();
                      bundle.putString("num1",num1.getText().toString());
                      bundle.putString("num2",num2.getText().toString());
                      getParentFragmentManager().setFragmentResult("result", bundle);
                  }
              }
        );
    }
}