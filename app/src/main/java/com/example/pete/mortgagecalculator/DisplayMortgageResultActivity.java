package com.example.pete.mortgagecalculator;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMortgageResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_mortgage_result);
        double amount = (double) getIntent().getExtras().get("amount");
        double interest = (double) getIntent().getExtras().get("interest");
        double duration = (double) getIntent().getExtras().get("duration");
        String monthlyPayment = (String) getIntent().getExtras().get("monthlyPayment");

        TextView monthlyMortgageLabel = (TextView) findViewById(R.id.monthly_mortgage_label);
        monthlyMortgageLabel.setText("Your monthly payment is " + monthlyPayment);
    }
}
