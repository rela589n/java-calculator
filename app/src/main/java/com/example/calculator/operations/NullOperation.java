package com.example.calculator.operations;

public class NullOperation extends Operation {
    private static NullOperation instance = null;

    @Override
    public Double evaluate() {
        return null;
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
