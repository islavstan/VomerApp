package com.islavdroid.vomerapp;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.daimajia.androidanimations.library.fading_entrances.FadeInLeftAnimator;
import com.daimajia.swipe.util.Attributes;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
 public class SwipeFragmentUsers extends Fragment {


    private ArrayList<Users> userList;


    private RecyclerView mRecyclerView;
     FloatingActionMenu fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.recycler_for_swipe, container, false);

    //    tvEmptyView = (TextView)v. findViewById(R.id.empty_view);
        mRecyclerView = (RecyclerView)v. findViewById(R.id.my_recycler_view);

        // Layout Managers:
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));

        // Item Decorator:
      //  mRecyclerView.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.divider)));
      //  mRecyclerView.setItemAnimator(new FadeInLeftAnimator());


        userList = new ArrayList<Users>();

      /*  if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Android Students");

        }*/



        fab=(FloatingActionMenu)getActivity().findViewById(R.id.menu_fab );
        fab.setMenuButtonShowAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.fab_scale_up));
        fab.setMenuButtonHideAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.fab_scale_down));
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>0){
                    fab.hideMenuButton(true);
                }
                else fab.showMenuButton(true);
            }
        });









        loadData();

      /*  if (mDataSet.isEmpty()) {
            mRecyclerView.setVisibility(View.GONE);
            tvEmptyView.setVisibility(View.VISIBLE);

        } else {
            mRecyclerView.setVisibility(View.VISIBLE);
            tvEmptyView.setVisibility(View.GONE);
        }*/


        // Creating Adapter object
        SwipeRecyclerViewAdapter mAdapter = new SwipeRecyclerViewAdapter(getActivity(), userList);


        // Setting Mode to Single to reveal bottom View for one item in List
        // Setting Mode to Mutliple to reveal bottom Views for multile items in List
        ((SwipeRecyclerViewAdapter) mAdapter).setMode(Attributes.Mode.Single);

        mRecyclerView.setAdapter(mAdapter);

        /* Scroll Listeners */
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("RecyclerView", "onScrollStateChanged");
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return v;
    }


    // load initial data
    public void loadData() {

        Users users =new Users("Василий Петров","+3000.3333333",R.drawable.a);
        userList.add(users);
        users =new Users( "Людмила Кирсовна", "+3000.0000001", R.drawable.b);
        userList.add(users);
        users =new Users( "Татьяна Анькова", "+3000.92548484", R.drawable.c);
        userList.add(users);
        users =new Users( "Дмитрий Петров", "+3000.405599", R.drawable.d);
        userList.add(users);
        users =new Users("Юлия Котиковна", "+3000.9696878", R.drawable.g);
        userList.add(users);
        users =new Users( "Сергей Ефремов", "+3000.4040507", R.drawable.n);
        userList.add(users);
        users =new Users( "Людмила Кирсовна", "+3000.0000001", R.drawable.b);
        userList.add(users);
        users =new Users( "Татьяна Анькова", "+3000.92548484", R.drawable.c);
        userList.add(users);
        users =new Users( "Дмитрий Петров", "+3000.405599", R.drawable.d);
        userList.add(users);
        users =new Users("Юлия Котиковна", "+3000.9696878", R.drawable.g);
        userList.add(users);
        users =new Users( "Сергей Ефремов", "+3000.4040507", R.drawable.n);
        userList.add(users);
        }


    }

