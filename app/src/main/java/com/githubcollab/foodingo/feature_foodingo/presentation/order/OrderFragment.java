package com.githubcollab.foodingo.feature_foodingo.presentation.order;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.githubcollab.foodingo.databinding.OrderFragmentBinding;
import com.google.android.material.tabs.TabLayout;

public class OrderFragment extends Fragment {

    private OrderFragmentBinding binding;

    private OrderViewModel mViewModel;

    public static OrderFragment newInstance() {
        return new OrderFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = OrderFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        TabLayout tabLayout = binding.tabLayout;
        tabLayout.addTab(tabLayout.newTab().setText("food"));
        tabLayout.addTab(tabLayout.newTab().setText("self pickup"));
        tabLayout.addTab(tabLayout.newTab().setText("market"));
        tabLayout.addTab(tabLayout.newTab().setText("recipes"));
        tabLayout.addTab(tabLayout.newTab().setText("cafeteria"));
        tabLayout.addTab(tabLayout.newTab().setText("restaurant"));
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}