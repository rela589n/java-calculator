package com.example.calculator.operations.unary;

import android.widget.TextView;
import com.example.calculator.operations.Operation;

public abstract class UnaryOperation extends Operation {
    protected TextView param;

    public UnaryOperation(TextView param) {
        this.param = param;
    }

    @Override
    public Double evaluate() {
        Double paramV = Double.parseDouble(param.getText().toString());
        return doEvaluate(paramV);
    }

    protected abstract Double doEvaluate(Double param);
}
