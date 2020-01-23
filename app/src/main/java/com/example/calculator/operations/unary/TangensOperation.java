package com.example.calculator.operations.unary;

public class TangensOperation extends UnaryOperation {
    public TangensOperation(Double param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return Math.tan(param);
    }
}
