package com.example.android.kartooncafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAheadMenu extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter1 adapter1;
    Button button;
    ArrayList<Menu> menuList = new ArrayList<>();

    //  public static String Type="ORDERAHEADMENU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_ahead_menu);
        getIntent();
        loadMenu();
        button = findViewById(R.id.order_ahead_menu_back);
        recyclerView = findViewById(R.id.order_ahead_menu_recycler_view);
        GridLayoutManager gridLayoutmanager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutmanager);
        adapter1 = new CustomAdapter1(this, menuList, new MenuImageClickListener() {
            @Override
            public void onMenuClicked(View view, int position) {
                //    finish();
                Menu clickedMenuItem = menuList.get(position);
                Toast.makeText(OrderAheadMenu.this, clickedMenuItem.getMenuTitle(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(OrderAheadMenu.this, OrderAheadSubMenu.class);
                intent.putExtra("title", clickedMenuItem.getMenuTitle());
                intent.putExtra("category", clickedMenuItem.getMenuCategory());
                intent.putExtra("id", clickedMenuItem.getMenuBackDrop());
                //   intent.putExtra("typeOfCart",Type);
                //   startActivityForResult(intent,1);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadMenu() {
        menuList.add(new Menu("JUICES", "juices", R.drawable.juices));
        menuList.add(new Menu("SHAKES", "shakes", R.drawable.shakes));
        menuList.add(new Menu("COFFEE", "coffee", R.drawable.coffee));
        menuList.add(new Menu("SALADS", "salads", R.drawable.salad));
        menuList.add(new Menu("DRINKS", "drinks", R.drawable.drinks));
        menuList.add(new Menu("FOOD CRUNCHES", "foodcrunches", R.drawable.foodcrunches));
        menuList.add(new Menu("CROISSANTS", "croissants", R.drawable.croissants));
        menuList.add(new Menu("BREAKFAST", "breakfast", R.drawable.breakfast));
        menuList.add(new Menu("SOUPS & SALADS", "soups", R.drawable.soups));
        menuList.add(new Menu("STARTERS", "starters", R.drawable.starters));
        menuList.add(new Menu("BURGERS AND SANDWICHES", "burgers", R.drawable.burgers));
        menuList.add(new Menu("PIZZAS ", "pizza", R.drawable.pizza));
        menuList.add(new Menu("PASTAS", "pasta", R.drawable.pasta));
        menuList.add(new Menu("MADE IN MEXICO", "mexico", R.drawable.mexico));
        menuList.add(new Menu("DIMSUMS", "dimsums", R.drawable.dimsums));
        menuList.add(new Menu("PARADE SPECIAL", "parade", R.drawable.parade));
        menuList.add(new Menu("PLATTER", "platter", R.drawable.platter));
        menuList.add(new Menu("CHINESE", "chinese", R.drawable.chinese));
        menuList.add(new Menu("ARABIC", "arabic", R.drawable.arabic));
        menuList.add(new Menu("DESSSSERTS", "desserts", R.drawable.desserts));

    }
}
