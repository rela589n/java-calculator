package com.example.calculator.operations.unary;

import com.example.calculator.exceptions.OperationNotFoundException;
import com.example.calculator.operations.Operation;
import com.example.calculator.operations.OperationFactory;

public class UnaryOperationFactory extends OperationFactory {
    protected Double param;

    public UnaryOperationFactory(Double param) {
        this.param = param;
    }

    @Override
    public Operation getOperation(String type) throws OperationNotFoundException {
        switch (type) {
            case "sinus":
                return new SinusOperation(param);
            case "cosinus":
                return new CosinusOperation(param);
            case "tangens":
                return new TangensOperation(param);
            case "cotangens":
                return new CotangensOperation(param);
            case "sqrt":
                return new SqrtOperation(param);
            default:
                throw new OperationNotFoundException(type);
        }
    }
}
