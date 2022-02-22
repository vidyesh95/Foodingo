package com.githubcollab.foodingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.githubcollab.foodingo.menuFragments.EntertainFragment;
import com.githubcollab.foodingo.menuFragments.ExploreFragment;
import com.githubcollab.foodingo.menuFragments.GoOutFragment;
import com.githubcollab.foodingo.menuFragments.OrderFragment;
import com.githubcollab.foodingo.menuFragments.SpaceFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMenuBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialising Bottom NavigationMenu
        mMenuBottomNavigation = findViewById(R.id.menuBottomNavigation);
        mMenuBottomNavigation.setOnItemSelectedListener(navigationListener);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,new OrderFragment()).commit();

    }

    //Defining MenuBottomNavigationListener
    private NavigationBarView.OnItemSelectedListener navigationListener
            = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectFragment = null;
            switch (item.getItemId()) {
                case R.id.order:
                    selectFragment = OrderFragment.newInstance();
                    break;
                case R.id.goOut:
                    selectFragment = GoOutFragment.newInstance();
                    break;
                case R.id.entertainment:
                    selectFragment = EntertainFragment.newInstance();
                    break;
                case R.id.explore:
                    selectFragment = ExploreFragment.newInstance();
                    break;
                default:
                    selectFragment = SpaceFragment.newInstance();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectFragment).commit();
            return true;
        }
    };
}