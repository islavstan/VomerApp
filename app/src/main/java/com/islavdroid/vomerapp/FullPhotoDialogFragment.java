package com.islavdroid.vomerapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.islavdroid.vomerapp.R;
import com.islavdroid.vomerapp.gallery.TouchImageView;

import java.util.ArrayList;

import fr.tvbarthel.lib.blurdialogfragment.BlurDialogFragment;



public class FullPhotoDialogFragment extends BlurDialogFragment {
    TouchImageView photoForDialog;
    ArrayList<Photo> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fullphoto_dialog_fragment, null);




        photoForDialog = (TouchImageView)v.findViewById(R.id.image);
        // ImageView imageView = (ImageView) findViewById(R.id.image);

    photoForDialog.setImageResource(R.drawable.photo1);

        return v;
    }
}
