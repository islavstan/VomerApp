package com.islavdroid.vomerapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;
import java.util.List;


public class MyChatsFragment extends Fragment {
    private List<Users> userList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecUserAdapter mAdapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView = (RecyclerView)v.findViewById(R.id.my_recycler_view);
        mAdapter = new RecUserAdapter(getActivity(),userList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        recyclerView.setAdapter(mAdapter);

        prepareUserData();





        return v;
}

    private void prepareUserData() {

        Users users =new Users("Василий Петров","Привет! Как дела?",R.drawable.vasiliy);
      userList.add(users);
        users =new Users( "Людмила Кирсовна", "Я буду в 8...", R.drawable.ludmila);
        userList.add(users);
        users =new Users( "Татьяна Анькова", "Пора спать))", R.drawable.tatiana);
        userList.add(users);
        users =new Users( "Дмитрий Петров", "Я на работе", R.drawable.dmitriy);
        userList.add(users);
        users =new Users("Юлия Котиковна", "позвони мне в 10", R.drawable.yulia);
        userList.add(users);
        users =new Users( "Сергей Ефремов", "Привет))", R.drawable.dmitriy);
        userList.add(users);
        users =new Users( "Петя Гальцев", "я на встрече", R.drawable.vasiliy);
        userList.add(users);
        users =new Users("Ксюша Андреева", "позвони мне в 10", R.drawable.yulia);
        userList.add(users);
         users =new Users("Василий Васильев","давай",R.drawable.vasiliy);
        userList.add(users);

    }


}




