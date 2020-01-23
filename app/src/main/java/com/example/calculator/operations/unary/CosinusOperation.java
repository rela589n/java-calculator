package com.example.calculator.operations.unary;

public class CosinusOperation extends UnaryOperation {
    public CosinusOperation(Double param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return Math.cos(param);
    }
}
