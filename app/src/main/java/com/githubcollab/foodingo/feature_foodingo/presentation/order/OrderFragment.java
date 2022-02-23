package com.githubcollab.foodingo.feature_foodingo.presentation.order;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.githubcollab.foodingo.R;
import com.google.android.material.tabs.TabLayout;

public class OrderFragment extends Fragment {

    private OrderViewModel mViewModel;

    public static OrderFragment newInstance() {
        return new OrderFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_fragment, container, false);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("food"));
        tabLayout.addTab(tabLayout.newTab().setText("self pickup"));
        tabLayout.addTab(tabLayout.newTab().setText("receipes"));
        tabLayout.addTab(tabLayout.newTab().setText("cafe"));
        tabLayout.addTab(tabLayout.newTab().setText("drinks"));
        

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}