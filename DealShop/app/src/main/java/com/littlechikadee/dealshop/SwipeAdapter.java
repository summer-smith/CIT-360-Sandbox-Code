package com.littlechikadee.dealshop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Summer on 2/6/2016.
 */
public class SwipeAdapter extends FragmentStatePagerAdapter{
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new PageFragment();
        int i = 0;
        Bundle bundle = new Bundle();
        bundle.putInt("count",i+1);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}

