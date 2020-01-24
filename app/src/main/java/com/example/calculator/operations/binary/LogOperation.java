package com.example.calculator.operations.binary;

import android.widget.TextView;

public class LogOperation extends BinaryOperation {

    public LogOperation(TextView textView1, TextView textView2) {
        super(textView1, textView2);
    }

    @Override
    protected Double doEvaluate(Double value1, Double value2) {
        return (Math.log(value1) / Math.log(value2));
    }
}
