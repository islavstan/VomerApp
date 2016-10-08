package com.islavdroid.vomerapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class RecyclerViewForUserInfo extends RecyclerView.Adapter<RecyclerViewForUserInfo.MyViewHolder> {
    private List<Photo> eList;
    int layout ;

    Context mContext;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;

    public RecyclerViewForUserInfo(Context c, List<Photo>l, int layout){
        eList=l;
        layoutInflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout=layout;
        mContext =c;

    }






    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v =layoutInflater.inflate(layout,viewGroup,false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.image.setImageResource(eList.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return eList.size();
    }

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener r){
        recyclerViewOnClickListener=r;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView image;


        public MyViewHolder(View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.photo);


        }

        @Override
        public void onClick(View v) {



        }
    }
}
