package com.example.calculator.operations.binary;

import android.widget.TextView;

public class PlusOperation extends BinaryOperation {

    public PlusOperation(TextView textView1, TextView textView2) {
        super(textView1, textView2);
    }

    @Override
    protected Double doEvaluate(Double value1, Double value2) {
        return value1 + value2;
    }
}
