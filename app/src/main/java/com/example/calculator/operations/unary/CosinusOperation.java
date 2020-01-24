package com.example.calculator.operations.unary;

import android.widget.TextView;

public class CosinusOperation extends UnaryOperation {

    public CosinusOperation(TextView param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return Math.cos(param);
    }
}
