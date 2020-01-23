package com.example.calculator.operations.binary;

import com.example.calculator.exceptions.OperationNotFoundException;
import com.example.calculator.operations.Operation;
import com.example.calculator.operations.OperationFactory;
import com.example.calculator.operations.unary.*;

public class BinaryOperationFactory extends OperationFactory {
    protected Double param1;
    protected Double param2;

    public BinaryOperationFactory(Double param1, Double param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    @Override
    public Operation getOperation(String type) throws OperationNotFoundException {
        switch (type) {
            case "power":
                return new AscensionOperation(param1, param2);
            case "log":
                return new LogOperation(param1, param2);
            case "modulo":
                return new ModuloOperation(param1, param2);
            case "minus":
                return new MinusOperation(param1, param2);
            case "plus":
                return new PlusOperation(param1, param2);
            case "divide":
                return new DivisionOperation(param1, param2);
            case "multiplicate":
                return new MultiplicationOperation(param1, param2);

            default:
                throw new OperationNotFoundException(type);
        }
    }
}
