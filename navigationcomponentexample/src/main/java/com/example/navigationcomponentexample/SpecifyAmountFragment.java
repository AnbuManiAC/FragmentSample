package com.example.navigationcomponentexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class SpecifyAmountFragment extends Fragment implements View.OnClickListener{

    NavController navController;
    String recipient;
    TextInputEditText amount;
    TextView name;
    View vm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vm = inflater.inflate(R.layout.fragment_specify_amount, container, false);
        return vm;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        navController = Navigation.findNavController(view);

        recipient = getArguments().getString("recipient");

        name = vm.findViewById(R.id.recipient);
        name.setText("Sending to "+recipient);

        recipient = SpecifyAmountFragmentArgs.fromBundle(getArguments()).getRecipient();

        name.setText("Sending money to "+recipient);

        view.findViewById(R.id.send_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.send_btn: {

                amount = vm.findViewById(R.id.input_amount);
//                Bundle bundle = new Bundle();
//                bundle.putString("recipient",recipient);
//                bundle.putInt("amount",Integer.parseInt(amount.getText().toString()));

                SpecifyAmountFragmentDirections.ActionSpecifyAmountFragmentToConfirmationFragment action
                        = SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment().setRecipient(recipient).setAmount(Integer.parseInt(amount.getText().toString()));

//                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,bundle);

                navController.navigate(action);
            } break;
            case R.id.cancel_btn: getActivity().onBackPressed(); break;
        }
    }
}