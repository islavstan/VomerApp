package com.islavdroid.vomerapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


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
                SwipeFragmentUsers swipeFragmentStudent =new SwipeFragmentUsers();
                return swipeFragmentStudent;
              /*  ContactsFragment tab3 = new ContactsFragment();
                return tab3;*/

          /*  case 3:
                MyPageFragment tab4 =new MyPageFragment();
                return tab4;*/
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return mNumOfTabs;
    }



}


