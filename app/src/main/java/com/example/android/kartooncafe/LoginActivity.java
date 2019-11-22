package com.example.android.kartooncafe;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    public static final int RC_SIGN_IN = 1;
    FirebaseAuth firebaseAuth;
    FrameLayout frameLayout;
    LottieAnimationView animationView;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
//        firebaseAuth = FirebaseAuth.getInstance();
//        frameLayout=findViewById(R.id.loading_screen);
//        authStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    //   String x=user.getPhotoUrl().toString();
//                    //  Toast.makeText(MainActivity.this,x,Toast.LENGTH_LONG).show();
//                    onSignedInInitialize(user.getDisplayName(), user.getEmail());
//
//                } else {
//                    onSignedOutCleanup();
//                    startActivityForResult(
//                            AuthUI.getInstance()
//                                    .createSignInIntentBuilder()
//                                    .setIsSmartLockEnabled(false)
//                                    .setTheme(R.style.LoginTheme)
//                                    .setLogo(R.mipmap.ic_launcher_round)
//                                    .setAvailableProviders(Arrays.asList(
//                                            new AuthUI.IdpConfig.EmailBuilder().build(),
//                                            new AuthUI.IdpConfig.GoogleBuilder().build())).build(), RC_SIGN_IN);
//
//                }
//            }
//        };
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        // Toast.makeText(this, requestCode + "" + resultCode, Toast.LENGTH_LONG).show();
//        if (requestCode == RC_SIGN_IN) {
//            if (resultCode == RESULT_OK) {
//                Toast.makeText(this, "Signed In", Toast.LENGTH_LONG).show();
//            } else if (resultCode == RESULT_CANCELED) {
//                // Toast.makeText(this, "Sign In Canceled ", Toast.LENGTH_LONG).show();
//                finish();
//            }
//        }
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        firebaseAuth.removeAuthStateListener(authStateListener);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        firebaseAuth.addAuthStateListener(authStateListener);
//    }
//
//    private void onSignedInInitialize(String username, String email) {
//        MainActivity.userName = username;
//        MainActivity.userEmail = email;
//        animationView=new LottieAnimationView(this);
//        animationView.setAnimation(R.raw.star);
//        frameLayout.addView(animationView);
//        animationView.playAnimation();
//
//
//        Intent intent=new Intent(this,MainActivity.class);
//        startActivity(intent);
//        // userPic = photoUrl;
////        textView1.setText(userName);
////        textView2.setText(userEmail);
////        if (userPic != null)
////            Glide.with(imageView).load(userPic).apply(new RequestOptions().centerCrop()).into(imageView);
//
//
//    }
//
//    private void onSignedOutCleanup() {
//        MainActivity.userName="ANONYMOUS";
//        MainActivity.userEmail="null";
//
//    }
//
//}
