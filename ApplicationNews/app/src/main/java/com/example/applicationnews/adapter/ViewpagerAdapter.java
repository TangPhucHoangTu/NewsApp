package com.example.applicationnews.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.applicationnews.fragment.FragmentNoiBat;
import com.example.applicationnews.fragment.FragmentDoiSong;
import com.example.applicationnews.fragment.FragmentXemNhieu;

public class ViewpagerAdapter extends FragmentPagerAdapter {

        public ViewpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment selectedFragment = new FragmentNoiBat();
            switch (position){
                case 0:
                    selectedFragment = new FragmentNoiBat();
                    break;
                case 1:
                    selectedFragment = new FragmentXemNhieu();
                    break;
                case 2:
                    selectedFragment = new FragmentDoiSong();
                    break;
            }
            return selectedFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

    }
