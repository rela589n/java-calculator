package com.example.calculator.operations.unary;

import android.widget.TextView;

public class SqrtOperation extends UnaryOperation {

    public SqrtOperation(TextView param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return Math.sqrt(param);
    }
}
