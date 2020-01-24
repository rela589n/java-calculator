package com.example.calculator.operations.unary;

import android.widget.TextView;

public class TangensOperation extends UnaryOperation {

    public TangensOperation(TextView param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return Math.tan(param);
    }
}
