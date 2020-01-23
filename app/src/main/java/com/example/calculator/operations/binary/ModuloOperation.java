package com.example.calculator.operations.binary;

public class ModuloOperation extends BinaryOperation {
    public ModuloOperation(Double value1, Double value2) {
        super(value1, value2);
    }

    @Override
    protected Double doEvaluate(Double value1, Double value2) {
        return value1 % value2;
    }
}
