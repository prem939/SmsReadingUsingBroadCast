package com.example.smsreadingusingbroadcast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements OnBackPressedListner {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public boolean onBackPressed() {
        Toast.makeText(getActivity(),"OnBackpress Click", Toast.LENGTH_LONG).show();
        return false;
    }
}