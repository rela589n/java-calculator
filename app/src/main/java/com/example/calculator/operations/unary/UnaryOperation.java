package com.example.calculator.operations.unary;

import com.example.calculator.operations.Operation;

public abstract class UnaryOperation extends Operation {
    protected Double param;

    public UnaryOperation(Double param) {
        this.param = param;
    }

    @Override
    public Double evaluate() {
        return doEvaluate(param);
    }

    protected abstract Double doEvaluate(Double param);
}
