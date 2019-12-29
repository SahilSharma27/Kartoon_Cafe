package com.example.android.kartooncafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.kartooncafe.ui.send.SendFragment;
import com.example.android.kartooncafe.ui.tableReservation.ReservationFragment;

import java.util.ArrayList;

public class FinalDummyActivity2 extends AppCompatActivity {
    SummaryAdapter adapter;
    RecyclerView recyclerView;
    ImageButton homebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_dummy2);
        ArrayList<Cart> summaryList;

        TextView userNameTextview = findViewById(R.id.res_confirm_username);
        TextView userMailTextview = findViewById(R.id.res_confirm_usermail);
        TextView userCntctTextview = findViewById(R.id.res_confirm_usercontact);
        TextView dateTextView = findViewById(R.id.res_confirm_date);
        TextView timeTextView = findViewById(R.id.res_confirm_time);
        TextView pplTextView = findViewById(R.id.res_confirm_ppl);
        TextView noOrderTextView = findViewById(R.id.no_order_ahead);
        TextView resamountTextView = findViewById(R.id.reservation_summary_amount);
        TextView resmethodTextView = findViewById(R.id.reservation_summary_method);
        recyclerView = findViewById(R.id.reservation_summary);
        homebutton = findViewById(R.id.summary_back2);


        Intent intent = getIntent();

        userNameTextview.setText(SendFragment.USER_NAME);
        userCntctTextview.setText(SendFragment.USER_CONTACT);
        userMailTextview.setText(SendFragment.USER_EMAIL);
        dateTextView.setText(intent.getStringExtra("date"));
        timeTextView.setText(intent.getStringExtra("time"));
        pplTextView.setText(intent.getStringExtra("ppl"));
        summaryList = intent.getParcelableArrayListExtra("summary_list");
        double total = intent.getDoubleExtra("res_order_total", 0.0);

        if (ReservationFragment.orderAhead) {

            noOrderTextView.setVisibility(View.GONE);

            adapter = new SummaryAdapter(this, summaryList);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);

            resamountTextView.setText("Total Amount: ₹ " + total + " (inclusive all taxes)");
        } else {
            recyclerView.setVisibility(View.GONE);
            resamountTextView.setVisibility(View.GONE);
            resmethodTextView.setVisibility(View.GONE);
            noOrderTextView.setVisibility(View.VISIBLE);
        }
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
