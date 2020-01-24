package com.example.calculator.operations.binary;

import android.widget.TextView;

public class MinusOperation extends BinaryOperation {

    public MinusOperation(TextView textView1, TextView textView2) {
        super(textView1, textView2);
    }

    @Override
    protected Double doEvaluate(Double value1, Double value2) {
        return value1 - value2;
    }
}
