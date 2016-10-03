package com.islavdroid.vomerapp;

import android.app.SearchManager;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.islavdroid.vomerapp.gallery.GalleryActivity;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class MainActivity extends AppCompatActivity {
    //https://github.com/Clans/FloatingActionButton
  private FloatingActionMenu fab;
    private FloatingActionButton menuFab1,menuFab2,menuFab3;
    private Drawer navigationDrawerLeft;
    private AccountHeader headerNavigationLeft;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);







        TabLayout tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_chat_bubble_white_24dp));
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_forum_white_24dp));
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_person_white_24dp));
        //tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_dehaze_white_24dp));
        final ViewPager view_pager = (ViewPager) findViewById(R.id.pager);
        view_pager.setOffscreenPageLimit(2);
        final ViewPagerAdapter adapter = new ViewPagerAdapter
                (getSupportFragmentManager(), tab_layout.getTabCount());

        view_pager.setAdapter(adapter);

        //NAVIGATION DRAWER

        headerNavigationLeft = new AccountHeaderBuilder().withActivity(this).withCompactStyle(true).
                withSavedInstance(savedInstanceState).withHeaderBackground(R.drawable.green).
                addProfiles(new ProfileDrawerItem().withName("Олег Петров").withEmail("+3000.957.33.77").

                        withIcon(getResources().getDrawable(R.drawable.profile))).build();

        navigationDrawerLeft = new DrawerBuilder().withActivity(this).withToolbar(toolbar).
                withActionBarDrawerToggleAnimated(true).withDrawerGravity(Gravity.LEFT).withSavedInstance(savedInstanceState).
                withSelectedItem(0).withAccountHeader(headerNavigationLeft).build();
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Редактировать личные данные").withIcon(R.drawable.ic_create_black_24dp));

        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Галерея").withIcon(R.drawable.ic_photo_black_24dp).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                Intent intent =new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
                return false;
            }
        }));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Настройки").withIcon(R.drawable.ic_settings_black_24dp));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }
    }

