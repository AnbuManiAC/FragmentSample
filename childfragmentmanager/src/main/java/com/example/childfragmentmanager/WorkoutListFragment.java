package com.example.childfragmentmanager;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutListFragment extends ListFragment {

    static interface WorkoutListListener {
        void itemClick(long id);
    }

    private WorkoutListListener workoutListListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.workoutListListener = (WorkoutListListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[Workout.workouts.length];
        for (int i=0;i<names.length;i++){
            names[i] = Workout.workouts[i].getName();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1,names);
        setListAdapter(arrayAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if(workoutListListener!=null)
            workoutListListener.itemClick(id);
    }
}