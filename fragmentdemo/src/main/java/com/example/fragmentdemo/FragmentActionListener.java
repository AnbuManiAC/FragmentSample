package com.example.fragmentdemo;

import android.os.Bundle;

public interface FragmentActionListener {

    String SELECTED_COUNTRY = "selected_country";

    void onCountrySelected(String country);
}
