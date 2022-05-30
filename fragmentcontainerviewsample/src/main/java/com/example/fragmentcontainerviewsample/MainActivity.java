package com.example.fragmentcontainerviewsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DemoFragment.DemoFragmentListener{

    DemoFragment2 demoFragment2;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void messageFromFragment(int num1, int num2) {
        demoFragment2 = (DemoFragment2) fragmentManager.findFragmentById(R.id.fragment2);
        demoFragment2.printNumber(num1+num2);

    }
}

