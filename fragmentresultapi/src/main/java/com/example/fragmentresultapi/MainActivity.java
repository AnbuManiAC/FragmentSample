package com.example.fragmentresultapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        result = findViewById(R.id.resultTv);

        fragmentManager.setFragmentResultListener("result", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String n1 = result.getString("num1");
                String n2 = result.getString("num2");
                Fragment2 fragment2 = new Fragment2(n1, n2);
                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment2)
                        .addToBackStack("fragment2").commit();
            }
        });


    }
}