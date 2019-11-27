package com.example.android.kartooncafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalDummyActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_dummy2);

        TextView textView = findViewById(R.id.table);

        Intent intent = getIntent();
        String X;

//        TableReservation finalTableReservation = intent.getParcelableExtra("OI");
//        if (finalTableReservation.getReservtaionOrderAheadList() != null) {
//            X = finalTableReservation.getReservtaionOrderAheadList().get(0).getCartItem().getItemName();
//        } else X = "Nopee";


//        String dummy = finalTableReservation.getReservationId() +
//                "\n " + finalTableReservation.getReservationDate() +
//                "\n " + finalTableReservation.getReservationTime() +
//                "\n " + finalTableReservation.getNumberOfPpl() +
//                "\n " + finalTableReservation.getUserName() +
//                "\n " + finalTableReservation.getUserEmail() +
//                "\n " + finalTableReservation.getUserContact() +
//                "\n " + finalTableReservation.getSpecialInstruction() +
//                "\n" + finalTableReservation.getSpecialOcassion() +
//                "\n" + finalTableReservation.getOrderTotal() + X;
//
//        textView.setText(dummy);

    }
}
