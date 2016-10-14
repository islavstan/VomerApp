package com.islavdroid.vomerapp;


import android.content.Intent;
import android.os.Bundle;


import android.provider.ContactsContract;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.islavdroid.vomerapp.gallery.DetailImage;
import com.islavdroid.vomerapp.gallery.RecyclerItemClickListener;

import java.util.ArrayList;
//ГАЛЕРЕЯ
public class GalleryActivity extends AppCompatActivity implements View.OnLongClickListener {
       boolean isActionMode =false;
    TextView counter_text ;
    ArrayList<Photo> data = new ArrayList<>();
    ArrayList<Photo>selectionPhotoList =new ArrayList<>();
    int counter =0;
    RecyclerView mRecyclerView;
    RecPhotoAdapter mAdapter;
    Toolbar toolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        counter_text=(TextView)findViewById(R.id.counter_text) ;
       // counter_text.setVisibility(View.GONE);
        counter_text.setText("Галерея");
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setTitle("Галерея");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                        if(!isActionMode){



/*
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("data", data);
                            bundle.putInt("pos", position);
                            ImageBrowseFragment imageBrowseFragment =new ImageBrowseFragment();
                            imageBrowseFragment.setArguments(bundle);*/
                            //******************************************
                        Intent intent = new Intent(GalleryActivity.this, DetailImage.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);
                         //   overridePendingTransition(R.anim.fadein, R.anim.fadeout);


                        //************************************************
                        }




                        else {}
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


    @Override
    public boolean onLongClick(View v) {
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_for_gallery_delete);
          isActionMode=true;
        mAdapter.notifyDataSetChanged();
        counter_text.setVisibility(View.VISIBLE);

        counter_text.setText("0 фото выбрано");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    public void prepareSelection(View view,int position){
if(((CheckBox)view).isChecked()){
    selectionPhotoList.add(data.get(position));
    counter=counter+1;
    updateCounter(counter);
}
        else {
    selectionPhotoList.remove(data.get(position));
    counter=counter-1;
    updateCounter(counter);
        }

    }

    public void updateCounter(int counter){
        if(counter==0){
            counter_text.setText("0 фото выбрано");
        }
        else {
            counter_text.setText(counter+" фото выбрано");
        }

    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      if(item.getItemId()==R.id.delete_photo){

          RecPhotoAdapter adapter =(RecPhotoAdapter)mAdapter;
          adapter.updateAdapter(selectionPhotoList);
          clearDeleteMode();
      }
        else if (item.getItemId()==android.R.id.home){
          clearDeleteMode();
          mAdapter.notifyDataSetChanged();
      }

        return true;
    }
    public void clearDeleteMode(){
        isActionMode=false;
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_for_gallery);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //counter_text.setVisibility(View.GONE);
        counter_text.setText("Галерея");
        //setTitle("Галерея");
       // counter_text.setText("0 фото выбрано");
        counter=0;
        selectionPhotoList.clear();
    }

    @Override
    public void onBackPressed() {
        if(isActionMode){
            clearDeleteMode();
            mAdapter.notifyDataSetChanged();
        }
        else {
            super.onBackPressed();
        }
    }
}

