package com.githubcollab.foodingo.feature_foodingo.presentation.entertain;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.githubcollab.foodingo.databinding.EntertainFragmentBinding;
import com.githubcollab.foodingo.feature_foodingo.presentation.explore.ExploreViewModel;

public class EntertainFragment extends Fragment {

    private EntertainFragmentBinding binding;

    private EntertainViewModel mViewModel;

    public static EntertainFragment newInstance() {
        return new EntertainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = EntertainFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mViewModel = new ViewModelProvider(this).get(EntertainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}