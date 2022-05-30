package com.example.navigationcomponentexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ConfirmationFragment extends Fragment {

    View view;
    TextView confirmMsg;
    String recipient;
    int amount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_confirmation, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recipient = getArguments().getString("recipient");
        amount = getArguments().getInt("amount");

        confirmMsg = view.findViewById(R.id.confirmation_message);
        confirmMsg.setText("$"+amount+" was sent to "+recipient);

        recipient = ConfirmationFragmentArgs.fromBundle(getArguments()).getRecipient();
        amount = ConfirmationFragmentArgs.fromBundle(getArguments()).getAmount();

        confirmMsg.setText("$"+amount+" was sent to Mr. "+recipient);
    }
}