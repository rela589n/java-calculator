package com.example.calculator.operations.binary;

import android.widget.TextView;
import com.example.calculator.exceptions.DivisionByZeroException;

public class DivisionOperation extends BinaryOperation {

    public DivisionOperation(TextView textView1, TextView textView2) {
        super(textView1, textView2);
    }

    @Override
    protected Double doEvaluate(Double value1, Double value2) throws DivisionByZeroException {
        if (value2 == 0.0) {
            throw new DivisionByZeroException();
        }
        return value1 / value2;
    }
}
