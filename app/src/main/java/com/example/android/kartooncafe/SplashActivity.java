package com.example.android.kartooncafe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {
    private static int TIME_OUT = 4000; //Time to launch the another activity
    ImageView imageView;
    FrameLayout frameLayout;
    LottieAnimationView animationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        frameLayout = findViewById(R.id.splash_frame);
        animationView = new LottieAnimationView(this);
        animationView.setAnimation(R.raw.splash);
        frameLayout.addView(animationView);
        animationView.playAnimation();
        animationView.setSpeed(3);
        //imageView=findViewById(R.id.splash);
        //  Glide.with(imageView).load(R.drawable.frontsplash).into(imageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);


    }
}
//frameLayout=findViewById(R.id.anim);
//        animationView=new LottieAnimationView(this);
//        animationView.setAnimation(R.raw.livemusic);
//        frameLayout.addView(animationView);
//        animationView.playAnimation();