package com.example.android.kartooncafe.ui.send;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.android.kartooncafe.CartHelper;
import com.example.android.kartooncafe.R;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class SendFragment extends Fragment {


    public static String USER_NAME;
    public static String USER_EMAIL;
    public static String USER_CONTACT = "Not Mentioned Yet!";
    public static String USER_ADDRESS = "Not Mentioned Yet!";

    public static String ADDRESS_KEY = "address";
    public static String CONTACT_KEY = "contact";


    public static String MY_PREF_NAME = "delivery_details";

    CardView logOutCard;
    Button locateMeButton, saveDetailsButton;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private Location currentLocation;
    private Location centerLocation;
    private TextView firstName, secondName, accountMail;
    private EditText userAddress, userContact;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_send, container, false);
        findView();

        final LocationManager manager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        centerLocation = new Location("");
        centerLocation.setLatitude(28.6193953);
        centerLocation.setLongitude(77.09188);
        Dexter.withActivity(getActivity())
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Toast.makeText(getContext(), "This Permission is necessary", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                }).check();
        //Get Location
        initLocation();


        String[] splitName = USER_NAME.split("\\s+");
        firstName.setText(splitName[0]);
        secondName.setText(splitName[1]);
        accountMail.setText(USER_EMAIL);
        userAddress.setText(USER_ADDRESS);
        userContact.setText(USER_CONTACT);

        logOutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartHelper.deleteCart(getContext());
                getContext().getSharedPreferences(MY_PREF_NAME, 0).edit().clear().apply();
                AuthUI.getInstance().signOut(getContext());
            }
        });

        saveDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                USER_CONTACT = userContact.getText().toString();
                USER_ADDRESS = userAddress.getText().toString();
                SharedPreferences.Editor editor = getContext().getSharedPreferences(MY_PREF_NAME, Context.MODE_PRIVATE).edit();
                editor.putString(ADDRESS_KEY, USER_ADDRESS);
                editor.putString(CONTACT_KEY, USER_CONTACT);
                editor.apply();
            }
        });

        locateMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    buildAlertMessageNoGps();
                } else {
                    fusedLocationProviderClient.getLastLocation()
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            })
                            .addOnCompleteListener(new OnCompleteListener<Location>() {
                                @Override
                                public void onComplete(@NonNull Task<Location> task) {
//                                    String coordinates = new StringBuilder()
//                                            .append(task.getResult().getLatitude())
//                                            .append("/")
//                                            .append(task.getResult().getLongitude()).toString();
//                                    textView1.setText(coordinates);

                                    float distanceInMeters = centerLocation.distanceTo(currentLocation);
                                    boolean isWithin10km = distanceInMeters < 10000;
                                    //todo gettting error here
                                    String singleAddress = getAddressFromLatLng(task.getResult().getLatitude(),
                                            task.getResult().getLongitude());
                                    USER_ADDRESS = singleAddress + " " + isWithin10km + " " + distanceInMeters;
                                    userAddress.setText(USER_ADDRESS);

                                }
                            });
                }

            }

        });


        return root;

    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private String getAddressFromLatLng(double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
        String result = "";
        try {
            List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
            if (addressList != null && addressList.size() > 0) {
                Address address = addressList.get(0);
                StringBuilder sb = new StringBuilder(address.getAddressLine(0));
                result = sb.toString();
                // Location.distanceBetween((latitude,longi));
            } else {
                result = "Address not found";
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = e.getMessage();
        }
        return result;
    }

    private void initLocation() {
        buildLocationRequest();
        buildLocationCallback();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
    }

    private void buildLocationCallback() {
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                currentLocation = locationResult.getLastLocation();
            }
        };
    }

    private void buildLocationRequest() {
        locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setSmallestDisplacement(10f);
    }

    @Override
    public void onStop() {
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        }

        super.onStop();
    }

    @Override
    public void onResume() {
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
        }
        super.onResume();
    }

    public void findView() {
        firstName = root.findViewById(R.id.account_firstName);
        secondName = root.findViewById(R.id.account_lastName);

        userContact = root.findViewById(R.id.user_contact);
        accountMail = root.findViewById(R.id.account_mail);
        userAddress = root.findViewById(R.id.user_address);

        locateMeButton = root.findViewById(R.id.get_location);
        saveDetailsButton = root.findViewById(R.id.save_details);
        logOutCard = root.findViewById(R.id.log_out_card);


    }
}