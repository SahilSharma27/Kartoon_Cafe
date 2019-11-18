package com.example.android.kartooncafe;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView cartRecyclerView;
    FrameLayout emptycartView;
    CartAdapter adapter;
    TextView cartTotalPrice;
    TextView payment;
    CardView paymentRads;
    Double cartTotal=0.0;
    public static ArrayList <Double> cartItemPrices=new ArrayList<>();
    public static ArrayList <Double> cartCustomsItemPrices=new ArrayList<>();
    LottieAnimationView animationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setTitle("CART");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        emptycartView = findViewById(R.id.empty_cart);
        animationView = new LottieAnimationView(this);
        animationView.setAnimation(R.raw.empty_list);
        emptycartView.addView(animationView);
        animationView.playAnimation();
        animationView.setRepeatCount(10);

        cartRecyclerView=findViewById(R.id.cart_list);
        cartTotalPrice=findViewById(R.id.cartTotal);
        payment = findViewById(R.id.payment);
        paymentRads = findViewById(R.id.payment_rads);

        adapter=new CartAdapter(this,SubMenuActivity.cartItems);
        cartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cartRecyclerView.setLayoutManager(linearLayoutManager);
        cartRecyclerView.setAdapter(adapter);
//        if(SubMenuActivity.cartItems.isEmpty()){
//            emptycartView.setVisibility(View.VISIBLE);
//        }
//        else {
//            emptycartView.setVisibility(View.GONE);
//            payment.setVisibility(View.VISIBLE);
//            paymentRads.setVisibility(View.VISIBLE);
//        }



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
