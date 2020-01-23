package com.example.calculator.operations.unary;

public class CotangensOperation extends UnaryOperation {
    public CotangensOperation(Double param) {
        super(param);
    }

    @Override
    protected Double doEvaluate(Double param) {
        return 1. / Math.tan(param);
    }
}
