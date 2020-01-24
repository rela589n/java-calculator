package com.example.calculator.operations.unary;

import android.widget.TextView;

public class NothingOperation extends UnaryOperation {
    public NothingOperation(TextView param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return param;
    }
}
