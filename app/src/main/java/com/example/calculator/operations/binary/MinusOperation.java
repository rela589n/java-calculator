package com.example.calculator.operations.binary;

import android.widget.TextView;

public class MinusOperation extends BinaryOperation {

    public MinusOperation(TextView textView1, TextView textView2) {
        super(textView1, textView2);
    }

    @Override
    public Double evaluate() {
        Double first;
        try {
            first = clean(textView1.getText());
        }
        catch (NumberFormatException e) {
            first = 0.0;
        }

        Double second = clean(textView2.getText());
        return doEvaluate(first, second);
    }

    @Override
    protected Double doEvaluate(Double value1, Double value2) {
        return value1 - value2;
    }
}
