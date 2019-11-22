package com.example.android.kartooncafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalDummyActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_dummy);
        textView = findViewById(R.id.user_name);

        Intent intent = getIntent();

        Order finalOrder = intent.getParcelableExtra("YO");

        String dummy = finalOrder.getOrderId() +
                "\n " + finalOrder.getOrderDate() +
                "\n " + finalOrder.getOrderTime() +
                "\n " + finalOrder.getUserName() +
                "\n " + finalOrder.getUserEmail() +
                "\n " + finalOrder.getUserContact() +
                "\n " + finalOrder.getUserAddress() +
                "\n " + finalOrder.getSpecialInstruction() +
                "\n " + finalOrder.getOrderList().get(0).getCartItem().getItemName() + "";


        textView.setText(dummy);


    }
}
