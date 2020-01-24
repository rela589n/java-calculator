package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.calculator.exceptions.DivisionByZeroException;
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
                try {
                    Double result = this.lastOperation.evaluate();
                    setFirstOperand(result);

                    //this.lastOperation = new NothingOperation(this.firstOperand);
                    this.lastOperation = NullOperation.getInstance();
                } catch (DivisionByZeroException e) {
                    this.clear();
                }
                catch (Exception e) {

                }
                setSecondOperand(null);
                //this.lastOperation =
                //this.lastOperation = NullOperation.getInstance();
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
        }
        catch (NullPointerException e) {

        }
        catch (DivisionByZeroException e) {
            this.clear();
        }
        catch (Exception e) {
            //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
        }
        try {
            setSecondOperand(newOperation.evaluate());
            this.lastOperation = newOperation;
            this.operationField.setText(button.getText());
        }
        catch (DivisionByZeroException e) {
            this.clear();
        }
        catch (NullPointerException e) {

        }

    }

    public void onBinaryOperationClick(View view) throws OperationNotFoundException {
        Button button = (Button) view;
        OperationFactory factory = new BinaryOperationFactory(firstOperand, secondOperand);
        Operation newOperation = factory.getOperation(button.getId());

        try {
            Double result = this.lastOperation.evaluate();
            setFirstOperand(result);
        }
        catch (DivisionByZeroException e) {
            this.clear();
        }
        catch (NullPointerException e) {
            String text = this.secondOperand.getText().toString();
            if (text.length() != 0 ) {
                this.firstOperand.setText(text);
            }
        }
        catch (Exception e) {
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
        String text = doubleToText(firstOperandVal);

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

    private void clear() {
        String text = this.secondOperand.getText().toString();
        if (text.length() == 0) {
            text = " ";
        }
        this.secondOperand.setText(text.substring(0, text.length() - 1));
        placeCursorToEnd(this.secondOperand);
    }

    public void onEraseClick(View view) {
        this.clear();
    }
}