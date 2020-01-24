package com.example.calculator.operations;

public abstract class Operation {
    public abstract Double evaluate();

    public Double clean(CharSequence sequence) {
        return Double.parseDouble(sequence.toString().trim().replace(',', '.'));
    }
}
