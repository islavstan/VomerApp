package com.islavdroid.vomerapp;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bm.library.PhotoView;

import java.util.ArrayList;
//слайдер для галереи
public class SwipeAdapter extends PagerAdapter {
    ArrayList<Photo>photoArrayList=new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public SwipeAdapter(Context context,ArrayList<Photo>photoArrayList){
        this.context=context;
        this.photoArrayList=photoArrayList;

    }
    @Override
    public int getCount() {
        return photoArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(RelativeLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.picture_info,container,false);
        PhotoView photoView =(PhotoView)itemView.findViewById(R.id.imageView);
        photoView.enable();
        photoView.setImageResource(photoArrayList.get(position).getPhoto());
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
