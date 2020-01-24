package com.example.calculator.operations.binary;

import android.widget.TextView;
import com.example.calculator.operations.Operation;

public abstract class BinaryOperation extends Operation {
    protected TextView textView1;
    protected TextView textView2;

    public BinaryOperation(TextView textView1, TextView textView2) {
        this.textView1 = textView1;
        this.textView2 = textView2;
    }

    @Override
    public Double evaluate() {
        Double first = Double.parseDouble(textView1.getText().toString());
        Double second = Double.parseDouble(textView2.getText().toString());

        return doEvaluate(first, second);
    }

    protected abstract Double doEvaluate(Double value1, Double value2);
}
