package com.islavdroid.vomerapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RecPhotoAdapter  extends RecyclerView.Adapter<RecPhotoAdapter.MyViewHolder> {
    private List<Photo> eList;
    int layout ;
    GalleryActivity galleryActivity;
    Context mContext;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;

    public RecPhotoAdapter(Context c, List<Photo>l, int layout){
        eList=l;
        layoutInflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout=layout;
        mContext =c;
        galleryActivity=(GalleryActivity)c;

    }






    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v =layoutInflater.inflate(layout,viewGroup,false);
        MyViewHolder viewHolder=new MyViewHolder(v,galleryActivity);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.image.setImageResource(eList.get(position).getPhoto());
        if(!galleryActivity.isActionMode){
         holder.checkbox_delete.setVisibility(View.GONE);
        }
        else {
            holder.checkbox_delete.setVisibility(View.VISIBLE);
            holder.checkbox_delete.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return eList.size();
    }

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener r){
        recyclerViewOnClickListener=r;
    }

// удаление фото
public void updateAdapter(ArrayList<Photo>photoArrayList){
    for(Photo photo:photoArrayList){
        eList.remove(photo);

    }
    notifyDataSetChanged();
}



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView image;
        public CheckBox checkbox_delete;
        GalleryActivity galleryActivity;
        public MyViewHolder(View itemView,GalleryActivity galleryActivity) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.photo);
            checkbox_delete=(CheckBox)itemView.findViewById(R.id.checkbox_delete) ;
            //RelativeLayout content_layout=(RelativeLayout)itemView.findViewById(R.id.content_layout);
           // content_layout.setOnLongClickListener(galleryActivity);
          // image.setOnLongClickListener(galleryActivity);
            //itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(galleryActivity);
            checkbox_delete.setOnClickListener(this);
            this.galleryActivity=galleryActivity;
        }

        @Override
        public void onClick(View v) {
           galleryActivity.prepareSelection(v,getAdapterPosition());


        }
    }
}
