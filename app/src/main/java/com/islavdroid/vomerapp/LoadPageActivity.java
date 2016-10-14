package com.islavdroid.vomerapp;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.facebook.shimmer.ShimmerFrameLayout;


public class LoadPageActivity extends AppCompatActivity {
//страница загрузки
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.load_page);
        ShimmerFrameLayout container =
                (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        container.startShimmerAnimation();

}}
