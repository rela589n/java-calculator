package com.example.calculator.operations.unary;

public class SinusOperation extends UnaryOperation {
    public SinusOperation(Double param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return Math.sin(param);
    }
}
