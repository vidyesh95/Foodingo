package com.githubcollab.foodingo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import com.githubcollab.foodingo.databinding.ActivityMainBinding;
import com.githubcollab.foodingo.feature_foodingo.presentation.order.OrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Initialising Bottom NavigationMenu
        bottomNav = binding.bottomNav;

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(bottomNav, navController);
    }

    @Override
    protected void onResume() {
        SharedPreferences mSharedPreference = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        int theme = mSharedPreference.getInt(OrderFragment.SHARED,0);
        AppCompatDelegate.setDefaultNightMode(theme);
        super.onResume();
    }
}