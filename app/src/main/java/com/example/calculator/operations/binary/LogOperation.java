package com.example.calculator.operations.binary;

public class LogOperation extends BinaryOperation {
    public LogOperation(Double value1, Double value2) {
        super(value1, value2);
    }

    @Override
    protected Double doEvaluate(Double value1, Double value2) {
        return (Math.log(value1) / Math.log(value2));
    }
}
