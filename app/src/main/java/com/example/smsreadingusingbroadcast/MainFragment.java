package com.example.smsreadingusingbroadcast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

import java.util.List;


public class MainFragment extends AppCompatActivity {
    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button btnBack;
    private static final String BACK_STACK_ROOT_TAG = "root_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        frameLayout=(FrameLayout)findViewById(R.id.frameLayout);
        btnBack=(Button) findViewById(R.id.btnBack);

        fragment = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(BACK_STACK_ROOT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(BACK_STACK_ROOT_TAG);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new HomeFragment();
                        break;
                    case 1:
                        fragment = new JavaFragment();
                        break;
                    case 2:
                        fragment = new AndroidFragment();
                        break;
                    case 3:
                        fragment = new PhpFragment();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout, fragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() { List<Fragment> f = getSupportFragmentManager().getFragments();
//        if(f.get(f.size()-1) != null && f.get(f.size()-1) instanceof HomeFragment)
//            ((HomeFragment)f.get(f.size()-1)).onBackPressed();
//        else if(f.get(f.size()-1) != null && f.get(f.size()-1) instanceof PhpFragment)
//            ((PhpFragment)f.get(f.size()-1)).onBackPressed();
//        else if(f.get(f.size()-1) != null && f.get(f.size()-1) instanceof JavaFragment)
//            ((JavaFragment)f.get(f.size()-1)).onBackPressed();
//        else if(f.get(f.size()-1) != null && f.get(f.size()-1) instanceof AndroidFragment)
//            ((AndroidFragment)f.get(f.size()-1)).onBackPressed();
//            f.remove(f.get(f.size()-1));
        super.onBackPressed();

    }
}
