package com.islavdroid.vomerapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.shimmer.ShimmerFrameLayout;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;


public class AnswerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_layout);
        PulsatorLayout pulsator = (PulsatorLayout) findViewById(R.id.pulsator);
        PulsatorLayout pulsator2 = (PulsatorLayout) findViewById(R.id.pulsator2);
        pulsator.start();
        pulsator2.start();
        ShimmerFrameLayout container =
                (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        container.startShimmerAnimation();
    }
}
