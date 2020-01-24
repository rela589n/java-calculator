package com.example.calculator.operations;

import com.example.calculator.exceptions.DivisionByZeroException;

public abstract class Operation {
    public abstract Double evaluate() throws DivisionByZeroException;

    public Double clean(CharSequence sequence) {
        return Double.parseDouble(sequence.toString().trim().replace(',', '.'));
    }
}
