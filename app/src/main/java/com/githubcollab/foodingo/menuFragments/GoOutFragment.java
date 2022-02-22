package com.githubcollab.foodingo.menuFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.githubcollab.foodingo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GoOutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GoOutFragment extends Fragment {



    public GoOutFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static GoOutFragment newInstance() {
        GoOutFragment fragment = new GoOutFragment();
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
        return inflater.inflate(R.layout.fragment_go_out, container, false);
    }
}