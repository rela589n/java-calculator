package com.example.calculator.operations.binary;

public class AscensionOperation extends BinaryOperation {
    public AscensionOperation(Double value1, Double value2) {
        super(value1, value2);
    }

    @Override
    protected Double doEvaluate(Double value1, Double value2) {
        return Math.pow(value1, value2);
    }
}
