package com.islavdroid.vomerapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.islavdroid.vomerapp.gallery.DetailImage;
import com.islavdroid.vomerapp.gallery.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;


public class UserInfo extends AppCompatActivity {
    private ImageButton buttonBack;
    private ArrayList<Photo> photoList = new ArrayList<>();
    private RecyclerView recyclerView;

    private RecyclerViewForUserInfo mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//------------------------------recycleview----------------------
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_photo);
        mAdapter = new RecyclerViewForUserInfo(this,photoList,R.layout.photo_row);
       /* LinearLayoutManager horizontalLayoutManagaer
               = new LinearLayoutManager(UserInfo.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(horizontalLayoutManagaer);*/
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));



        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        prepareUserData();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(UserInfo.this, DetailImage.class);
                        intent.putParcelableArrayListExtra("data", photoList);
                        intent.putExtra("pos", position);
                        startActivity(intent);






                    }}));
//------------------------------recycleview----------------------

     /*   buttonBack =(ImageButton)findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });*/
    }

    private void prepareUserData() {
       Photo photo=new Photo(R.drawable.photo1);
        photoList.add(photo);
        photo=new Photo(R.drawable.photo2);
        photoList.add(photo);
        photo=new Photo(R.drawable.photo3);
        photoList.add(photo);
        photo=new Photo(R.drawable.photo4);
        photoList.add(photo);
        photo=new Photo(R.drawable.photo5);
        photoList.add(photo);
    }


}
