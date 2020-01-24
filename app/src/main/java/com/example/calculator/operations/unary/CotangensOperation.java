package com.example.calculator.operations.unary;

import android.widget.TextView;

public class CotangensOperation extends UnaryOperation {

    public CotangensOperation(TextView param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return 1. / Math.tan(param);
    }
}
