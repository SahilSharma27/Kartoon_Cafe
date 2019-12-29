package com.example.android.kartooncafe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {
    private int TIME_OUT = 3000; //Time to launch the another activity
    ImageView imageView;
    FrameLayout frameLayout;
    LottieAnimationView animationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.splash_img);
        AlphaAnimation anim = new AlphaAnimation(0.0f, 2.0f);
        anim.setDuration(3000);
        //  anim.setRepeatCount(2);
        anim.setRepeatMode(Animation.REVERSE);
        imageView.startAnimation(anim);
        frameLayout = findViewById(R.id.splash_frame);
        animationView = new LottieAnimationView(this);
        animationView.setAnimation(R.raw.splash2);
        frameLayout.addView(animationView);
        animationView.playAnimation();
        animationView.setRepeatCount(1);
        //    animationView.setSpeed(4);
//        imageView=findViewById(R.id.splash);
//          Glide.with(imageView).load(R.drawable.frontsplash).into(imageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, OnBoardingActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);


    }
}
