package com.example.fragmentsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {

    String TAG = "msg";
    String className = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,className+" OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestart() {
        Log.i(TAG,className+" OnRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i(TAG,className+" OnStart");

        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,className+" OnResume");

        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,className+" OnPause");

        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,className+" OnStop");

        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i(TAG,className+" OnSave");

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.i(TAG,className+" OnRestore");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,className+" OnDestroy");

        super.onDestroy();
    }
}