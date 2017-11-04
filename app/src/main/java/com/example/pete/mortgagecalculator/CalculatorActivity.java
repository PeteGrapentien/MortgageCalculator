package com.example.pete.mortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    CalculatorViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        EditText amount = (EditText) findViewById(R.id.text_amount);
        EditText interest = (EditText) findViewById(R.id.text_interest);
        EditText duration = (EditText) findViewById(R.id.text_duration);

        Button calculateButton = (Button) findViewById(R.id.calculate_button);

        viewModel = new CalculatorViewModel();

    }
}
