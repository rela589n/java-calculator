package com.example.calculator.operations.binary;

import android.content.Context;
import android.widget.TextView;
import com.example.calculator.R;
import com.example.calculator.exceptions.OperationNotFoundException;
import com.example.calculator.operations.Operation;
import com.example.calculator.operations.OperationFactory;
import com.example.calculator.operations.unary.*;

public class BinaryOperationFactory extends OperationFactory {
    protected TextView param1;
    protected TextView param2;

    public BinaryOperationFactory(TextView param1, TextView param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    @Override
    public Operation getOperation(int id) throws OperationNotFoundException {

        switch (id) {
            case R.id.power:
                return new AscensionOperation(param1, param2);
            case R.id.log:
                return new LogOperation(param1, param2);
            case R.id.modulo:
                return new ModuloOperation(param1, param2);
            case R.id.minus:
                return new MinusOperation(param1, param2);
            case R.id.plus:
                return new PlusOperation(param1, param2);
            case R.id.divide:
                return new DivisionOperation(param1, param2);
            case R.id.multiplicate:
                return new MultiplicationOperation(param1, param2);

            default:
                throw new OperationNotFoundException("Not found: " + id);
        }
    }
}
