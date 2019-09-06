package com.padcmyanmar.padc9.assignment_5.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.padcmyanmar.padc9.assignment_5.fragments.TopCollectionFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0){
            return new TopCollectionFragment();
        }else if(i == 1){
            return new TopCollectionFragment();
        }else return new TopCollectionFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return  "Top Collection";
        }else if(position == 1){
            return "Near me";
        }else return "Low to high price";
    }
}
