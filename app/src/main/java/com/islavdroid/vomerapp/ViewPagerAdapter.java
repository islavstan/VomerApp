package com.islavdroid.vomerapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;




    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;


    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MyChatsFragment tab1 = new MyChatsFragment();
                return tab1;
            case 1:
                GroupsFragment tab2 = new GroupsFragment();
                return tab2;
            case 2:
                ContactsFragment tab3 = new ContactsFragment();
                return tab3;
            case 3:
                MyPageFragment tab4 =new MyPageFragment();
                return tab4;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return mNumOfTabs;
    }



}


