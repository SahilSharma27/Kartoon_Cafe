package com.example.android.kartooncafe;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OnBoardingActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    private ViewPagerAdapter adapter;

    private TextView[] dots;
    private Button button1;
    private Button button2;
    private int currentPage;
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            currentPage = position;
            if (position == 0) {
                button1.setEnabled(false);
                button2.setEnabled(true);
                button1.setVisibility(View.INVISIBLE);

                button2.setText("Next");
                button1.setText("");
            } else if (position == dots.length - 1) {
                button1.setEnabled(true);
                button2.setEnabled(true);
                button1.setVisibility(View.VISIBLE);

                button2.setText("Finish");
                button1.setText("Back");
            } else {
                button1.setEnabled(true);
                button2.setEnabled(true);
                button1.setVisibility(View.VISIBLE);

                button2.setText("Next");
                button1.setText("BACK");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.slide_view_pager);
        dotsLayout = findViewById(R.id.dots_layout);

        button1 = findViewById(R.id.back_button);
        button2 = findViewById(R.id.next_button);

        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentPage == 2) {
                    Intent intent = new Intent(OnBoardingActivity.this, MainActivity.class);
                    startActivity(intent);
                } else viewPager.setCurrentItem(currentPage + 1);

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage - 1);

            }
        });
    }

    public void addDotsIndicator(int position) {
        dots = new TextView[3];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setTextSize(35);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.myOrange));
        }
    }
}

