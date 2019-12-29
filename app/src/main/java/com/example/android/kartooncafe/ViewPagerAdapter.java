package com.example.android.kartooncafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    public int[] slide_images = {
            R.drawable.onboard1,
            R.drawable.onboard2,
            R.drawable.onboard3
    };
    public String[] slide_headings = {
            "ORDER ONLINE",
            "DELIVERY",
            "RESERVE A TABLE"
    };
    public String[] slide_descriptions = {
            "Order from our multi cuisine Menu to make your day more special! ",
            "Lightening Fast delivery Under 40 Mins, but with care! ",
            "Reserve Tables & manage your reservations right from your phone"
    };
    Context context;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView = view.findViewById(R.id.onboard_img_view);
        TextView textView1 = view.findViewById(R.id.onboard_heading);
        TextView textView2 = view.findViewById(R.id.onboard_description);

        imageView.setImageResource(slide_images[position]);
        textView1.setText(slide_headings[position]);
        textView2.setText(slide_descriptions[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
