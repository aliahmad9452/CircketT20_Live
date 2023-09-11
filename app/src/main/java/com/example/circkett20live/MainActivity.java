package com.example.circkett20live;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.circkett20live.Ads.Admob;
import com.example.circkett20live.Ads.MainAppClass;
import com.example.circkett20live.databinding.ActivityMainBinding;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends MainAppClass {
    private DatabaseReference databaseReference;
    private TextView scoreOutTextView;
    private TextView oversBallsTextView;
    private TextView scoreOut2TextView;
    private TextView oversBalls2TextView, Country_Name, Country_Name2;
    ActivityMainBinding binding;
    CircleImageView Country_Flag, Country_Flag2;
    ProgressDialog dialog;
    private TextView textViewStatus;
    private TextView textViewmatchType;
    private TextView textViewcurrentSituation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("teams");

        textViewStatus = findViewById(R.id.status);
        textViewmatchType = findViewById(R.id.textViewmatchType);
        textViewcurrentSituation = findViewById(R.id.textViewcurrentSituation);


        // Initialize TextViews
        scoreOutTextView = findViewById(R.id.Score_Out);
        oversBallsTextView = findViewById(R.id.Overs_Balls);
        scoreOut2TextView = findViewById(R.id.Score_Out2);
        oversBalls2TextView = findViewById(R.id.Overs_Balls2);
        Country_Flag = findViewById(R.id.Country_Flag);
        Country_Flag2 = findViewById(R.id.Country_Flag2);
        Country_Name2 = findViewById(R.id.Country_Name2);
        Country_Name = findViewById(R.id.Country_Name);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("teams");
        // Retrieve data directly under the "teams" node
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String status = dataSnapshot.child("status").getValue(String.class);
                    String matchType = dataSnapshot.child("matchType").getValue(String.class);
                    String currentSituation = dataSnapshot.child("currentSituation").getValue(String.class);

                    // Set the retrieved values to the TextViews with their respective IDs
                    textViewStatus.setText(status);
                    textViewmatchType.setText(matchType);
                    textViewcurrentSituation.setText(currentSituation);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors that may occur
            }
        });

        // Assuming you want to retrieve data for Team A
        DatabaseReference teamAReference = databaseReference.child("teamA");
        DatabaseReference teamBReference = databaseReference.child("teamB");

        teamAReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Team team = dataSnapshot.getValue(Team.class);
                    if (team != null) {
                        String score = team.getScore();
                        String overs = team.getOvers();
                        String imageUri = team.getImageUri();
                        String countryName = team.getCountryName();
                        // Use the data for Team A
                        scoreOutTextView.setText(score);
                        oversBallsTextView.setText(overs);
                        Country_Name.setText(countryName);
                        Glide.with(MainActivity.this).load(team.getImageUri()).into(Country_Flag);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors that may occur
            }
        });

        teamBReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Team team = dataSnapshot.getValue(Team.class);
                    if (team != null) {
                        String score = team.getScore();
                        String overs = team.getOvers();
                        String imageUri = team.getImageUri();
                        String countryName = team.getCountryName();
                        // Use the data for Team B
                        scoreOut2TextView.setText(score);
                        oversBalls2TextView.setText(overs);
                        Country_Name2.setText(countryName);
                        Glide.with(MainActivity.this).load(team.getImageUri()).into(Country_Flag2);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors that may occur
            }
        });

        LoadBannerAds();

        binding.checkMatchesTextView.setOnClickListener(view -> {
            ShowFullScreenAd();
        });
    }

    private void LoadBannerAds() {
        MobileAds.initialize(getApplicationContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);
        binding.adView.setVisibility(View.VISIBLE);
        binding.progressBar.setVisibility(View.GONE);
    }

    private void ShowFullScreenAd() {
        dialog = new ProgressDialog(this, R.style.AppCompatAlertDialogStyle);
        dialog.setMessage("Please wait a second...");
        dialog.show();

        if (Admob.mInterstitialAd != null) {
            Admob.mInterstitialAd.show((Activity) MainActivity.this);
            Admob.mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                    dialog.dismiss();

                    Admob.loadEnter(MainActivity.this);

                    Admob.mInterstitialAd = null;
                    Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);
                    Admob.mInterstitialAd = null;
                    dialog.dismiss();
                }

                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                    Admob.mInterstitialAd = null;
                    dialog.dismiss();
                }
            });
        } else {
            Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            Admob.mInterstitialAd = null;
            dialog.dismiss();
        }
    }
}
