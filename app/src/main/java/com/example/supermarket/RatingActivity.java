package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class RatingActivity extends AppCompatActivity  {
    float avg;
    private Rating currentRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        initSaveButton();
        //TextView
        Intent intent = getIntent();

        currentRating = new Rating();
    }



        public void initSaveButton() {
            Button saveButton = findViewById(R.id.buttonSave);
            Intent intent = getIntent();
            String sentFromMain = intent.getStringExtra("namekey");
            float avgScore;
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    final RatingBar etLD =findViewById(R.id.ldRatingBar);
                    currentRating.setLiquorDptRating(etLD.getRating());
                    final RatingBar etPD = findViewById(R.id.pdRatingBar);
                    currentRating.setProduceDptRating(etPD.getRating());
                    final RatingBar etMD = findViewById(R.id.mdRatingBar);
                    currentRating.setMeatDptRating(etMD.getRating());
                    final RatingBar etCS = findViewById(R.id.csRatingBar);
                    currentRating.setCheeseSelRating(etCS.getRating());
                    final RatingBar etEOC = findViewById(R.id.eocRatingBar);
                    currentRating.setEocRating(etEOC.getRating());

                     avg = ((currentRating.getLiquorDptRating() +
                            currentRating.getProduceDptRating() +
                            currentRating.getMeatDptRating() +
                            currentRating.getCheeseSelRating() +
                            currentRating.getEocRating()) / 5);

                    boolean wasSuccessful;
                    SuperMarketDataSource ds = new SuperMarketDataSource(RatingActivity.this);
                    try {
                        ds.open();
                        int newID = ds.getMarketNameToID(sentFromMain);
                        currentRating.setSupermarketID(newID);
                        wasSuccessful = ds.updateRating(currentRating);
                        ds.close();

                    } catch (Exception e) {
                        wasSuccessful = false;
                    }

                    if (wasSuccessful) {
                        //display average rating

                        TextView avgRating = findViewById(R.id.showAvg);
                       avgRating.setText("" + avg);
                    }
                }
            });
        }

        public void initgoBackButton(){
        Button goBack = findViewById(R.id.goHome);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RatingActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                String getName = currentRating.getSupermarketName();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("namekey", getName);
                startActivity(intent);
                startActivity(intent);
            }
        });

        }


    }

