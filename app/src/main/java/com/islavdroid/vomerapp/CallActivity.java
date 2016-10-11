package com.islavdroid.vomerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class CallActivity extends AppCompatActivity {
    ImageButton camera,dialpad,add,speaker,pause,mute;
    boolean cambol,dialbol,addbol,speakerbol,pausebol,mutebol;
    TextView text_camera,text_keyboard,text_add,text_speaker,text_wait,text_soundoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_layout);


        cambol=true;
        dialbol=true;
        addbol=true;
        speakerbol=true;
        pausebol=true;
        mutebol=true;


        camera =(ImageButton)findViewById(R.id.camera);
        dialpad =(ImageButton)findViewById(R.id.dialpad);
        add =(ImageButton)findViewById(R.id.add);
        speaker =(ImageButton)findViewById(R.id.speaker);
        pause =(ImageButton)findViewById(R.id.pause);
        mute =(ImageButton)findViewById(R.id.mute);

        text_camera=(TextView)findViewById(R.id.text_camera);
        text_keyboard=(TextView)findViewById(R.id.text_keyboard);
        text_add=(TextView)findViewById(R.id.text_add);
        text_speaker=(TextView)findViewById(R.id.text_speaker);
        text_wait=(TextView)findViewById(R.id.text_wait);
        text_soundoff=(TextView)findViewById(R.id.text_soundoff);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   if(cambol){
                    camera.setColorFilter(Color.argb(76,175,80,0));
                    text_camera.setTextColor(Color.parseColor("#4caf50"));
                    cambol=false;
                }
                else {
                    camera.setColorFilter(Color.argb(158,158,158,0));
                    text_camera.setTextColor(Color.parseColor("#9E9E9E"));
                    cambol=true;
                }*/
            }
        });

}}
