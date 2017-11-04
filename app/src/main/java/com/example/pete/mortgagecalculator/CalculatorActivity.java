package com.example.pete.mortgagecalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

            String alertMessage = "Your Monthly Payment is " + viewModel.calculateMortgage(amount, interest, duration);
            AlertDialog alertDialog = new AlertDialog.Builder(CalculatorActivity.this).create();
            alertDialog.setTitle("Monthly Payment");
            alertDialog.setMessage(alertMessage);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,
                    "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            alertDialog.show();
        }
    };
}
