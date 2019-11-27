package com.example.android.kartooncafe.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.kartooncafe.CustomAdapter1;
import com.example.android.kartooncafe.Menu;
import com.example.android.kartooncafe.MenuImageClickListener;
import com.example.android.kartooncafe.R;
import com.example.android.kartooncafe.SubMenuActivity;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final ArrayList<Menu> menuList = new ArrayList<>();
        RecyclerView menuRecyclerView;
        CustomAdapter1 menuAdapter;

        View root = inflater.inflate(R.layout.fragment_menu, container, false);




        Toast.makeText(getContext(),"this is menu",Toast.LENGTH_LONG).show();
        menuRecyclerView=root.findViewById(R.id.menu_recycler_view);

        menuList.add(new Menu("COLD PRESSSED JUICES","juices",R.drawable.juices));
        menuList.add(new Menu("SHAKES","shakes",R.drawable.shakes));
        menuList.add(new Menu("COFFEE","coffee",R.drawable.coffee));
        menuList.add(new Menu("CROSSFIT SALADS","salads",R.drawable.salad));
        menuList.add(new Menu("BENCH PRESS DRINKS","drinks",R.drawable.drinks));
        menuList.add(new Menu("FOOD CRUNCHES","foodcrunches",R.drawable.foodcrunches));
        menuList.add(new Menu("CROISSANTS","croissants",R.drawable.croissants));
        menuList.add(new Menu("BREAKFAST","breakfast",R.drawable.breakfast));
        menuList.add(new Menu("SOUPS & SALADS","soups",R.drawable.soups));
        menuList.add(new Menu("STARTERS","starters",R.drawable.starters));
        menuList.add(new Menu("BURGERS AND SANDWICHES","burgers",R.drawable.burgers));
        menuList.add(new Menu("HAND-STRETCHED PIZZAS MADE FRESH TO ORDER","pizza",R.drawable.pizza));
        menuList.add(new Menu("WONDERS OF PASTA","pasta",R.drawable.pasta));
        menuList.add(new Menu("MADE IN MEXICO","mexico",R.drawable.mexico));
        menuList.add(new Menu("KC'S HOT & JUICY DIMSUMS","dimsums",R.drawable.dimsums));
        menuList.add(new Menu("PARADE SPECIAL","parade",R.drawable.parade));
        menuList.add(new Menu("PLATTER TO PLATE","platter",R.drawable.platter));
        menuList.add(new Menu("CHINESE","chinese",R.drawable.chinese));
        menuList.add(new Menu("ARABIC","arabic",R.drawable.arabic));
        menuList.add(new Menu("'DESSSSERTS' IS OUR SPECIALITY","desserts",R.drawable.desserts));

        //  menuRecyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setReverseLayout(true);
//        linearLayoutManager.setStackFromEnd(true);
        menuRecyclerView.setLayoutManager(linearLayoutManager);

        menuAdapter=new CustomAdapter1(getContext(), menuList, new MenuImageClickListener() {
            @Override
            public void onMenuClicked(View view, int position) {

                Menu clickedMenuItem=menuList.get(position);
                Toast.makeText(getActivity(),clickedMenuItem.getMenuTitle(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getActivity(),SubMenuActivity.class);
                intent.putExtra("title",clickedMenuItem.getMenuTitle());
                intent.putExtra("category",clickedMenuItem.getMenuCategory());
                intent.putExtra("id",clickedMenuItem.getMenuBackDrop());
                startActivity(intent);
             }
        });


        menuRecyclerView.setAdapter(menuAdapter);
        return root;
    }
}