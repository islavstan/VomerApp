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
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.islavdroid.vomerapp.Photo;
import com.islavdroid.vomerapp.R;
import com.islavdroid.vomerapp.SwipeAdapter;

import java.util.ArrayList;

public class DetailImage extends AppCompatActivity {
    TextView tips;
    ArrayList<Photo> data;
    ViewPager viewPager;
    SwipeAdapter swipeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail_image);
        setContentView(R.layout.fragment_image_browse);
        viewPager =(ViewPager)findViewById(R.id.viewpager) ;
         tips =(TextView)findViewById(R.id.text) ;

      data = getIntent().getParcelableArrayListExtra("data");
        int position = getIntent().getIntExtra("pos",0);
        swipeAdapter=new SwipeAdapter(this,data);
        viewPager.setAdapter(swipeAdapter);
        viewPager.setCurrentItem(position);
        tips.setText((position + 1) + "/" + data.size());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tips.setText((position + 1) + "/" + data.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }});


       // ImageView imageView = (ImageView) findViewById(R.id.image);
       // TouchImageView imageView=(TouchImageView) findViewById(R.id.image);;
       // imageView.setImageResource(data.get(position).getPhoto());
    }
}

