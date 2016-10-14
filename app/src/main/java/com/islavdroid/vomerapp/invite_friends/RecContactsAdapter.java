package com.islavdroid.vomerapp.invite_friends;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.islavdroid.vomerapp.R;
import com.islavdroid.vomerapp.RecUserAdapter;
import com.islavdroid.vomerapp.RecyclerViewOnClickListener;
import com.islavdroid.vomerapp.Users;
import com.islavdroid.vomerapp.chat.MainChatActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;



public class RecContactsAdapter extends RecyclerView.Adapter<RecContactsAdapter.MyViewHolder> {
    private List<ContactBean> eList;
    int layout ;
    Context c;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;
    public RecContactsAdapter(Context c, List<ContactBean>l, int layout){
        eList=l;
        layoutInflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout=layout;
        this.c=c;
    }





    @Override
    public RecContactsAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v =layoutInflater.inflate(layout,viewGroup,false);
        RecContactsAdapter.MyViewHolder viewHolder=new RecContactsAdapter.MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecContactsAdapter.MyViewHolder holder, int position) {
        holder.name.setText(eList.get(position).getName());
        holder.user_number.setText(eList.get(position).getPhoneNo());
       // holder.image.setImageResource(eList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return eList.size();
    }


    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener r){
        recyclerViewOnClickListener=r;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public CircleImageView image;
        public TextView name;
        public TextView user_number;
        public MyViewHolder(View itemView) {
            super(itemView);
            image=(CircleImageView)itemView.findViewById(R.id.user_image);
            name=(TextView)itemView.findViewById(R.id.user_name);
            user_number=(TextView)itemView.findViewById(R.id.user_number);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
