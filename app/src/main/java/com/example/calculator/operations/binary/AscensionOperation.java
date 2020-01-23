package com.example.calculator.operations.binary;

import androidx.annotation.NonNull;
import com.example.calculator.R;

public class AscensionOperation extends BinaryOperation {
    public AscensionOperation(Double value1, Double value2) {
        super(value1, value2);
    }

    @Override
    protected Double doEvaluate(Double value1, Double value2) {
        return Math.pow(value1, value2);
    }

}
