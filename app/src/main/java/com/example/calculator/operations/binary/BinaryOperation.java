package com.example.calculator.operations.binary;

import android.widget.TextView;
import com.example.calculator.exceptions.DivisionByZeroException;
import com.example.calculator.operations.Operation;

public abstract class BinaryOperation extends Operation {
    protected TextView textView1;
    protected TextView textView2;

    public BinaryOperation(TextView textView1, TextView textView2) {
        this.textView1 = textView1;
        this.textView2 = textView2;
    }

    @Override
    public Double evaluate() throws DivisionByZeroException {
        Double first = clean(textView1.getText());
        Double second = clean(textView2.getText());

        return doEvaluate(first, second);
    }

    protected abstract Double doEvaluate(Double value1, Double value2) throws DivisionByZeroException;
}
