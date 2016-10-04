package com.islavdroid.vomerapp.gallery;


import android.app.SearchManager;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.AdapterView.OnItemClickListener;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.islavdroid.vomerapp.Photo;
import com.islavdroid.vomerapp.R;
import com.islavdroid.vomerapp.RecPhotoAdapter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    ArrayList<Photo> data = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecPhotoAdapter mAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setHasFixedSize(true); // Helps improve performance
        mAdapter = new RecPhotoAdapter(GalleryActivity.this, data, R.layout.gallery_item);
        mRecyclerView.setAdapter(mAdapter);
        prepareUserData();
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(GalleryActivity.this, DetailImage.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);
                        //overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    }
                }));



    }
    private void prepareUserData() {
        Photo photo=new Photo(R.drawable.photo1);
        data.add(photo);
        photo=new Photo(R.drawable.photo2);
        data.add(photo);
        photo=new Photo(R.drawable.photo3);
        data.add(photo);
        photo=new Photo(R.drawable.photo4);
        data.add(photo);
        photo=new Photo(R.drawable.photo5);
        data.add(photo);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_gallery, menu);


        return true;
    }



}

