package com.islavdroid.vomerapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class MainActivity extends AppCompatActivity {
    //https://github.com/Clans/FloatingActionButton
  private FloatingActionMenu fab;
    private FloatingActionButton menuFab1,menuFab2,menuFab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_chat_bubble_white_24dp));
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_forum_white_24dp));
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_person_white_24dp));
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_dehaze_white_24dp));
        final ViewPager view_pager = (ViewPager) findViewById(R.id.pager);
        view_pager.setOffscreenPageLimit(3);
        final ViewPagerAdapter adapter = new ViewPagerAdapter
                (getSupportFragmentManager(), tab_layout.getTabCount());

        view_pager.setAdapter(adapter);

        fab = (FloatingActionMenu)findViewById(R.id.menu_fab) ;
        fab.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
              //  Toast.makeText(MainActivity.this,"меню нажали",Toast.LENGTH_SHORT).show();
            }
        });
        menuFab1 =(FloatingActionButton)findViewById(R.id.fab1);
        menuFab2 =(FloatingActionButton)findViewById(R.id.fab2);
        menuFab3 =(FloatingActionButton)findViewById(R.id.fab3);
        menuFab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"кнопка нажата",Toast.LENGTH_SHORT).show();
            }
        });

        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });}
    }

