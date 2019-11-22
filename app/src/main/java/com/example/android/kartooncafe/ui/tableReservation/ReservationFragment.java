package com.example.android.kartooncafe.ui.tableReservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.android.kartooncafe.Cart;
import com.example.android.kartooncafe.CartAdapter;
import com.example.android.kartooncafe.FinalDummyActivity2;
import com.example.android.kartooncafe.MainActivity;
import com.example.android.kartooncafe.OrderAheadMenu;
import com.example.android.kartooncafe.OrderAheadSubMenu;
import com.example.android.kartooncafe.R;
import com.example.android.kartooncafe.ReservationAdapter;
import com.example.android.kartooncafe.ReservationItemClickListener;
import com.example.android.kartooncafe.TableReservation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationFragment extends Fragment {


    TextView reservationCartQty;
    EditText editText;
    View root;
    CardView payable, paymentOptn;
    String finalDate, finalTime, finalNumber;
    String finalSpecialOcassion = "NOT ANY";
    boolean orderAhead = false;
    CartAdapter adapter4;
    private ArrayList<String> dateList = new ArrayList<>();
    private ArrayList<String> timeList = new ArrayList<>();
    private ArrayList<String> numList = new ArrayList<>();
    private ArrayList<Cart> finalReservationCartList;
    private LinearLayout layout1, layout2;
    private RecyclerView orderRCView;
    private FrameLayout frameLayout, frameLayout1;
    private LottieAnimationView animationView, animationView1;
    private CheckBox checkBoxOrderAhead, birthday, anniversary, party;
    private Button button;
    private TextView textViewname, textViewemail;
    private LinearLayout cartView;
    private RecyclerView dateRCView, timeRCView, numberRCView;
    private Button reservationButton;
    private ReservationAdapter adapter1, adapter2, adapter3;
    private String x = "", y = "", z = "";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_reservation, container, false);

        findViews();
        loadAnimations();
        loadDateList();
        loadTimeList();
        loadNumberList();

        checkBoxOrderAhead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBoxOrderAhead.isChecked()) {
                    orderAhead = true;
                    finalReservationCartList = new ArrayList<>();
                    button.setVisibility(View.VISIBLE);
                    cartView.setVisibility(View.VISIBLE);
                    payable.setVisibility(View.VISIBLE);
                    paymentOptn.setVisibility(View.VISIBLE);
                } else if (!checkBoxOrderAhead.isChecked()) {
                    orderAhead = false;
                    button.setVisibility(View.GONE);
                    cartView.setVisibility(View.GONE);
                    payable.setVisibility(View.GONE);
                    paymentOptn.setVisibility(View.GONE);
                }
            }
        });

        birthday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (birthday.isChecked()) {
                    x = birthday.getText().toString();

                }
                if (!birthday.isChecked()) {
                    x = "";
                }
            }
        });
        anniversary.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (anniversary.isChecked()) {
                    y = anniversary.getText().toString();
                }
                if (!anniversary.isChecked()) {
                    y = "";
                }
            }
        });
        party.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (party.isChecked()) {
                    z = party.getText().toString();
                }
                if (!party.isChecked()) {
                    z = "";
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getContext(), OrderAheadMenu.class);
                startActivityForResult(intent, 0);
            }
        });

        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (finalDate == null) {
                    Toast.makeText(getContext(), "Please select a Date!", Toast.LENGTH_LONG).show();
                    return;
                } else if (finalTime == null) {
                    Toast.makeText(getContext(), "Please select Time!", Toast.LENGTH_LONG).show();
                    return;
                } else if (finalNumber == null) {
                    Toast.makeText(getContext(), "Please select Number of People!", Toast.LENGTH_LONG).show();
                    return;
                } else if (checkBoxOrderAhead.isChecked()) {
                    if (OrderAheadSubMenu.reservationCart == null || OrderAheadSubMenu.reservationCart.isEmpty()) {
                        Toast.makeText(getContext(), "Your Cart is Empty!", Toast.LENGTH_LONG).show();
                        return;
                    } else {
                        finalReservationCartList.addAll(OrderAheadSubMenu.reservationCart);
                    }
                }


                finalSpecialOcassion = x + " " + y + " " + z;

                TableReservation tableReservation = new TableReservation();
                tableReservation.setReservationId(1);
                tableReservation.setReservationDate(finalDate);
                tableReservation.setReservationTime(finalTime);
                tableReservation.setNumberOfPpl(finalNumber);
                tableReservation.setUserName(MainActivity.userName);
                tableReservation.setUserEmail(MainActivity.userEmail);
                tableReservation.setUserContact("9810040013");
                tableReservation.setSpecialOcassion(finalSpecialOcassion);
                tableReservation.setSpecialInstruction(editText.getText().toString());
                if (orderAhead) {
                    tableReservation.setReservtaionOrderAheadList(finalReservationCartList);
                } else tableReservation.setReservtaionOrderAheadList(null);

                tableReservation.setOrderTotal(1000.0);

                Intent intent = new Intent(getContext(), FinalDummyActivity2.class);
                intent.putExtra("OI", tableReservation);
                startActivity(intent);
            }
        });


        //Date RCVIEW
        adapter1 = new ReservationAdapter(getContext(), dateList, new ReservationItemClickListener() {
            @Override
            public void onReservationItemClicked(View view, int pos) {
                finalDate = dateList.get(pos);
                layout1.setVisibility(View.VISIBLE);
            }
        });
        dateRCView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        dateRCView.setLayoutManager(layoutManager);
        dateRCView.setAdapter(adapter1);


        //Time RCVIEW
        adapter2 = new ReservationAdapter(getContext(), timeList, new ReservationItemClickListener() {
            @Override
            public void onReservationItemClicked(View view, int pos) {
                finalTime = timeList.get(pos);

                layout2.setVisibility(View.VISIBLE);
            }
        });
        timeRCView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager layoutManager1 = new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL, false);
        timeRCView.setLayoutManager(layoutManager1);
        timeRCView.setAdapter(adapter2);


        //Number RCVIEW
        adapter3 = new ReservationAdapter(getContext(), numList, new ReservationItemClickListener() {
            @Override
            public void onReservationItemClicked(View view, int pos) {
                finalNumber = numList.get(pos);
            }
        });

        numberRCView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager layoutManager3 = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        numberRCView.setLayoutManager(layoutManager3);
        numberRCView.setAdapter(adapter3);


        //order ahead Cart RCVIEW
        adapter4 = new CartAdapter(getContext(), OrderAheadSubMenu.reservationCart);
        orderRCView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        orderRCView.setLayoutManager(linearLayoutManager);
        orderRCView.setAdapter(adapter4);


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter4.notifyDataSetChanged();
    }

    private void loadDateList() {

        String today = "TODAY";
        String tommorrow = "TOMMORROW";
//        String s = "Sun, Oct 20 2019";
//        String e = "Sat, Nov 02 2019";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d EEEE");
        String current = sdf.format(date);
        // String s = "2019 Oct 20 Sunday";
        String e = "2019 Nov 30 Saturday";
        //  String e=current.pl

        LocalDate start = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM d EEEE");
            start = LocalDate.parse(current, formatter);
            LocalDate end = LocalDate.parse(e, formatter);
            end = start.plusDays(31);
            List<LocalDate> totalDates = new ArrayList<>();
            while (!start.isAfter(end)) {
                totalDates.add(start);
                start = start.plusDays(1);
            }

            String dateString;
            String finalString;
            for (int i = 0; i < totalDates.size(); i++) {

                dateString = String.valueOf(formatter.format(totalDates.get(i)));
                if (i == 0) {
                    finalString = today + dateString.substring(4, 11);
                } else if (i == 1) {
                    finalString = tommorrow;
                } else {
                    finalString = dateString.substring(4);
                }

                dateList.add(finalString);
            }

        }


    }


    private void loadTimeList() {
        timeList.add("11:00 AM");
        timeList.add("11:30 AM");
        timeList.add("12:00 PM");
        timeList.add("12:30 PM");
        timeList.add("1:00 PM");
        timeList.add("1:30 PM");
        timeList.add("2:00 PM");
        timeList.add("2:30 PM");
        timeList.add("3:00 PM");
        timeList.add("3:30 PM");
        timeList.add("4:00 PM");
        timeList.add("4:30 PM");
        timeList.add("5:00 PM");
        timeList.add("5:30 PM");
        timeList.add("6:30 PM");
        timeList.add("6:30 PM");
        timeList.add("7:00 PM");
        timeList.add("7:30 PM");
        timeList.add("8:00 PM");
        timeList.add("8:30 PM");
        timeList.add("9:00 PM");
        timeList.add("9:30 PM");
        timeList.add("10:00 PM");
        timeList.add("10:30 PM");

    }

    private void loadNumberList() {
        numList.add("1");
        numList.add("2");
        numList.add("3");
        numList.add("4");
        numList.add("5");
        numList.add("6");
        numList.add("7+");
    }

    private void findViews() {

        textViewname = root.findViewById(R.id.username);
        textViewname.setText(MainActivity.userName);
        textViewemail = root.findViewById(R.id.useremail);
        textViewemail.setText(MainActivity.userEmail);

        dateRCView = root.findViewById(R.id.dateview);
        timeRCView = root.findViewById(R.id.timeview);
        numberRCView = root.findViewById(R.id.numberview);


        orderRCView = root.findViewById(R.id.order_ahead_list);

        layout1 = root.findViewById(R.id.timeLayout);
        layout2 = root.findViewById(R.id.numLayout);

        reservationButton = root.findViewById(R.id.reservation_button);

        checkBoxOrderAhead = root.findViewById(R.id.order_ahead_check_box);
        party = root.findViewById(R.id.special_party);
        anniversary = root.findViewById(R.id.special_anni);
        birthday = root.findViewById(R.id.special_birthday);


        button = root.findViewById(R.id.reservation_menu_button);

        cartView = root.findViewById(R.id.order_ahead_cart);
        reservationCartQty = root.findViewById(R.id.reservation_cart_qty);
        payable = root.findViewById(R.id.reservation_cart_payable);
        paymentOptn = root.findViewById(R.id.reservation_cart_paymentOptn);


        editText = root.findViewById(R.id.reservation_editxt);


        //animation frames
        frameLayout = root.findViewById(R.id.special_anim);
        frameLayout1 = root.findViewById(R.id.reserveanim);

    }

    private void loadAnimations() {
        animationView = new LottieAnimationView(getContext());
        animationView.setAnimation(R.raw.ballon);
        frameLayout.addView(animationView);
        animationView.playAnimation();
        animationView.setRepeatCount(1);


        animationView1 = new LottieAnimationView(getContext());
        animationView1.setAnimation(R.raw.star);
        frameLayout1.addView(animationView1);
        animationView1.playAnimation();
        animationView1.setRepeatCount(4);
    }


}


