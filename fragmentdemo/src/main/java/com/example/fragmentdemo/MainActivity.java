package com.example.fragmentdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentActionListener{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    String selectedCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.activity_main_potrait)!=null){
            if(savedInstanceState!=null){
                addCountryDescriptionFragment(savedInstanceState.getString("Selected country",null));
            }
            else{
                addCountriesFragment();
            }
        }
        else if(findViewById(R.id.activity_main_landscape)!=null){
            addCountriesFragment();
            if(savedInstanceState!=null){
                addCountryDescriptionFragment(R.id.fragmentContainer2,savedInstanceState.getString("Selected country",null));
            }
            else{
                addCountryDescriptionFragment(R.id.fragmentContainer2,"India");
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Selected country", selectedCountry);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        selectedCountry = savedInstanceState.getString("Selected country", "India");
    }

    private void addCountriesFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        CountriesFragment countriesFragment = new CountriesFragment();
        countriesFragment.setFragmentActionListener(this);

        fragmentTransaction.add(R.id.fragmentContainer,countriesFragment);
        fragmentTransaction.commit();
    }

    private void addCountryDescriptionFragment(String countryName){
        fragmentTransaction = fragmentManager.beginTransaction();
        CountryDescriptionFragment countryDescriptionFragment = new CountryDescriptionFragment();

        Bundle bundle = new Bundle();
        bundle.putString(FragmentActionListener.SELECTED_COUNTRY,countryName);
        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void addCountryDescriptionFragment(int fragmentContainerId, String countryName){
        fragmentTransaction=fragmentManager.beginTransaction();

        CountryDescriptionFragment countryDescriptionFragment=new CountryDescriptionFragment();


        Bundle bundle=new Bundle();
        bundle.putString(FragmentActionListener.SELECTED_COUNTRY,countryName);
        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(fragmentContainerId,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onCountrySelected(String country) {
        selectedCountry = country;
        if(findViewById(R.id.activity_main_landscape) == null){
            addCountryDescriptionFragment(country);
        }else{
            addCountryDescriptionFragment(R.id.fragmentContainer2,country);
        }
    }
}