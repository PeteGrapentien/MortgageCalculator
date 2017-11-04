package com.example.pete.mortgagecalculator;

import java.text.NumberFormat;

/**
 * Created by pete on 11/4/17.
 */

public class CalculatorViewModel {

    public String calculateMortgage(double amount, double interest, double duration) {
            interest /= 100.0;
            double monthlyRate = interest / 12.0;
            double termInMonths = duration * 12;
            double monthlyPayment =
                    (amount*monthlyRate) /
                            (1-Math.pow(1+monthlyRate, -termInMonths));

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        return formatter.format(monthlyPayment).toString();
    }
}
