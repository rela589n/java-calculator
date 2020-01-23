package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.calculator.exceptions.DivisionByZeroException;
import com.example.calculator.exceptions.NullOperandException;

public class MainActivity extends AppCompatActivity {
    private TextView bufferField;
    private TextView operationField;
    private EditText inputField;

    private Double firstOperand = null;
    private Double secondOperand = null;

    private String lastOperation = null;

    public void onNumberClick(View v) {
        Button btn = (Button) v;

        if (lastOperation == "=" && firstOperand != null) {
            firstOperand = null;
            inputField.setText("");
        }

        inputField.append(btn.getText());
    }

    private void evaluateSecondOperand() throws NumberFormatException {
        String text = inputField.getText().toString().trim().replace(',', '.');
        this.secondOperand = (text.length() == 0) ? null : Double.parseDouble(text);
    }

    public void onOperationClick(View view) throws Exception {
        Button button = (Button) view;
        String operation = button.getText().toString();

        try {
            evaluateSecondOperand();
            Double result = performOperation(firstOperand, lastOperation, secondOperand);

            bufferField.setText(result.toString());
            firstOperand = result;
            inputField.setText("");
            operationField.setText(operation);
        } catch (NumberFormatException e) {
            inputField.setText("");
        } catch (DivisionByZeroException e) {
            inputField.setText("");
        } catch (NullOperandException e) {

            switch (e.getOperand()) {
                case FIRST:
                    firstOperand = secondOperand;
                    bufferField.setText(secondOperand.toString());

                case SECOND:
                    setOperation(operation);
                    break;
            }

        } catch (NotSupportedOperation e) {
            e.printStackTrace();
        }
    }

    private void placeCursorToEnd(EditText editText) {
        editText.setSelection(editText.getText().length());
    }

    public void onFunctionalKeyClick(View view) {
        Button btn = (Button) view;

        switch ((String) btn.getText()) {
            case "=":

                try {
                    evaluateSecondOperand();
                    String result = performOperation(firstOperand, lastOperation, secondOperand).toString();
                    setOperation("");
                    setBufferField("");
                    inputField.setText(result);
                    placeCursorToEnd(inputField);
                } catch (NumberFormatException | NullOperandException | DivisionByZeroException | NotSupportedOperation e) {
                    inputField.setText("");
                }

                break;
        }
    }

    public void onUnaryOperationClick(View view) {
        Button btn = (Button) view;

    }

    public void setOperation(String operation) {
        this.operationField.setText(operation);
        this.inputField.setText("");
        this.lastOperation = operation;
    }

    public void setBufferField(String bufferField) {
        this.bufferField.setText(bufferField);
        this.firstOperand = (bufferField == "") ? null : Double.parseDouble(bufferField);
    }

//    private Double performOperation()

    private Double performOperation(Double first, String operation, Double second) throws NullOperandException, DivisionByZeroException, NotSupportedOperation {
        if (first == null) {
            throw new NullOperandException(NullOperandException.OPERAND.FIRST);
        }
        if (second == null) {
            throw new NullOperandException(NullOperandException.OPERAND.SECOND);
        }

        switch (operation) {
            case "/":
                if (second == 0) {
                    throw new DivisionByZeroException();
                }

                return first / second;
            case "*":
                return first * second;
            case "+":
                return first + second;
            case "-":
                return first - second;
            default:
                throw new NotSupportedOperation(operation);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        this.bufferField = findViewById(R.id.bufferField);
        this.operationField = (TextView) findViewById(R.id.operationField);
        this.inputField = findViewById(R.id.inputField);
    }
}
