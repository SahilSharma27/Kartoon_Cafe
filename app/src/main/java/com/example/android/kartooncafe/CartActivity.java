package com.example.android.kartooncafe;

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
import com.example.android.kartooncafe.ui.send.SendFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CartActivity extends AppCompatActivity {
    RecyclerView cartRecyclerView;
    FrameLayout emptycartView;
    CartAdapter adapter;
    public static ArrayList<Cart> finalCartItems = new ArrayList<>();
    static TextView cartTotalPrice;
    static TextView subTotalTV, grandTotalTV;
    static Double tax = 0.05, subtotal = 0.0, GrandTotal = 0.0;
    public FirebaseDatabase cartfirebaseDatabase;
    CardView orderCard;
    public DatabaseReference cartOrderdatabaseReference;
    LottieAnimationView animationView;
    NestedScrollView cartContent;
    Button placeOrderbutton;
    EditText editText;
    String additionalRequest;
    String orderDate, orderTime;
    TextView emptytext, addressTextView;
    String address;

    public static void Refresh() {
        subtotal = 0.0;
        GrandTotal = 0.0;

        for (int i = 0; i < finalCartItems.size(); i++) {
            subtotal += finalCartItems.get(i).getPrice();
            if (finalCartItems.get(i).getCustom() != null) {
                subtotal += finalCartItems.get(i).getCustomPrice();
            }
        }

        GrandTotal = subtotal + (subtotal * tax);
        subTotalTV.setText("SUB TOTAL  :  ₹ " + subtotal);
        grandTotalTV.setText("GRAND TOTAL  :  ₹ " + GrandTotal);

        cartTotalPrice.setText("₹ " + GrandTotal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setTitle("CART");
        findViews();
        loadAnimations();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        finalCartItems.clear();
        finalCartItems = CartHelper.getItemsFromCart(this);
        addressTextView.setText(SendFragment.userDeliveryAddress);
        subtotal = 0.0;
        GrandTotal = 0.0;
        address = addressTextView.getText().toString();

        cartfirebaseDatabase = FirebaseDatabase.getInstance();
        cartOrderdatabaseReference = cartfirebaseDatabase.getReference().child("Orders");

        adapter = new CartAdapter(this, finalCartItems);
        cartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cartRecyclerView.setLayoutManager(linearLayoutManager);
        cartRecyclerView.setAdapter(adapter);


        if (finalCartItems.isEmpty()) {
            emptycartView.setVisibility(View.VISIBLE);
            emptytext.setVisibility(View.VISIBLE);
        } else {
            emptycartView.setVisibility(View.GONE);
            emptytext.setVisibility(View.GONE);
            cartContent.setVisibility(View.VISIBLE);
            orderCard.setVisibility(View.VISIBLE);
        }

        for (int i = 0; i < finalCartItems.size(); i++) {
            subtotal += finalCartItems.get(i).getPrice();
            if (finalCartItems.get(i).getCustom() != null) {
                subtotal += finalCartItems.get(i).getCustomPrice();
            }
        }

        GrandTotal = subtotal + (subtotal * tax);
        subTotalTV.setText("SUB TOTAL  :  ₹ " + subtotal);
        grandTotalTV.setText("GRAND TOTAL  :  ₹ " + GrandTotal);

        cartTotalPrice.setText("₹ " + GrandTotal);


        placeOrderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Date time = Calendar.getInstance().getTime();
                orderTime = time.toString();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                orderDate = dateFormat.format(time);

                Order order = new Order();
                order.setOrderId(1);
                order.setOrderDate(orderDate);
                order.setOrderTime(orderTime);
                order.setUserName(MainActivity.userName);
                order.setUserEmail(MainActivity.userEmail);
                order.setUserContact("9810040013");
                order.setUserAddress(address);
                order.setSpecialInstruction(additionalRequest);
                order.setOrderList(finalCartItems);
                order.setOrderTotal(GrandTotal);
                order.setOrderStatus("Placed");
                order.setPayementMethod("Cash");
                cartOrderdatabaseReference.push().setValue(order);
                CartHelper.emptyThecart(CartActivity.this);
                Toast.makeText(CartActivity.this, orderTime, Toast.LENGTH_LONG).show();
//
//
//                Intent intent = new Intent(CartActivity.this, FinalDummyActivity.class);
//                intent.putExtra("YO", order);
//                startActivity(intent);


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

    public void loadAnimations() {
        //animation
        animationView = new LottieAnimationView(this);
        animationView.setAnimation(R.raw.empty_list);
        emptycartView.addView(animationView);
        animationView.playAnimation();
        animationView.setRepeatCount(10);
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

        addressTextView = findViewById(R.id.address);


    }

}
