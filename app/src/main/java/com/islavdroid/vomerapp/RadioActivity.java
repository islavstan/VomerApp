package com.islavdroid.vomerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class RadioActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Гена Васильев");
        getSupportActionBar().setSubtitle("+3000.6969975");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        PulsatorLayout pulsator2 = (PulsatorLayout) findViewById(R.id.pulsator2);
        pulsator2.start();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return true;
    }
}

