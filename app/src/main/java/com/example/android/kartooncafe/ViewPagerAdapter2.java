package com.example.android.kartooncafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

public class ViewPagerAdapter2 extends PagerAdapter {


    public int[] top_slide_images = {
            R.drawable.poster1,
            R.drawable.poster2,
            R.drawable.poster3
    };
    public String[] top_slide_descriptions = {
            "We Believe In Quality Food and Happy Atmosphere ",
            "Our Commitment to Fulfill Customer Expectations",
            "Our Commitment to Fulfill Customer Expectations"
    };
    Context context;
    LayoutInflater layoutInflater;

//    public String[] top_slide_headings = {
//            "ORDER ONLINE",
//            "DELIVERY",
//            "RESERVE A TABLE"
//    };

    public ViewPagerAdapter2(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return top_slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.top_slide_layout, container, false);

        ImageView imageView = view.findViewById(R.id.top_poster_img);
        TextView textView = view.findViewById(R.id.top_poster_description);


        // imageView.setImageResource(top_slide_images[position]);
        Glide.with(imageView.getContext()).load(top_slide_images[position]).into(imageView);
        textView.setText(top_slide_descriptions[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((FrameLayout) object);
    }

}
