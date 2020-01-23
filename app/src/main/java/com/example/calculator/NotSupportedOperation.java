package com.example.calculator;

public class NotSupportedOperation extends Exception {
    private String operation;

    public NotSupportedOperation(String operation) {
        this.operation = operation;
    }
}
