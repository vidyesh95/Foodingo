package com.githubcollab.foodingo.menuFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.githubcollab.foodingo.R;


public class SpaceFragment extends Fragment {


    public SpaceFragment() {
        // Required empty public constructor
    }


    public static SpaceFragment newInstance() {
        SpaceFragment fragment = new SpaceFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_space, container, false);
    }
}