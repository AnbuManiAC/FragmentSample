package com.example.navigationcomponentexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;

public class ChooseRecipientFragment extends Fragment implements View.OnClickListener{

    NavController navController;
    TextInputEditText input_recipient;
    View vm;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("test","CreateView");
        vm =  inflater.inflate(R.layout.fragment_choose_recipient, container, false);
        return vm;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("test","ViewCreated");
        navController = Navigation.findNavController(view);

        view.findViewById(R.id.next_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.next_btn: {
                input_recipient = vm.findViewById(R.id.input_recipient);
                ChooseRecipientFragmentDirections.ActionChooseRecipientFragmentToSpecifyAmountFragment action
                        = ChooseRecipientFragmentDirections.actionChooseRecipientFragmentToSpecifyAmountFragment().setRecipient(input_recipient.getText().toString());
//                Bundle bundle = new Bundle();
//                bundle.putString("recipient",input_recipient.getText().toString());

//                navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment,bundle);
                navController.navigate(action);
            } break;
            case R.id.cancel_btn: getActivity().onBackPressed(); break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("test","resumed");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("test","paused");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("test","stopped");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("test","viewDestroyed");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("test","viewRestored");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("test","Created");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("test","Started");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("test","destroyed");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("test","detached");
    }
}