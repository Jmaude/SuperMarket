package com.example.supermarket;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Rating currentRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextChangedEvents();
        initEnterRating();
        //Bundle extra = getIntent().getExtras();
        currentRating = new Rating();
        Intent intent = getIntent();
       // String returnName = intent.getStringExtra("returnname");
      /*  if (extra != null) {
            //currentRating.(extra.getInt("marketID"));
        } else {


        }*/
    }

    private void initTextChangedEvents() {
        final EditText etSuperMarketName = findViewById(R.id.editName);
        etSuperMarketName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                currentRating.setSupermarketName(etSuperMarketName.getText().toString());
            }
        });

        final EditText etStreetAddress = findViewById(R.id.editAddress);
        etStreetAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                currentRating.setAddress(etStreetAddress.getText().toString());
            }
        });
        final EditText etCity = findViewById(R.id.cityEdit);
        etStreetAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                currentRating.setAddress(etCity.getText().toString());
            }
        });
        final EditText etState = findViewById(R.id.stateEdit);
        etStreetAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                currentRating.setAddress(etState.getText().toString());
            }
        });
        final EditText etZipcode = findViewById(R.id.zipcodeEdit);
        etStreetAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                currentRating.setAddress(etZipcode.getText().toString());
            }
        });
    }

        private void initEnterRating() {
            Button rateButton = findViewById(R.id.rateButton);
            rateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean wasSuccessful = true;
                    SuperMarketDataSource ds = new SuperMarketDataSource(MainActivity.this);
                   // EditText nameEdit = findViewById(R.id.editName);
                   // EditText addEdit = findViewById(R.id.editAddress);

                    try {
                        ds.open();

                        if (currentRating.getSupermarketID() == -1) {

                            wasSuccessful = ds.insertRating(currentRating);
                            if (wasSuccessful){

                                int newId = ds.getLastSMID();
                                currentRating.setSupermarketID(newId);
                        }
                    }
                    ds.close();

                    } catch (Exception e) {
                        wasSuccessful = false;
                    }

                    if (wasSuccessful) {
                        Intent intent = new Intent(MainActivity.this, RatingActivity.class);
                        String getName = currentRating.getSupermarketName();
                        intent.putExtra("namekey", getName);
                        startActivity(intent);}


                  /*  if (nameEdit.getText().toString().trim().equals("")) {
                        nameEdit.setError("Please enter supermarket name ");

                        nameEdit.setHint("Please enter supermarket name ");

                    } else if (addEdit.getText().toString().trim().equals("")) {
                        addEdit.setError("Please enter address");

                        addEdit.setHint("Please enter address");
*/


                    }
            });
        }
    }
