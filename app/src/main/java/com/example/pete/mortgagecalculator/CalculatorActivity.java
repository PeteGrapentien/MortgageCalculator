package com.example.pete.mortgagecalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalculatorActivity extends AppCompatActivity {

    CalculatorViewModel viewModel;
    double amount;
    double interest;
    double duration;

    TextView resultView;
    EditText amountField;
    EditText interestField;
    EditText durationField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        amountField = (EditText) findViewById(R.id.text_amount);
        interestField = (EditText) findViewById(R.id.text_interest);
        durationField = (EditText) findViewById(R.id.text_duration);
        resultView = (TextView) findViewById(R.id.result_view);

        viewModel = new CalculatorViewModel();
        setStartingValues();
        setTextChangedListeners();
    }

    private void setTextChangedListeners() {

        amountField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                resultView.setText(getMortgageResult());
            }
        });

        interestField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resultView.setText(getMortgageResult());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        durationField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resultView.setText(getMortgageResult());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void setStartingValues() {
        amount = 100000;
        interest = 3.5;
        duration = 30;
        amountField.setText(Double.toString(amount));
        interestField.setText(Double.toString(interest));
        durationField.setText(Double.toString(duration));
        resultView.setText(viewModel.calculateMortgage(amount, interest, duration));
    }

    private String getMortgageResult() {
        if(!amountField.getText().toString().isEmpty()) {
            amount = Double.valueOf(amountField.getText().toString());
        }
        else {
            amount = 0;
        }
        if(!interestField.getText().toString().isEmpty()) {
            interest = Double.valueOf(interestField.getText().toString());
        }
        else {
            interest = 0;
        }
        if(!durationField.getText().toString().isEmpty()) {
            duration = Double.valueOf(durationField.getText().toString());
        }
        else {
            duration = 0;
        }
        return viewModel.calculateMortgage(amount, interest, duration);
    }
}
