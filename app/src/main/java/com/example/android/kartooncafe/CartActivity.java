package com.example.android.kartooncafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
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

    public ArrayList<Cart> finalCartItems = new ArrayList<>();

    TextView emptytext;
    TextView subTotalTV, grandTotalTV;
    CardView orderCard;
    Double tax = 0.05;
    Double subtotal = 0.0;
    Double GrandTotal = 0.0;
    LottieAnimationView animationView;
    NestedScrollView cartContent;
    Button placeOrderbutton;
    EditText editText;
    String additionalRequest;
    Bundle bundle;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setTitle("CART");
        findViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //animation
        animationView = new LottieAnimationView(this);
        animationView.setAnimation(R.raw.empty_list);
        emptycartView.addView(animationView);
        animationView.playAnimation();
        animationView.setRepeatCount(10);


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
            cartContent.setVisibility(View.VISIBLE);
            orderCard.setVisibility(View.VISIBLE);
        }


        for (int i = 0; i < cartItemPrices.size(); i++) {
            subtotal += cartItemPrices.get(i);
        }

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


        placeOrderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finalCartItems.addAll(SubMenuActivity.cartItems);
                Toast.makeText(CartActivity.this, finalCartItems.get(0).getCartItem().getItemName(), Toast.LENGTH_LONG).show();
//
                order = new Order();
                order.setOrderId(1);
                order.setOrderDate("Today");
                order.setOrderTime("Now");
                order.setUserName(MainActivity.userName);
                order.setUserEmail(MainActivity.userEmail);
                order.setUserContact("9810040013");
                order.setUserAddress("Ramesh Nagar");
                order.setSpecialInstruction(additionalRequest);
                order.setOrderList(finalCartItems);


                Intent intent = new Intent(CartActivity.this, FinalDummyActivity.class);
                intent.putExtra("YO", order);
                startActivity(intent);


            }
        });

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText() != null)
                    additionalRequest = editText.getText().toString();
                else additionalRequest = "No Request";
            }
        });

    }

    public void findViews() {
        //pricing textview
        subTotalTV = findViewById(R.id.subTotal);
        grandTotalTV = findViewById(R.id.grand_total);


        cartRecyclerView = findViewById(R.id.cart_list);

        editText = findViewById(R.id.additional_request_cart);

        //place order card and button
        cartTotalPrice = findViewById(R.id.cartTotal);
        orderCard = findViewById(R.id.placebuttoncard);
        placeOrderbutton = findViewById(R.id.orderPlacebutton);

        //cartitems card view
        cartContent = findViewById(R.id.cart_content);

        //animation frame and text
        emptycartView = findViewById(R.id.empty_cart);
        emptytext = findViewById(R.id.cartemptytext);


    }

}
