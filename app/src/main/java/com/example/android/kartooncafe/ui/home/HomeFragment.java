package com.example.android.kartooncafe.ui.home;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.example.android.kartooncafe.BestSellerAdapter;
import com.example.android.kartooncafe.BestSellerItem;
import com.example.android.kartooncafe.CartActivity;
import com.example.android.kartooncafe.CustomAdapter1;
import com.example.android.kartooncafe.Customizables;
import com.example.android.kartooncafe.Menu;
import com.example.android.kartooncafe.MenuImageClickListener;
import com.example.android.kartooncafe.Poster;
import com.example.android.kartooncafe.PosterAdapter;
import com.example.android.kartooncafe.PosterItemClickListener;
import com.example.android.kartooncafe.R;
import com.example.android.kartooncafe.SubMenuActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeFragment extends Fragment {


    private ArrayList<Menu> specialMenu = new ArrayList<>();
    private ArrayList<Poster> topPosterList = new ArrayList<>();
    private ArrayList<BestSellerItem> bestSellerList = new ArrayList<>();

    private Customizables veg;
    private Customizables chk;
    private Customizables vanilla;
    private Customizables coffee;
    private Customizables belgianChocolate;
    private Customizables egg;
    private Customizables nonveg8;

    private LottieAnimationView animationView1, animationView2, animationView3, animationView4;

    private View root;
    private FloatingActionButton fab;

    private PosterAdapter adapter1;
    private CustomAdapter1 adapter;
    private BestSellerAdapter adapter2;

    private RecyclerView specialsRCView, posterRCView, bestsellRCVIew;

    private CardView insta, fb, twitter, yt;
    private ImageView open;

    private Button button;

    private FrameLayout liveMusicFrame1, liveMusicFrame2, liveMusicFrame3, specialFrame;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);

        findViews();
        playAnimations();
        loadTopPosters();
        loadSpecialMenu();
        loadBestSellers();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Opening Cart", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                Intent intent = new Intent(getContext(), CartActivity.class);
                startActivity(intent);

            }
        });


        Glide.with(open).load(R.drawable.openow).into(open);

        //Top Posters
        adapter1 = new PosterAdapter(getContext(), topPosterList, new PosterItemClickListener() {
            @Override
            public void onPosterItemClicked(View view, int positon) {
                Toast.makeText(getContext(), "Do Action If Needed", Toast.LENGTH_LONG).show();

            }
        });
        posterRCView.setItemAnimator(new DefaultItemAnimator());
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(posterRCView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        posterRCView.setLayoutManager(linearLayoutManager);
        posterRCView.setAdapter(adapter1);


        //Specials
        specialsRCView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        specialsRCView.setLayoutManager(layoutManager);
        adapter = new CustomAdapter1(getContext(), specialMenu, new MenuImageClickListener() {
            @Override
            public void onMenuClicked(View view, int position) {
                Menu clickedMenuItem = specialMenu.get(position);
                Toast.makeText(getActivity(), clickedMenuItem.getMenuTitle(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity(), SubMenuActivity.class);
                intent.putExtra("title", clickedMenuItem.getMenuTitle());
                intent.putExtra("category", clickedMenuItem.getMenuCategory());
                intent.putExtra("id", clickedMenuItem.getMenuBackDrop());
                startActivity(intent);
            }
        });
        specialsRCView.setAdapter(adapter);


        //Bestsellers
        bestsellRCVIew.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        bestsellRCVIew.setLayoutManager(linearLayoutManager1);
        adapter2 = new BestSellerAdapter(getContext(), bestSellerList);
        bestsellRCVIew.setAdapter(adapter2);


        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/kartooncafe2017");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/kartooncafe2017")));
                }
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String facebookId = "fb://page/218502545571356";
                String urlPage = "http://www.facebook.com/KartoonCafe";

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId)));
                } catch (Exception e) {
                    Log.e(TAG, "Application not intalled.");
                    //Open url web page.
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlPage)));
                }
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + "kartoon29296668")));
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/" + "kartoon29296668")));
                }
            }
        });
        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                String url = "https://www.youtube.com/channel/UCrZUbj_qk4Xw75keYyutnaw";
                try {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.google.android.youtube");
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo open Reservation fragment
            }
        });


        return root;
    }


    private void loadSpecialMenu() {
        specialMenu.clear();
        specialMenu.add(new Menu("PIZZAS", "pizza", R.drawable.pizza2));
        specialMenu.add(new Menu("CHINESE", "chinese", R.drawable.chinese));
        specialMenu.add(new Menu("JUICES", "juices", R.drawable.juices));
        specialMenu.add(new Menu("DESSSSERTS", "desserts", R.drawable.desserts));
    }

    private void loadTopPosters() {
        topPosterList.clear();
        topPosterList.add(new Poster(R.drawable.poster1, "\" We Believe In Quality Food and Happy Atmosphere\""));
        topPosterList.add(new Poster(R.drawable.poster2, "\" Our Commitment to Fulfill Customer Expectations\""));
        topPosterList.add(new Poster(R.drawable.poster3, "\" Dessssertss Is Our Speciality! \" "));
        topPosterList.add(new Poster(R.drawable.poster4, " "));
        topPosterList.add(new Poster(R.drawable.poster5, " "));

    }

    private void loadBestSellers() {
        loadCustoms();
        ArrayList<Customizables> bestCustItem4 = new ArrayList<>();
        bestCustItem4.add(vanilla);
        bestCustItem4.add(coffee);
        bestCustItem4.add(belgianChocolate);
        ArrayList<Customizables> defaultCust = new ArrayList<>();
        ArrayList<Customizables> bestCustItem7 = new ArrayList<>();
        bestCustItem7.add(veg);
        bestCustItem7.add(nonveg8);
        ArrayList<Customizables> bestCustItem8 = new ArrayList<>();
        bestCustItem8.add(veg);
        bestCustItem8.add(nonveg8);
        ArrayList<Customizables> bestCustItem11 = new ArrayList<>();
        bestCustItem11.add(veg);
        bestCustItem11.add(egg);
        bestCustItem11.add(chk);
        bestSellerList.clear();
        bestSellerList.add(new BestSellerItem("PIZA3", "Tom's Zingy Red Pepper Pizza", getString(R.string.pizza3), 0, 400, 0, defaultCust, R.drawable.pizza));
        bestSellerList.add(new BestSellerItem("PIZA2", "Shrek's classic Margarita Pizza", getString(R.string.pizza2), 0, 370, 0, defaultCust, R.drawable.margarita));
        bestSellerList.add(new BestSellerItem("CPJ6", "Cinderella Fresh Ginger ale", getString(R.string.juice6), 0, 110.0, 0, defaultCust, R.drawable.gingerale));
        bestSellerList.add(new BestSellerItem("SHK3", "Snow-White Oreo Donut Shake", getString(R.string.shake3), 0, 205, 1, bestCustItem4, R.drawable.shakes));
        bestSellerList.add(new BestSellerItem("CFE5", "Scooby Doo Cold Coffee", "", 0, 150, 0, defaultCust, R.drawable.coldcoffe));
        bestSellerList.add(new BestSellerItem("DSRT4", "X-Men Blue Berry Cheese Cake", getString(R.string.dessert4), 1, 170, 0, defaultCust, R.drawable.blueberry));
        bestSellerList.add(new BestSellerItem("PRD1", "Jafar Biryani", getString(R.string.parade1), 2, 280, 1, bestCustItem7, R.drawable.parade));
        bestSellerList.add(new BestSellerItem("PRD2", "Goku Salut Sizzlers", getString(R.string.parade2), 2, 400, 1, bestCustItem8, R.drawable.parade));
        bestSellerList.add(new BestSellerItem("PRD5", "Tigger Kung Pao Chicken", getString(R.string.parade5), 1, 350, 0, defaultCust, R.drawable.parade));
        bestSellerList.add(new BestSellerItem("PRD7", "Sher Khan Chicken", getString(R.string.parade7), 1, 460, 0, defaultCust, R.drawable.parade));
        bestSellerList.add(new BestSellerItem("STRS7", "Dragon Ball Z Noodles", getString(R.string.starters7), 2, 190, 1, bestCustItem11, R.drawable.noodles));

    }

    private void loadCustoms() {
        veg = new Customizables("Veg", 0, 0);
        nonveg8 = new Customizables("Non Veg", 100, 1);
        chk = new Customizables("Chicken", 35, 1);
        vanilla = new Customizables("Vanilla", 0, 0);
        coffee = new Customizables("Coffee", 10, 0);
        belgianChocolate = new Customizables("Belgian Chocolate", 25, 0);
        egg = new Customizables("Egg", 20, 1);
    }

    @Override
    public void onResume() {
        super.onResume();
//        animationView1.playAnimation();
//        animationView2.playAnimation();
        animationView3.playAnimation();
        animationView4.playAnimation();
    }

    private void findViews() {
        fab = root.findViewById(R.id.fabHome);

        //RCVIEWS
        specialsRCView = root.findViewById(R.id.special_rcview);
        bestsellRCVIew = root.findViewById(R.id.best_seller_rcview);
        posterRCView = root.findViewById(R.id.top_rcview);

        button = root.findViewById(R.id.reservationfromhome);
        //animations
        liveMusicFrame1 = root.findViewById(R.id.live_music_frame);
        liveMusicFrame2 = root.findViewById(R.id.live_music_frame1);
        liveMusicFrame3 = root.findViewById(R.id.live_music_frame2);
        specialFrame = root.findViewById(R.id.likes);

        //FollowUs
        insta = root.findViewById(R.id.instafollow);
        fb = root.findViewById(R.id.fbfollow);
        twitter = root.findViewById(R.id.twitterfollow);
        yt = root.findViewById(R.id.ytfollow);

        open = root.findViewById(R.id.home_img);

    }

    private void playAnimations() {
        //guitar girl
        animationView1 = new LottieAnimationView(getContext());
        animationView1.setAnimation(R.raw.live_music);
        liveMusicFrame1.addView(animationView1);
        animationView1.playAnimation();


        //speaker
        animationView2 = new LottieAnimationView(getContext());
        animationView2.setAnimation(R.raw.live_music3);
        liveMusicFrame2.addView(animationView2);
        animationView2.playAnimation();
        animationView2.setRepeatCount(1);

        //headphone guy
        animationView3 = new LottieAnimationView(getContext());
        animationView3.setAnimation(R.raw.live_music2);
        liveMusicFrame3.addView(animationView3);
        animationView3.playAnimation();
        animationView3.setRepeatCount(1);

        //likes
        animationView4 = new LottieAnimationView(getContext());
        animationView4.setAnimation(R.raw.like);
        specialFrame.addView(animationView4);
        animationView4.playAnimation();
        animationView4.setRepeatCount(2);

    }

}