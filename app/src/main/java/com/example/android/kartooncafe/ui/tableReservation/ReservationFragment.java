package com.example.android.kartooncafe.ui.tableReservation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.kartooncafe.Cart;
import com.example.android.kartooncafe.CartActivity;
import com.example.android.kartooncafe.Customizables;
import com.example.android.kartooncafe.R;
import com.example.android.kartooncafe.ReservationAdapter;
import com.example.android.kartooncafe.ReservationItemClickListener;
import com.example.android.kartooncafe.SubMenuActivity;
import com.example.android.kartooncafe.ui.menu.MenuFragment;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservationFragment extends Fragment {


    private ArrayList<String>dateList=new ArrayList<>();
    private ArrayList<String>timeList=new ArrayList<>();
    private ArrayList<String>numList=new ArrayList<>();
    private LinearLayout layout1,layout2;
    //public static String TYPE_KEY="reservationOrderAhead";






    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_reservation, container, false);

        Button reservationButton;
        RecyclerView dateRCView,timeRCView,numberRCView;
        ReservationAdapter adapter1,adapter2,adapter3;
        dateRCView=root.findViewById(R.id.dateview);
        timeRCView=root.findViewById(R.id.timeview);
        numberRCView=root.findViewById(R.id.numberview);
        layout1=root.findViewById(R.id.timeLayout);
        layout2=root.findViewById(R.id.numLayout);
        reservationButton=root.findViewById(R.id.reservation_button);
        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Would you like to order ahead ?");

                builder.setPositiveButton("Yes, Order Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        MenuFragment ldf = new MenuFragment ();
//                         Bundle args = new Bundle();
//                         args.putString(TYPE_KEY,"reservationOrderAhead");
//                         ldf.setArguments(args);
//                        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, ldf).commit();
                    }
                });

                builder.setNegativeButton("No, Order in Restaurant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //TODO
                    }
                });

                builder.show();
            }
        });

        loadDateList();
        loadTimeList();
        loadNumberList();


        adapter1=new ReservationAdapter(getContext(), dateList, new ReservationItemClickListener() {
            @Override
            public void onReservationItemClicked(View view, int pos) {
               layout1.setVisibility(View.VISIBLE);
            }
        });
        dateRCView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2,RecyclerView.HORIZONTAL,false);
        dateRCView.setLayoutManager(layoutManager);
        dateRCView.setAdapter(adapter1);

        adapter2=new ReservationAdapter(getContext(), timeList, new ReservationItemClickListener() {
            @Override
            public void onReservationItemClicked(View view, int pos) {

                layout2.setVisibility(View.VISIBLE);
            }
        });
        timeRCView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager layoutManager1 = new GridLayoutManager(getContext(),2,RecyclerView.HORIZONTAL,false);
        timeRCView.setLayoutManager(layoutManager1);
        timeRCView.setAdapter(adapter2);

        adapter3=new ReservationAdapter(getContext(), numList, new ReservationItemClickListener() {
            @Override
            public void onReservationItemClicked(View view, int pos) {

            }
        });
        numberRCView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager layoutManager3 = new GridLayoutManager(getContext(),1,RecyclerView.HORIZONTAL,false);
        numberRCView.setLayoutManager(layoutManager3);
        numberRCView.setAdapter(adapter3);



        return root;
    }
    private void loadDateList(){

       String today="TODAY";
        String tommorrow="TOMMORROW";
//        String s = "Sun, Oct 20 2019";
//        String e = "Sat, Nov 02 2019";
        Date date=new Date();
        SimpleDateFormat sdf =new SimpleDateFormat ("yyyy MMM d EEEE");
        String current = sdf.format(date);
       // String s = "2019 Oct 20 Sunday";
        String e = "2019 Nov 30 Saturday";
      //  String e=current.pl

        LocalDate start = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM d EEEE");
            start = LocalDate.parse(current,formatter);
            LocalDate end = LocalDate.parse(e,formatter);
            end=start.plusDays(31);
            List<LocalDate> totalDates = new ArrayList<>();
            while (!start.isAfter(end)) {
                totalDates.add(start);
                start = start.plusDays(1);
            }

            String dateString;
            String finalString;
            for(int i=0;i<totalDates.size();i++){

               dateString = String.valueOf(formatter.format(totalDates.get(i)));
               if(i==0){
                   finalString=today + dateString.substring(4,11) ;
               }
               else if(i==1){
                   finalString=tommorrow + dateString.substring(4,10) ;
               }else{
                   finalString=dateString.substring(4);
               }

               dateList.add(finalString);
            }

        }


    }
    private void loadTimeList(){
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

   private void loadNumberList(){
        numList.add("1");
        numList.add("2");
        numList.add("3");
        numList.add("4");
        numList.add("5");
        numList.add("6");
        numList.add("7+");
    }


}


