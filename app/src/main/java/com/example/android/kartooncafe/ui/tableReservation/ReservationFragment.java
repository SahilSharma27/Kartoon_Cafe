package com.example.android.kartooncafe.ui.tableReservation;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.android.kartooncafe.Cart;
import com.example.android.kartooncafe.CartAdapter;
import com.example.android.kartooncafe.CartHelper;
import com.example.android.kartooncafe.FinalDummyActivity2;
import com.example.android.kartooncafe.OrderAheadMenu;
import com.example.android.kartooncafe.R;
import com.example.android.kartooncafe.ReservationAdapter;
import com.example.android.kartooncafe.ReservationItemClickListener;
import com.example.android.kartooncafe.TableReservation;
import com.example.android.kartooncafe.ui.send.SendFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class ReservationFragment extends Fragment {


    public static TextView subTotalTV, grandTotalTV;
    public static String TABLE_RESERVATION_KEY = "reservation_order";
    private static ArrayList<Cart> finalReservationCartList = new ArrayList<>();
    private static Double tax = 0.05, subtotal = 0.0, GrandTotal = 0.0;
    private EditText editText;
    private View root;
    private CardView payable, paymentOptn;

    private ArrayList<String> dateList = new ArrayList<>();
    private ArrayList<String> timeList = new ArrayList<>();
    private ArrayList<String> numList = new ArrayList<>();
    private String finalDate, finalTime, finalNumber;

    private LinearLayout layout1, layout2;
    private RecyclerView orderRCView;
    private FrameLayout frameLayout, frameLayout1;
    private String finalSpecialOcassion = "NOT ANY";
    private CheckBox checkBoxOrderAhead, birthday, anniversary, party;
    private Button button;
    private LinearLayout cartView;
    private RecyclerView dateRCView, timeRCView, numberRCView;
    private Button reservationButton;

    private String x = "", y = "", z = "";
    public static boolean orderAhead = false;
    private CartAdapter adapter4;
    private LottieAnimationView animationView;
    private DatabaseReference cartOrderdatabaseReference;
    private TableReservation tableReservation;
    private RadioGroup radioGroup;
    ReservationAdapter adapter2;
    private String TODAY = "   TODAY   ";
    private String TOMMORROW = "TOMMORROW";

    public static void Refresh() {
        subtotal = 0.0;
        GrandTotal = 0.0;
        double price = 0.0;

        for (int i = 0; i < finalReservationCartList.size(); i++) {

            price = finalReservationCartList.get(i).getPrice() * finalReservationCartList.get(i).getQuantity();
            subtotal += price;

            if (finalReservationCartList.get(i).getCustom() != null) {

                subtotal += finalReservationCartList.get(i).getCustomPrice() * finalReservationCartList.get(i).getQuantity();
            }
        }

        GrandTotal = subtotal + (subtotal * tax);
        subTotalTV.setText("₹ " + subtotal);
        grandTotalTV.setText("₹ " + GrandTotal);

        // cartTotalPrice.setText("₹ " + GrandTotal);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter4.notifyDataSetChanged();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_reservation, container, false);
        subtotal = 0.0;
        GrandTotal = 0.0;
        findViews();
        loadAnimations();
        loadDateList();
        //  loadTimeList();
        loadNumberList();

        FirebaseDatabase cartfirebaseDatabase = FirebaseDatabase.getInstance();
        cartOrderdatabaseReference = cartfirebaseDatabase.getReference().child("TableReservation");

        finalReservationCartList.clear();
        finalReservationCartList = CartHelper.getItemsFromCart(getContext(), TABLE_RESERVATION_KEY);

        if (!finalReservationCartList.isEmpty()) {
            checkBoxOrderAhead.setChecked(true);
            orderAhead = true;
            button.setVisibility(View.VISIBLE);
            cartView.setVisibility(View.VISIBLE);
            payable.setVisibility(View.VISIBLE);
            paymentOptn.setVisibility(View.VISIBLE);
        }

        for (int i = 0; i < finalReservationCartList.size(); i++) {

            subtotal += finalReservationCartList.get(i).getPrice() * finalReservationCartList.get(i).getQuantity();
            if (finalReservationCartList.get(i).getCustom() != null) {

                subtotal += finalReservationCartList.get(i).getCustomPrice() * finalReservationCartList.get(i).getQuantity();
            }
        }

        GrandTotal = subtotal + (subtotal * tax);
        subTotalTV.setText(String.format("₹ %s", subtotal));
        grandTotalTV.setText(String.format("₹ %s", GrandTotal));

        checkBoxOrderAhead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBoxOrderAhead.isChecked()) {
                    orderAhead = true;
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
                    if (finalReservationCartList.isEmpty()) {
                        Toast.makeText(getContext(), "Your Cart is Empty!", Toast.LENGTH_LONG).show();
                        return;
                    }
                }


                finalSpecialOcassion = x + " " + y + " " + z;
                initializeObject();


                cartOrderdatabaseReference.push().setValue(tableReservation);
                CartHelper.emptyThecart(getContext(), TABLE_RESERVATION_KEY);
                showMyDialog();


            }
        });


        //Date RCVIEW
        ReservationAdapter adapter1 = new ReservationAdapter(getContext(), dateList, new ReservationItemClickListener() {
            @Override
            public void onReservationItemClicked(View view, int pos) {
                finalDate = dateList.get(pos);
                loadTimeList();
                adapter2.notifyDataSetChanged();
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
        ReservationAdapter adapter3 = new ReservationAdapter(getContext(), numList, new ReservationItemClickListener() {
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
        adapter4 = new CartAdapter(getContext(), finalReservationCartList);
        orderRCView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        orderRCView.setLayoutManager(linearLayoutManager);
        orderRCView.setAdapter(adapter4);


        return root;
    }

    private void loadDateList() {


        Calendar calendar = new GregorianCalendar();

        for (int i = 0; i < 30; i++) {
            Date date = calendar.getTime();

            String dateString;

            if (i == 0) {
                dateString = TODAY;
            } else if (i == 1) {
                dateString = TOMMORROW;
            } else {
                String[] splitDate = date.toString().split("\\s+");
                dateString = splitDate[0] + " " + splitDate[1] + " " + splitDate[2];
            }
            dateList.add(dateString);
            calendar.add(Calendar.DATE, 1);

        }
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

    private void loadTimeList() {
        timeList.clear();
        adapter2.notifyDataSetChanged();

        if (finalDate.equals(TODAY)) {
            Calendar rightnow = Calendar.getInstance();
            int hour = rightnow.get(Calendar.HOUR_OF_DAY);
            int AM_PM = rightnow.get(Calendar.AM_PM);


            for (int i = hour; i < 22; i++) {
                timeList.add(i + ":00");
                timeList.add(i + ":30");
            }
        } else {
            for (int i = 11; i < 22; i++) {
                timeList.add(i + ":00");
                timeList.add(i + ":30");
            }
        }


    }

    private void initializeObject() {
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton rb = radioGroup.findViewById(id);
        tableReservation = new TableReservation();
        tableReservation.setReservationId(generateOrderID());
        tableReservation.setReservationForDate(finalDate);
        tableReservation.setReservationForTime(finalTime);
        tableReservation.setNumberOfPpl(finalNumber);
        tableReservation.setUserName(SendFragment.USER_NAME);
        tableReservation.setUserEmail(SendFragment.USER_EMAIL);
        tableReservation.setUserContact(SendFragment.USER_CONTACT);
        tableReservation.setSpecialOccassion(finalSpecialOcassion);
        tableReservation.setSpecialInstruction(editText.getText().toString());
        tableReservation.setReservationStatus("Requested");
        if (orderAhead) {
            tableReservation.setReservationOrderAheadList(finalReservationCartList);
            // tableReservation.setPaymentMethod(rb.getText().toString());
        } else {
            // tableReservation.setPaymentMethod(null);
            tableReservation.setReservationOrderAheadList(null);
        }
        tableReservation.setOrderTotal(GrandTotal);
    }

    private void loadAnimations() {
        animationView = new LottieAnimationView(getContext());
        animationView.setAnimation(R.raw.ballon);
        frameLayout.addView(animationView);
        animationView.playAnimation();
        animationView.setRepeatCount(1);


        LottieAnimationView animationView1 = new LottieAnimationView(getContext());
        animationView1.setAnimation(R.raw.star);
        frameLayout1.addView(animationView1);
        animationView1.playAnimation();
        animationView1.setRepeatCount(4);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            finalReservationCartList.clear();
            finalReservationCartList = CartHelper.getItemsFromCart(getContext(), TABLE_RESERVATION_KEY);
            adapter4 = new CartAdapter(getContext(), finalReservationCartList);
            orderRCView.setItemAnimator(new DefaultItemAnimator());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            orderRCView.setLayoutManager(linearLayoutManager);
            orderRCView.setAdapter(adapter4);
            Refresh();
        }
    }

    private void findViews() {

        TextView textViewname = root.findViewById(R.id.username);
        textViewname.setText(SendFragment.USER_NAME);
        TextView textViewemail = root.findViewById(R.id.useremail);
        textViewemail.setText(SendFragment.USER_EMAIL);
        TextView textViewContact = root.findViewById(R.id.usercontact);
        textViewContact.setText(SendFragment.USER_CONTACT);


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

        subTotalTV = root.findViewById(R.id.order_ahead_subtotal);
        grandTotalTV = root.findViewById(R.id.order_ahead_grand_total);

        cartView = root.findViewById(R.id.order_ahead_cart);
        // TextView reservationCartQty = root.findViewById(R.id.reservation_cart_qty);
        payable = root.findViewById(R.id.reservation_cart_payable);
        paymentOptn = root.findViewById(R.id.reservation_cart_paymentOptn);
        radioGroup = root.findViewById(R.id.order_ahead_payment_method);


        editText = root.findViewById(R.id.reservation_editxt);


        //animation frames
        frameLayout = root.findViewById(R.id.special_anim);
        frameLayout1 = root.findViewById(R.id.reserveanim);

    }

    private void showMyDialog() {
        final Dialog myDialog = new Dialog(getContext());
        myDialog.setContentView(R.layout.custom_dialog_layout);
        myDialog.show();

        frameLayout = myDialog.findViewById(R.id.anim);
        animationView = new LottieAnimationView(getContext());
        animationView.setAnimation(R.raw.check);
        frameLayout.addView(animationView);
        animationView.playAnimation();
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getContext(), FinalDummyActivity2.class);
                intent.putExtra("date", tableReservation.getReservationForDate());
                intent.putExtra("time", tableReservation.getReservationForTime());
                intent.putExtra("ppl", tableReservation.getNumberOfPpl());
                intent.putExtra("res_order_total", GrandTotal);
                intent.putParcelableArrayListExtra("summary_list", finalReservationCartList);
                myDialog.dismiss();
                getActivity().finish();
                startActivity(intent);
            }
        };
        handler.postDelayed(runnable, 3000);
        Toast.makeText(getContext(), "Reservation Done", Toast.LENGTH_LONG).show();
    }

    private String generateOrderID() {

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddhhmmss");
        return "KCTR" + dateFormat.format(now);


    }


}



