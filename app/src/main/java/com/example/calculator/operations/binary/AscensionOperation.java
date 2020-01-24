package com.example.calculator.operations.binary;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.calculator.R;

public class AscensionOperation extends BinaryOperation {

    public AscensionOperation(TextView textView1, TextView textView2) {
        super(textView1, textView2);
    }

    @Override
    protected Double doEvaluate(Double value1, Double value2) {
        return Math.pow(value1, value2);
    }

}
