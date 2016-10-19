package com.islavdroid.vomerapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class RecordDialog extends DialogFragment  {
ImageButton button_rec;
    TextView time;
    boolean press=true;

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.dialog_voice_message, null);
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            button_rec=(ImageButton)v.findViewById(R.id.btn_rec);
            time=(TextView)v.findViewById(R.id.time);
            button_rec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(press){
                        button_rec.setImageResource(R.drawable.stop_red);
                        TimerTextHelper timerTextHelper = new TimerTextHelper(time);
                        timerTextHelper.start();
                        press =false;
                    }else {
                        dismiss();
                        Toast.makeText(getActivity(),"Голосовое сообщение отправлено",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            return v;
        }
    }