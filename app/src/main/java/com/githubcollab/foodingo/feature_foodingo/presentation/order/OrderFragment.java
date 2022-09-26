package com.githubcollab.foodingo.feature_foodingo.presentation.order;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;
import androidx.viewpager2.widget.ViewPager2;

import com.githubcollab.foodingo.R;
import com.githubcollab.foodingo.databinding.OrderFragmentBinding;
import com.githubcollab.foodingo.feature_foodingo.presentation.cafeteria.CafeteriaFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.food.FoodFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.market.MarketFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.recipes.RecipesFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.restaurant.RestaurantFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.selfpickup.SelfPickUpFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.w3c.dom.Text;

public class OrderFragment extends Fragment {

    private OrderFragmentBinding binding;

    private OrderViewModel mViewModel;

    PagerCollectionAdapter pagerCollectionAdapter;

    ViewPager2 viewPager;

    TabLayout tabLayout;

    MaterialToolbar mToolbar;

    Context mContext;

    public static final String SHARED = "SharedPreference";


    public static OrderFragment newInstance() {
        return new OrderFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = OrderFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        viewPager = binding.orderPager;
        tabLayout = binding.tabLayout;

        mToolbar = binding.toolbar;

        pagerCollectionAdapter = new PagerCollectionAdapter(this.getChildFragmentManager(), this.getLifecycle());
        pagerCollectionAdapter.addFragment(new FoodFragment(), "food");
        pagerCollectionAdapter.addFragment(new SelfPickUpFragment(), "self pickup");
        pagerCollectionAdapter.addFragment(new MarketFragment(), "market");
        pagerCollectionAdapter.addFragment(new RecipesFragment(), "recipes");
        pagerCollectionAdapter.addFragment(new CafeteriaFragment(), "cafeteria");
        pagerCollectionAdapter.addFragment(new RestaurantFragment(), "restaurant");

        viewPager.setAdapter(pagerCollectionAdapter);
        viewPager.setOffscreenPageLimit(1);

        mToolbar.inflateMenu(R.menu.top_app_bar_menu);

        mToolbar.setOnMenuItemClickListener(menuClick);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        new TabLayoutMediator(
                tabLayout, viewPager,
                (tab, position) -> tab.setText(pagerCollectionAdapter.fragmentTitleList.get(position))
        ).attach();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        mContext = context;
        // TODO: Use the ViewModel
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        mContext = null;

    }

    //Menu ItemClick Listener
    Toolbar.OnMenuItemClickListener menuClick = item -> {
        switch (item.getItemId()){
            case R.id.day_night_toggle:

                SharedPreferences mSharedPreference = PreferenceManager.getDefaultSharedPreferences(mContext);
                SharedPreferences.Editor editor = mSharedPreference.edit();

                if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                }
                editor.putInt(SHARED,AppCompatDelegate.getDefaultNightMode());
                editor.apply();
                break;
            case R.id.translate:
                break;
            case R.id.user_profile:
                break;
        }
        return false;
    };

}

