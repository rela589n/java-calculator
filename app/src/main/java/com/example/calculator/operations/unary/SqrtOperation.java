package com.example.calculator.operations.unary;

public class SqrtOperation extends UnaryOperation {
    public SqrtOperation(Double param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return Math.sqrt(param);
    }
}
