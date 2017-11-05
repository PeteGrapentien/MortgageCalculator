package com.example.pete.mortgagecalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {

    CalculatorViewModel viewModel;
    double amount;
    double interest;
    double duration;

    EditText amountField;
    EditText interestField;
    EditText durationField;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        amountField = (EditText) findViewById(R.id.text_amount);
        interestField = (EditText) findViewById(R.id.text_interest);
        durationField = (EditText) findViewById(R.id.text_duration);
        calculateButton = (Button) findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(calculateListener);
        viewModel = new CalculatorViewModel();
    }

    private View.OnClickListener calculateListener = new View.OnClickListener() {
        public void onClick(View v) {

            amount = Double.valueOf(amountField.getText().toString());
            interest = Double.valueOf(interestField.getText().toString());
            duration = Double.valueOf(durationField.getText().toString());

            Intent intent = new Intent(CalculatorActivity.this, DisplayMortgageResultActivity.class);
            intent.putExtra("amount", amount);
            intent.putExtra("interest", interest);
            intent.putExtra("duration", duration);
            intent.putExtra("monthlyPayment", viewModel.calculateMortgage(amount, interest, duration));

            startActivity(intent);
        }
    };
}
