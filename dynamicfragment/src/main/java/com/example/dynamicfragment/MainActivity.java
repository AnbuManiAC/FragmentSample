package com.example.dynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG = "msg";
    String className = MainActivity.class.getSimpleName();
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    Button addFragment;
    Button popFragment;
    Button removeFragment;
    TextView fragmentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,className+" OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        addFragment = findViewById(R.id.addFragment);
        popFragment = findViewById(R.id.popFragment);
        removeFragment = findViewById(R.id.removeFragment);

        fragmentCount = findViewById(R.id.fragmentCount);

        fragmentCount.setText("Fragment count in back stack: "+fragmentManager.getBackStackEntryCount());

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                fragmentCount.setText("Fragment count in back stack: "+fragmentManager.getBackStackEntryCount());

                StringBuilder backstackEntryMessage = new StringBuilder("Current status of fragment transaction back stack: "+fragmentManager.getBackStackEntryCount()+"\n");

                for(int index=(fragmentManager.getBackStackEntryCount()-1); index>=0; index--){
                    FragmentManager.BackStackEntry entry =  fragmentManager.getBackStackEntryAt(index);
                    backstackEntryMessage.append(entry.getName()+"\n");
                }
                Log.i("backStack",backstackEntryMessage.toString());

            }
        });
        addFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });

        popFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.popBackStackImmediate();
            }
        });

        removeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    void addFragment(){
        Fragment dynamicFragment;

//        switch (fragmentManager.getBackStackEntryCount()){
//            case 0: dynamicFragment = new DynamicFragment1(); break;
//            case 1: dynamicFragment = new DynamicFragment2(); break;
//            case 2: dynamicFragment = new DynamicFragment3(); break;
//            default: dynamicFragment = new DynamicFragment1(); break;
//        }

        dynamicFragment = fragmentManager.findFragmentById(R.id.fragmentLayout);

        if (dynamicFragment instanceof DynamicFragment1) {
            dynamicFragment = new DynamicFragment2();
        } else if (dynamicFragment instanceof DynamicFragment2) {
            dynamicFragment = new DynamicFragment3();
        } else if (dynamicFragment instanceof DynamicFragment3){
            dynamicFragment = new DynamicFragment1();
        }else{
            dynamicFragment = new DynamicFragment1();
        }

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, dynamicFragment, "demoFragment");
        fragmentTransaction.addToBackStack("Replace " +
                "" +
                "" + dynamicFragment.toString());


        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentLayout);
        if(fragment!=null){
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
        else{
            Toast.makeText(this,"No Fragment to remove",Toast.LENGTH_SHORT).show();
            super.onBackPressed();

        }
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
    protected void onDestroy() {
        Log.i(TAG,className+" OnDestroy");

        super.onDestroy();
    }
}