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

import java.util.ArrayList;
import java.util.List;


public class ContactsFragment extends Fragment {
    private List<Users> userList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecUserAdapter mAdapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView = (RecyclerView)v.findViewById(R.id.my_recycler_view);
        mAdapter = new RecUserAdapter(getActivity(),userList,R.layout.list_contacts);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        recyclerView.setAdapter(mAdapter);

        prepareUserData();





        return v;
    }

    private void prepareUserData() {

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


    }


}


