package com.githubcollab.foodingo.feature_foodingo.presentation.order;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.githubcollab.foodingo.databinding.OrderFragmentBinding;
import com.githubcollab.foodingo.feature_foodingo.presentation.cafeteria.CafeteriaFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.food.FoodFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.market.MarketFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.recipes.RecipesFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.restaurant.RestaurantFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.selfpickup.SelfPickUpFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class OrderFragment extends Fragment {

    private OrderFragmentBinding binding;

    private OrderViewModel mViewModel;

    PagerCollectionAdapter pagerCollectionAdapter;

    ViewPager2 viewPager;

    TabLayout tabLayout;

    FragmentManager fragmentManager;

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

        pagerCollectionAdapter = new PagerCollectionAdapter(this.getChildFragmentManager(), this.getLifecycle());
        pagerCollectionAdapter.addFragment(new FoodFragment(), "food");
        pagerCollectionAdapter.addFragment(new SelfPickUpFragment(), "self pickup");
        pagerCollectionAdapter.addFragment(new MarketFragment(), "market");
        pagerCollectionAdapter.addFragment(new RecipesFragment(), "recipes");
        pagerCollectionAdapter.addFragment(new CafeteriaFragment(), "cafeteria");
        pagerCollectionAdapter.addFragment(new RestaurantFragment(), "restaurant");

        viewPager.setAdapter(pagerCollectionAdapter);
        viewPager.setOffscreenPageLimit(1);

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
        // TODO: Use the ViewModel
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

