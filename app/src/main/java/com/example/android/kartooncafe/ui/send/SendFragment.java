package com.example.android.kartooncafe.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.android.kartooncafe.MainActivity;
import com.example.android.kartooncafe.R;
import com.firebase.ui.auth.AuthUI;

public class SendFragment extends Fragment {

    //private SendViewModel sendViewModel;

    TextView firstName, secondName, accountMail;
    CardView logOutCard;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //   sendViewModel =
        //           ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
//        final TextView textView = root.findViewById(R.id.text_send);
//        sendViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        firstName = root.findViewById(R.id.account_firstName);
        secondName = root.findViewById(R.id.account_lastName);
        accountMail = root.findViewById(R.id.account_mail);
        logOutCard = root.findViewById(R.id.log_out_card);
        String[] splitName = MainActivity.userName.split("\\s+");
        firstName.setText(splitName[0]);
        secondName.setText(splitName[1]);
        accountMail.setText(MainActivity.userEmail);
        logOutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance().signOut(getContext());
            }
        });
        return root;

    }
}