package com.example.calculator.operations.binary;

import com.example.calculator.operations.Operation;

public abstract class BinaryOperation extends Operation {
    protected Double value1;
    protected Double value2;

    public BinaryOperation(Double value1, Double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public Double evaluate() {
        return doEvaluate(value1, value2);
    }

    protected abstract Double doEvaluate(Double value1, Double value2);
}
