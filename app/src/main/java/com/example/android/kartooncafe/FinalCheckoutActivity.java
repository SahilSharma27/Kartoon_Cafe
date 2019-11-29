package com.example.android.kartooncafe;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class FinalCheckoutActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    LottieAnimationView animationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_checkout);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        frameLayout = findViewById(R.id.delivery_frame);
        animationView = new LottieAnimationView(this);
        animationView.setAnimation(R.raw.delivery);
        frameLayout.addView(animationView);
        animationView.playAnimation();
        animationView.setRepeatCount(2);

    }
}
