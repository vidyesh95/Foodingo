package com.githubcollab.foodingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.githubcollab.foodingo.feature_foodingo.presentation.entertain.EntertainFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.explore.ExploreFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.goout.GoOutFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.order.OrderFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.spaces.SpacesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SharedPreference";
    private static final String MY_FRAGMENT = "Select fragment";
    private BottomNavigationView mMenuBottomNavigation;
    private Toolbar mToolbar;
    Fragment selectFragment = null;

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        //Initialising Bottom NavigationMenu
        mMenuBottomNavigation = findViewById(R.id.menuBottomNavigation);
        mMenuBottomNavigation.setOnItemSelectedListener(navigationListener);
            selectFragment = OrderFragment.newInstance();
        if(savedInstanceState!=null){
            selectFragment = getSupportFragmentManager().getFragment(savedInstanceState,MY_FRAGMENT);

        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectFragment).commit();

        }
    }

    //Defining MenuBottomNavigationListener
    private NavigationBarView.OnItemSelectedListener navigationListener
            = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
                    selectFragment = SpacesFragment.newInstance();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectFragment).commit();
            return true;
        }
    };




    //Menu Inflator for toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.toolbarmenu,menu);
         return true;
    }

    // Menu options item selector
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //to check darkmode value
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        switch(item.getItemId()){

            case R.id.darkmode:

                boolean nightmode =  mSharedPreferences.getBoolean(TAG,false);

                //DarkMode Check
                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.P){
                    if(nightmode == false){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
                    nightmode = true;
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putBoolean(TAG,nightmode).apply();
                    }else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        nightmode =false;
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putBoolean(TAG,nightmode).apply();
                    }

                }
                break;
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);
        //Saving instance of fragment so when dark mode isenabled, the page retains the fragment
        getSupportFragmentManager().putFragment(outState,MY_FRAGMENT,selectFragment);
    }

    @Override
    protected void onDestroy() {



        super.onDestroy();
    }
}