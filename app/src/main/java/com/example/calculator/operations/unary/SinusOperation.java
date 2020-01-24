package com.example.calculator.operations.unary;

import android.widget.TextView;

public class SinusOperation extends UnaryOperation {

    public SinusOperation(TextView param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return Math.sin(param);
    }
}
