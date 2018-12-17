package com.example.arcus.laboratorijskevjezbe_android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.arcus.laboratorijskevjezbe_android.Fragments.FragmentPersonalInfo;
import com.example.arcus.laboratorijskevjezbe_android.Fragments.FragmentStudentInfo;
import com.example.arcus.laboratorijskevjezbe_android.Fragments.FragmentSummary;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch(position){
            case 0:
                fragment = FragmentPersonalInfo.newInstance();
                break;

            case 1:
                fragment = FragmentStudentInfo.newInstance();
                break;

            case 2:
                fragment = FragmentSummary.newInstance();
                break;
            default:
                return null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
