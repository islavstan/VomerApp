package com.islavdroid.vomerapp;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.islavdroid.vomerapp.chat.MainChatActivity;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecUserAdapter extends RecyclerView.Adapter<RecUserAdapter.MyViewHolder> {
    private List<Users> eList;
    int layout ;
    Context c;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;
    public RecUserAdapter(Context c, List<Users>l, int layout){
        eList=l;
        layoutInflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout=layout;
        this.c=c;
    }





    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v =layoutInflater.inflate(layout,viewGroup,false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(eList.get(position).getName());
        holder.description.setText(eList.get(position).getMessage());
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
      //  public CircleImageView image;
       public CircleImageView image;
        public TextView name;
        public TextView description;
        public MyViewHolder(View itemView) {
            super(itemView);
            image=(CircleImageView)itemView.findViewById(R.id.user_image);
            name=(TextView)itemView.findViewById(R.id.user_name);
            description=(TextView)itemView.findViewById(R.id.user_message);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            /*if(recyclerViewOnClickListener !=null){
                recyclerViewOnClickListener.OnclickListener(v,getPosition());*/
                Intent intent=new Intent(c, MainChatActivity.class);
                c.startActivity(intent);
            }
        }
    }
