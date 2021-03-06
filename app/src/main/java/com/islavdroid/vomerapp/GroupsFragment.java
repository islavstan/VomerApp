package com.islavdroid.vomerapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;


public class GroupsFragment extends Fragment {
    private List<Users> userList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecUserAdapter mAdapter;
    FloatingActionMenu fab;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView = (RecyclerView)v.findViewById(R.id.my_recycler_view);
        mAdapter = new RecUserAdapter(getActivity(),userList,R.layout.list_group);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        recyclerView.setAdapter(mAdapter);
        fab=(FloatingActionMenu)getActivity().findViewById(R.id.menu_fab );
        fab.setMenuButtonShowAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.fab_scale_up));
        fab.setMenuButtonHideAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.fab_scale_down));
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
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
        prepareUserData();





        return v;
    }

    private void prepareUserData() {

        Users users =new Users("Паблик чат","",R.drawable.group);
        userList.add(users);
        users =new Users( "Новости", "Я согласен на помощь!",R.drawable.group);
        userList.add(users);
        users =new Users( "Менеджер ПК...", "",R.drawable.group);
        userList.add(users);
        users =new Users( "Тех. поддержка", "уже работаем",R.drawable.group);
        userList.add(users);
        users =new Users("Тест чат", "привет)",R.drawable.group);
        userList.add(users);
        users =new Users( "Новости", "Я согласен на помощь!",R.drawable.group);
        userList.add(users);
        users =new Users( "Менеджер ПК...", "",R.drawable.group);
        userList.add(users);
        users =new Users( "Тех. поддержка", "уже работаем",R.drawable.group);
        userList.add(users);
        users =new Users("Тест чат", "привет)",R.drawable.group);
        userList.add(users);
    }


}

