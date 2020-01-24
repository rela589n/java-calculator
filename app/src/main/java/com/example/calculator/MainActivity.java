package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.calculator.exceptions.DivisionByZeroException;
import com.example.calculator.exceptions.NullOperandException;
import com.example.calculator.exceptions.OperationNotFoundException;
import com.example.calculator.operations.NullOperation;
import com.example.calculator.operations.Operation;
import com.example.calculator.operations.OperationFactory;
import com.example.calculator.operations.binary.BinaryOperationFactory;
import com.example.calculator.operations.unary.UnaryOperationFactory;

public class MainActivity extends AppCompatActivity {
    private TextView firstOperand;
    private EditText secondOperand;
    private TextView operationField;

    private Operation lastOperation = NullOperation.getInstance();

    public void onPointClick(View v) {
        Button button = (Button) v;

        if (!secondOperand.getText().toString().contains(button.getText())) {
            secondOperand.append(button.getText());
        }
    }

    public void onNumberClick(View v) {
        Button btn = (Button) v;

        secondOperand.append(btn.getText());
    }

    private void placeCursorToEnd(EditText editText) {
        editText.setSelection(editText.getText().length());
    }

    public void onFunctionalKeyClick(View view) {
        Button btn = (Button) view;

        switch (btn.getId()) {
            case R.id.equals:
                Double result = this.lastOperation.evaluate();
                setFirstOperand(result);
                setSecondOperand(null);
                this.lastOperation = NullOperation.getInstance();
                this.operationField.setText("");

                break;
            case R.id.pi:
                this.setSecondOperand(Math.PI);
                break;
        }
    }

    public void onUnaryOperationClick(View view) throws OperationNotFoundException {
        Button button = (Button) view;

        OperationFactory factory = new UnaryOperationFactory(this.firstOperand);
        Operation newOperation = factory.getOperation(button.getId());

        try {
            Double result = this.lastOperation.evaluate();
            setFirstOperand(result);

            setSecondOperand(newOperation.evaluate());
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
        }

        this.lastOperation = newOperation;
        this.operationField.setText(button.getText());
    }

    public void onBinaryOperationClick(View view) throws OperationNotFoundException {
        Button button = (Button) view;
        OperationFactory factory = new BinaryOperationFactory(firstOperand, secondOperand);
        Operation newOperation = factory.getOperation(button.getId());

        try {
            Double result = this.lastOperation.evaluate();
            setFirstOperand(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSecondOperand(null);

        this.lastOperation = newOperation;
        this.operationField.setText(button.getText());
    }

    private String doubleToText(Double var) {
        return (var == null) ? "" : var.toString();
    }

    public void setSecondOperand(Double secondOperandVal) {
        this.secondOperand.setText(doubleToText(secondOperandVal));
    }

    public void setFirstOperand(Double firstOperandVal) {
        String text = (firstOperandVal == null) ? secondOperand.getText().toString() : doubleToText(firstOperandVal);

        this.firstOperand.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        this.firstOperand = findViewById(R.id.bufferField);
        this.operationField = (TextView) findViewById(R.id.operationField);
        this.secondOperand = findViewById(R.id.inputField);
    }

    public void onClearClick(View view) {
        this.setSecondOperand(null);
        this.setFirstOperand(null);
        this.operationField.setText("");
        this.lastOperation = NullOperation.getInstance();
    }

    public void onEraseClick(View view) {
        String text = this.secondOperand.getText().toString();
        this.secondOperand.setText(text.substring(0, text.length() - 1));
        placeCursorToEnd(this.secondOperand);
    }
}
