package com.example.android.kartooncafe.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.android.kartooncafe.R;

public class GalleryFragment extends Fragment {
    LottieAnimationView animationView1, animationView2, animationView3;
    FrameLayout frameLayout1, frameLayout2, frameLayout3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        frameLayout1 = root.findViewById(R.id.call_frame);
        animationView1 = new LottieAnimationView(getContext());
        animationView1.setAnimation(R.raw.contact_us);
        frameLayout1.addView(animationView1);
        animationView1.playAnimation();


        frameLayout2 = root.findViewById(R.id.mail_frame);
        animationView2 = new LottieAnimationView(getContext());
        animationView2.setAnimation(R.raw.mail);
        frameLayout2.addView(animationView2);
        animationView2.playAnimation();

        frameLayout3 = root.findViewById(R.id.location_frame);
        animationView3 = new LottieAnimationView(getContext());
        animationView3.setAnimation(R.raw.location);
        frameLayout3.addView(animationView3);
        animationView3.playAnimation();
        animationView3.setRepeatCount(3);




        return root;
    }
}