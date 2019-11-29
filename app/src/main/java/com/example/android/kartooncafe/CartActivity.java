package com.example.android.kartooncafe;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CartActivity extends AppCompatActivity implements PaymentResultListener {
    RecyclerView cartRecyclerView;
    FrameLayout emptycartView;
    CartAdapter adapter;
    String TAG = "Payment Error";
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
    String additionalRequest = "Not Any";
    String orderDate, orderTime;
    TextView emptytext, addressTextView, contactTextView;
    String address;
    FrameLayout frameLayout;
    RadioGroup radioGroup;
    Order finalOrder;


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
        Checkout.preload(getApplicationContext());
        getSupportActionBar().setTitle("CART");
        findViews();
        loadAnimations();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        finalCartItems.clear();
        finalCartItems = CartHelper.getItemsFromCart(this);
        addressTextView.setText(SendFragment.userDeliveryAddress);
        contactTextView.setText(SendFragment.contactNumber);
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

//Order place
        placeOrderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initializeObject();

                if (finalOrder.getPayementMethod().equals("CASH")) {
                    cartOrderdatabaseReference.push().setValue(finalOrder);
                    CartHelper.emptyThecart(CartActivity.this);
                    showMyDialog();
                } else if (finalOrder.getPayementMethod().equals("CARD / UPI / NETBANKING")) {
                    startPayment();
                }
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

    private void showMyDialog() {
        Dialog myDialog = new Dialog(CartActivity.this);
        myDialog.setContentView(R.layout.custom_dialog_layout);
        myDialog.show();

        frameLayout = myDialog.findViewById(R.id.anim);
        animationView = new LottieAnimationView(CartActivity.this);
        animationView.setAnimation(R.raw.checkmark);
        frameLayout.addView(animationView);
        animationView.playAnimation();
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(CartActivity.this, FinalCheckoutActivity.class);
                startActivity(intent);
            }
        };
        handler.postDelayed(runnable, 3000);
        Toast.makeText(CartActivity.this, "Order Placed", Toast.LENGTH_LONG).show();
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
        radioGroup = findViewById(R.id.payment_method);
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
        contactTextView = findViewById(R.id.contact_textview);


    }

    public void initializeObject() {

        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton rb = radioGroup.findViewById(id);
        finalOrder = new Order();
        getCurrentDateTime();
        finalOrder.setOrderId(1);
        finalOrder.setOrderDate(orderDate);
        finalOrder.setOrderTime(orderTime);
        finalOrder.setUserName(MainActivity.userName);
        finalOrder.setUserEmail(MainActivity.userEmail);
        finalOrder.setUserContact(SendFragment.contactNumber);
        finalOrder.setUserAddress(address);
        finalOrder.setSpecialInstruction(additionalRequest);
        finalOrder.setOrderList(finalCartItems);
        finalOrder.setOrderTotal(GrandTotal);
        finalOrder.setOrderStatus("Placed");
        finalOrder.setPayementMethod(rb.getText().toString());

    }

    public void getCurrentDateTime() {
        Date time = Calendar.getInstance().getTime();
        orderTime = time.toString();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        orderDate = dateFormat.format(time);
    }

    public void startPayment() {
//        int amount=Integer.parseInt(editText.getText().toString().trim());
//        amount=amount*100;
        /**
         * Instantiate Checkout
         */
        Checkout checkout = new Checkout();


        /**
         * Set your logo here
         */
        // checkout.setImage(R.drawable.kclogo);
        // int id = checkout.getId();
        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();

            /**
             * Merchant Name
             * eg: ACME Corp || HasGeek etc.
             */
            options.put("name", "Kartoon Cafe");

            /**
             * Description can be anything
             * eg: Order #123123
             *     Invoice Payment
             *     etc.
             */
            options.put("description", "Test Order");
            // options.put("order_id", id);
            options.put("currency", "INR");

            /**
             * Amount is always passed in PAISE
             * Eg: "500" = Rs 5.00
             */
            options.put("amount", GrandTotal * 100);

            checkout.open(activity, options);
        } catch (Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }
    }


    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        cartOrderdatabaseReference.push().setValue(finalOrder);
        CartHelper.emptyThecart(CartActivity.this);
        showMyDialog();

    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(this, "Oops! somthing went wrong", Toast.LENGTH_SHORT).show();

    }


}
