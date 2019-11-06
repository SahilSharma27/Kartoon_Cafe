package com.example.android.kartooncafe.ui.home;

import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.bumptech.glide.Glide;
import com.example.android.kartooncafe.CustomAdapter1;
import com.example.android.kartooncafe.MainActivity;
import com.example.android.kartooncafe.Menu;
import com.example.android.kartooncafe.MenuImageClickListener;
import com.example.android.kartooncafe.Poster;
import com.example.android.kartooncafe.PosterAdapter;
import com.example.android.kartooncafe.PosterItemClickListener;
import com.example.android.kartooncafe.R;
import com.example.android.kartooncafe.SubMenuActivity;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeFragment extends Fragment {

    private RecyclerView specialsRCView,posterRCView;
    private CustomAdapter1 adapter;
    private PosterAdapter adapter1;
    private ArrayList<Menu> specialMenu=new ArrayList<>();
    private ArrayList<Poster> topPosterList=new ArrayList<>();
    CardView insta,fb,twitter,yt;
    ImageView iv,open;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
       // specialMenu.clear();
        specialsRCView=root.findViewById(R.id.special_rcview);
        posterRCView=root.findViewById(R.id.top_rcview);
        iv=root.findViewById(R.id.special_item_image);
        insta=root.findViewById(R.id.instafollow);
        fb=root.findViewById(R.id.fbfollow);
        twitter=root.findViewById(R.id.twitterfollow);
        open=root.findViewById(R.id.home_img);
        yt=root.findViewById(R.id.ytfollow);
        Glide.with(open).load(R.drawable.opennow).into(open);

        loadTopPosters();
        loadSpecialMenu();

        posterRCView.setItemAnimator(new DefaultItemAnimator());
        SnapHelper snapHelper=new LinearSnapHelper();
        snapHelper.attachToRecyclerView(posterRCView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        posterRCView.setLayoutManager(linearLayoutManager);
        adapter1=new PosterAdapter(getContext(), topPosterList, new PosterItemClickListener() {
            @Override
            public void onPosterItemClicked(View view, int positon) {
                Toast.makeText(getContext(),"Do Action If Needed",Toast.LENGTH_LONG).show();

            }
        });
        posterRCView.setAdapter(adapter1);




        specialsRCView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
        specialsRCView.setLayoutManager(layoutManager);
        adapter=new CustomAdapter1(getContext(), specialMenu, new MenuImageClickListener() {
            @Override
            public void onMenuClicked(View view, int position) {
                Menu clickedMenuItem=specialMenu.get(position);
                Toast.makeText(getActivity(),clickedMenuItem.getMenuTitle(),Toast.LENGTH_LONG).show();

                Intent intent=new Intent(getActivity(), SubMenuActivity.class);
                intent.putExtra("title",clickedMenuItem.getMenuTitle());
                intent.putExtra("category",clickedMenuItem.getMenuCategory());
                intent.putExtra("id",clickedMenuItem.getMenuBackDrop());
                startActivity(intent);

            }
        });
        specialsRCView.setAdapter(adapter);
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
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId )));
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
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" +"kartoon29296668")));
                }catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/" + "kartoon29296668")));
                }
            }
        });
        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=null;
                String url="https://www.youtube.com/channel/UCrZUbj_qk4Xw75keYyutnaw";
                try {
                    intent =new Intent(Intent.ACTION_VIEW);
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



        return root;
    }
    public void loadSpecialMenu(){
        specialMenu.clear();
        specialMenu.add(new Menu("PIZZAS","pizza",R.drawable.pizza));
        specialMenu.add(new Menu("CHINESE","chinese",R.drawable.chinese));
        specialMenu.add(new Menu("JUICES","juices",R.drawable.juices));
        specialMenu.add(new Menu("DESSSSERTS","desserts",R.drawable.desserts));
    }
    public void loadTopPosters(){
        topPosterList.clear();
        topPosterList.add(new Poster(R.drawable.poster1,"\" We Believe In Quality Food and Happy Atmosphere\""));
        topPosterList.add(new Poster(R.drawable.poster2,"\" Our Commitment to Fulfill Customer Expectations\""));
        topPosterList.add(new Poster(R.drawable.poster3,"\" Dessssertss Is Our Speciality! \" "));
        topPosterList.add(new Poster(R.drawable.poster4," "));
        topPosterList.add(new Poster(R.drawable.poster5," "));

    }
}