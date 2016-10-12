package com.islavdroid.vomerapp.chat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.islavdroid.vomerapp.*;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;



public class RecGroupChatAdapter extends RecyclerView.Adapter<RecGroupChatAdapter.MyViewHolder> {
    private List<Users> eList;
    int layout ;
    Context c;
    private LayoutInflater layoutInflater;
    private com.islavdroid.vomerapp.RecyclerViewOnClickListener recyclerViewOnClickListener;
    public RecGroupChatAdapter(Context c, List<Users>l, int layout){
        eList=l;
        layoutInflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout=layout;
        this.c=c;
    }





    @Override
    public RecGroupChatAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v =layoutInflater.inflate(layout,viewGroup,false);
        RecGroupChatAdapter.MyViewHolder viewHolder=new RecGroupChatAdapter.MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecGroupChatAdapter.MyViewHolder holder, int position) {
        holder.name.setText(eList.get(position).getName());
        holder.user_number.setText(eList.get(position).getMessage());
        holder.image.setImageResource(eList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return eList.size();
    }


    public void setRecyclerViewOnClickListener(com.islavdroid.vomerapp.RecyclerViewOnClickListener r){
        recyclerViewOnClickListener=r;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public CircleImageView image;
        public TextView name;
        public TextView user_number;
        public CheckBox checkbox;
        public MyViewHolder(View itemView) {
            super(itemView);
            image=(CircleImageView)itemView.findViewById(R.id.user_image);
            name=(TextView)itemView.findViewById(R.id.user_name);
            user_number=(TextView)itemView.findViewById(R.id.user_number);
            checkbox=(CheckBox)itemView.findViewById(R.id.checkbox);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            /*if(recyclerViewOnClickListener !=null){
                recyclerViewOnClickListener.OnclickListener(v,getPosition());*/

        }
    }
}

