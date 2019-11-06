package com.example.android.kartooncafe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView cartRecyclerView;
    CartAdapter adapter;
    TextView cartTotalPrice;
    Double cartTotal=0.0;
    public static ArrayList <Double> cartItemPrices=new ArrayList<>();
    public static ArrayList <Double> cartCustomsItemPrices=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setTitle("CART");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cartRecyclerView=findViewById(R.id.cart_list);
        cartTotalPrice=findViewById(R.id.cartTotal);
        adapter=new CartAdapter(this,SubMenuActivity.cartItems);
        cartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cartRecyclerView.setLayoutManager(linearLayoutManager);
        cartRecyclerView.setAdapter(adapter);



        for(int i=0;i<cartItemPrices.size();i++){
            cartTotal+=cartItemPrices.get(i);
        }
        for(int i=0;i<SubMenuActivity.cartItems.size();i++){
            if(SubMenuActivity.cartItems.get(i).getCustom()!=null) {
                cartCustomsItemPrices.add(SubMenuActivity.cartItems.get(i).getCustom().getCustomPrice());
            }
        }
        for(int i=0;i<cartCustomsItemPrices.size();i++){
            cartTotal+=cartCustomsItemPrices.get(i);
        }


       cartTotalPrice.setText(String.valueOf(cartTotal));

    }
}
