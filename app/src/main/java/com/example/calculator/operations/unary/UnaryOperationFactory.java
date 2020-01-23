package com.example.calculator.operations.unary;

import com.example.calculator.R;
import com.example.calculator.exceptions.OperationNotFoundException;
import com.example.calculator.operations.Operation;
import com.example.calculator.operations.OperationFactory;

public class UnaryOperationFactory extends OperationFactory {
    protected Double param;

    public UnaryOperationFactory(Double param) {
        this.param = param;
    }

    @Override
    public Operation getOperation(int id) throws OperationNotFoundException {
        switch (id) {
            case R.id.sinus:
                return new SinusOperation(param);
            case R.id.cosinus:
                return new CosinusOperation(param);
            case R.id.tangens:
                return new TangensOperation(param);
            case R.id.cotangens:
                return new CotangensOperation(param);
            case R.id.sqrt:
                return new SqrtOperation(param);
            default:
                throw new OperationNotFoundException("Not found: " +id);
        }
    }
}
