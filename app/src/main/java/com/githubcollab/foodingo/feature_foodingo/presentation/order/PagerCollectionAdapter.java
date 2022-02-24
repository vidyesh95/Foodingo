package com.githubcollab.foodingo.feature_foodingo.presentation.order;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.githubcollab.foodingo.feature_foodingo.presentation.cafeteria.CafeteriaFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.food.FoodFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.market.MarketFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.recipes.RecipesFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.restaurant.RestaurantFragment;
import com.githubcollab.foodingo.feature_foodingo.presentation.selfpickup.SelfPickUpFragment;

public class PagerCollectionAdapter extends FragmentStateAdapter {
    private static final int ITEM_SIZE = 6;

    public PagerCollectionAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    /*private final List<Fragment> fragmentList = new ArrayList<>();

    public final List<String> fragmentTitleList = new ArrayList<>();


    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }*/

    /*public PagerCollectionAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }*/

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new SelfPickUpFragment();
        } else if (position == 2) {
            return new MarketFragment();
        } else if (position == 3) {
            return new RecipesFragment();
        } else if (position == 4) {
            return new CafeteriaFragment();
        } else if (position == 5) {
            return new RestaurantFragment();
        } else {
            return new FoodFragment();
        }
    }

    @Override
    public int getItemCount() {
        return ITEM_SIZE;
    }
    /*private static final int ITEM_SIZE = 6;
    public PagerCollectionAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new FoodFragment();
        } else if (position == 1) {
            return new SelfPickUpFragment();
        }else if (position == 2) {
            return new MarketFragment();
        }else if (position == 3) {
            return new RecipesFragment();
        }else if (position == 4) {
            return new CafeteriaFragment();
        }else {
            return new RestaurantFragment();
        }
    }

    @Override
    public int getItemCount() {
        return ITEM_SIZE;
    }*/
}
