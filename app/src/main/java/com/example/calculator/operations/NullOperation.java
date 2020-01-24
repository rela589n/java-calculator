package com.example.calculator.operations;

import com.example.calculator.exceptions.NullOperandException;

public class NullOperation extends Operation {
    private static NullOperation instance = null;

    @Override
    public Double evaluate() {
        throw new NullPointerException("Default operation");
//        return null;
    }

    private NullOperation() {

    }

    public static NullOperation getInstance() {
        if (instance == null) {
            instance = new NullOperation();
        }
        return instance;
    }
}
