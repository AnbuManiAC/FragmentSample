package com.example.fragmentresultapi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    View mView2;
    TextView fragresult;

    private String n1,n2;

    public Fragment2(String n1, String n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getParentFragmentManager().setFragmentResultListener("result", this, new FragmentResultListener() {
//            @Override
//            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
//                String n1 = result.getString("num1");
//                String n2 = result.getString("num2");
//                setResult(Integer.parseInt(n1) + Integer.parseInt(n2));
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView2 =  inflater.inflate(R.layout.fragment_2, container, false);
        return mView2;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragresult = mView2.findViewById(R.id.fragresult);
        setResult(Integer.parseInt(n1) + Integer.parseInt(n2));
    }

    public void setResult(int res){
        String ans = "Result is "+res;
        fragresult.setText(ans);
    }
}