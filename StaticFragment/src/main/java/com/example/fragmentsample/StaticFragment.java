package com.example.fragmentsample;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StaticFragment extends Fragment {

    String TAG = "msg";
    String className = StaticFragment.class.getSimpleName();

    @Override
    public void onAttach(@NonNull Context context) {
        Log.i(TAG,className+" OnAttach");

        super.onAttach(context);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG,className+" OnCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i(TAG,className+ " OnSave");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Log.i(TAG,className + " OnRestore");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,className+ " OnViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG,className+" OnCreateView");

        return inflater.inflate(R.layout.fragment_static, container, false);
    }

    @Override
    public void onStart() {
        Log.i(TAG,className+" OnStart");

        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG,className+" OnResume");

        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG,className+" OnPause");

        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG,className+" OnDestroyView");

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,className+" OnDestroy");

        super.onDestroy();
    }


    @Override
    public void onStop() {
        Log.i(TAG,className+" OnStop");

        super.onStop();
    }

    @Override
    public void onDetach() {
        Log.i(TAG,className+" OnDetach");
        super.onDetach();
    }
}