package com.githubcollab.foodingo.feature_foodingo.presentation.goout;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.githubcollab.foodingo.R;

public class GoOutFragment extends Fragment {

    private GoOutViewModel mViewModel;

    public static GoOutFragment newInstance() {
        return new GoOutFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.go_out_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GoOutViewModel.class);
        // TODO: Use the ViewModel
    }

}