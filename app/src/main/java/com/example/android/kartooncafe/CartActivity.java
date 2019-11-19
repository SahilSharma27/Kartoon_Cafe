package com.example.android.kartooncafe;

import android.os.Bundle;
import android.view.View;
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
    public static ArrayList<Double> cartItemPrices = new ArrayList<>();
    public static ArrayList<Double> cartCustomsItemPrices = new ArrayList<>();
    TextView payment, cartitems, emptytext;
    //TextViews for pricing
    TextView subTotalTV, grandTotalTV;
    CardView paymentRads, orderCard, cartPricingCard;
    // Double cartTotal=0.0;
    Double tax = 0.05;
    Double subtotal = 0.0;
    Double GrandTotal = 0.0;
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setTitle("CART");
        subTotalTV = findViewById(R.id.subTotal);
        grandTotalTV = findViewById(R.id.grand_total);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        emptycartView = findViewById(R.id.empty_cart);
        animationView = new LottieAnimationView(this);
        animationView.setAnimation(R.raw.empty_list);
        emptycartView.addView(animationView);
        animationView.playAnimation();
        animationView.setRepeatCount(10);

        cartRecyclerView = findViewById(R.id.cart_list);
        cartTotalPrice = findViewById(R.id.cartTotal);
        payment = findViewById(R.id.payment);
        emptytext = findViewById(R.id.cartemptytext);
        cartitems = findViewById(R.id.cartItemText);
        paymentRads = findViewById(R.id.payment_rads);
        orderCard = findViewById(R.id.placebuttoncard);
        cartPricingCard = findViewById(R.id.cartpricing);

        adapter = new CartAdapter(this, SubMenuActivity.cartItems);
        cartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cartRecyclerView.setLayoutManager(linearLayoutManager);
        cartRecyclerView.setAdapter(adapter);
        if (SubMenuActivity.cartItems.isEmpty()) {
            emptycartView.setVisibility(View.VISIBLE);
            emptytext.setVisibility(View.VISIBLE);
        } else {
            emptycartView.setVisibility(View.GONE);
            emptytext.setVisibility(View.GONE);
            payment.setVisibility(View.VISIBLE);
            cartitems.setVisibility(View.VISIBLE);
            paymentRads.setVisibility(View.VISIBLE);
            orderCard.setVisibility(View.VISIBLE);
            cartPricingCard.setVisibility(View.VISIBLE);
        }


        for (int i = 0; i < cartItemPrices.size(); i++) {
            subtotal += cartItemPrices.get(i);
        }
//        for(int i=0;i<SubMenuActivity.cartItems.size();i++){
//            if(SubMenuActivity.cartItems.get(i).getCustom()!=null) {
//                subtotal+=SubMenuActivity.cartItems.get(i).getCustom().getCustomPrice();
//            }
//                subtotal+=SubMenuActivity.cartItems.get(i).getCartItem().getItemPrice();
//        }

        for (int i = 0; i < SubMenuActivity.cartItems.size(); i++) {
            if (SubMenuActivity.cartItems.get(i).getCustom() != null) {
                cartCustomsItemPrices.add(SubMenuActivity.cartItems.get(i).getCustom().getCustomPrice());
            }
        }
        for (int i = 0; i < cartCustomsItemPrices.size(); i++) {
            subtotal += cartCustomsItemPrices.get(i);
        }


        GrandTotal = subtotal + (subtotal * tax);


        subTotalTV.setText("SUB TOTAL  :  ₹ " + subtotal);
        grandTotalTV.setText("GRAND TOTAL  :  ₹ " + GrandTotal);


        cartTotalPrice.setText("₹ " + GrandTotal);

    }

}
