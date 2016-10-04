package com.islavdroid.vomerapp.gallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.islavdroid.vomerapp.Photo;
import com.islavdroid.vomerapp.R;

import java.util.ArrayList;

public class DetailImage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_image);

        ArrayList<Photo> data = getIntent().getParcelableArrayListExtra("data");
        int position = getIntent().getIntExtra("pos",0);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(data.get(position).getPhoto());
    }
}

