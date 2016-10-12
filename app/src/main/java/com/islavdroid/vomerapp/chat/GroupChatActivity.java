package com.islavdroid.vomerapp.chat;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.islavdroid.vomerapp.R;

import com.islavdroid.vomerapp.SimpleDividerItemDecoration;
import com.islavdroid.vomerapp.Users;

import java.util.ArrayList;
import java.util.List;

public class GroupChatActivity extends AppCompatActivity {
    private List<Users> userList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecGroupChatAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Групповой чат");
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mAdapter = new RecGroupChatAdapter(this,userList,R.layout.group_chat_item);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        recyclerView.setAdapter(mAdapter);
        prepareUserData();






}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_group_chat,menu);
        return super.onCreateOptionsMenu(menu);
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
