package com.example.android.kartooncafe;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.kartooncafe.ui.send.SendFragment;

import java.util.ArrayList;

public class FinalCheckoutActivity extends AppCompatActivity {

    TextView amountTextView;
    Button callUsButton;
    RecyclerView recyclerView;
    ImageButton homebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_checkout);


        TextView userNameTextview = findViewById(R.id.order_confirm_username);
        TextView userdeliveyTextview = findViewById(R.id.order_confirm_deliveryAddress);
        TextView userCntctTextview = findViewById(R.id.order_confirm_usercontact);
        TextView paymentMethod = findViewById(R.id.order_summary_method);
        callUsButton = findViewById(R.id.summary_call_us);
        amountTextView = findViewById(R.id.order_summary_amount);
        recyclerView = findViewById(R.id.order_summary);

        Intent intent = getIntent();
        ArrayList<Cart> summary_list;
        summary_list = intent.getParcelableArrayListExtra("SummaryCart");
        double amount = intent.getDoubleExtra("total_amount", 0.0);
        String method = intent.getStringExtra("payment_method");

        userNameTextview.setText(SendFragment.USER_NAME);
        userCntctTextview.setText(SendFragment.USER_CONTACT);
        userdeliveyTextview.setText(SendFragment.USER_ADDRESS);
        paymentMethod.setText("Payment Method : " + method);

        homebutton = findViewById(R.id.summary_back);


        callUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel" + R.string.KC_contact));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    Activity#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    return;
                }
                startActivity(intent1);
            }
        });

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        SummaryAdapter adapter = new SummaryAdapter(this, summary_list);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        amountTextView.setText("Total Amount: ₹ " + amount + " (inclusive all taxes)");

//        frameLayout = findViewById(R.id.delivery_frame);
//        animationView = new LottieAnimationView(this);
//        animationView.setAnimation(R.raw.delivery);
//        frameLayout.addView(animationView);
//        animationView.playAnimation();
//        animationView.setRepeatCount(2);

    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
