package com.example.calculator.operations;

import com.example.calculator.exceptions.OperationNotFoundException;

public abstract class OperationFactory {
    public abstract Operation getOperation(String type) throws OperationNotFoundException;
}
