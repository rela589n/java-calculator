package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
    private TextView bufferField;
    private TextView operationField;
    private EditText inputField;

    private Double firstOperand = null;
    private Double secondOperand = null;

    private Operation lastOperation = new NullOperation();

    public void onNumberClick(View v) {
        Button btn = (Button) v;

//        if (lastOperation == "=" && firstOperand != null) {
//            firstOperand = null;
//            inputField.setText("");
//        }

        inputField.append(btn.getText());
    }

    private void evaluateSecondOperand() throws NumberFormatException {
        String text = inputField.getText().toString().trim().replace(',', '.');
        this.secondOperand = (text.length() == 0) ? null : Double.parseDouble(text);
    }

    public void onOperationClick(View view) throws Exception {
        Button button = (Button) view;
        String newOperation = button.getText().toString();

//        try {
//            evaluateSecondOperand();
//            Double result = performOperation(firstOperand, lastOperation, secondOperand);

//            bufferField.setText(result.toString());
//            firstOperand = result;
//            inputField.setText("");
//            operationField.setText(newOperation);
//        } catch (NumberFormatException e) {
//            inputField.setText("");
//        } catch (DivisionByZeroException e) {
//            inputField.setText("");
//        } catch (NullOperandException e) {
//
//            switch (e.getOperand()) {
//                case FIRST:
//                    firstOperand = secondOperand;
//                    bufferField.setText(secondOperand.toString());
//
//                case SECOND:
//                    setOperation(newOperation);
//                    break;
//            }

//        } catch (NotSupportedOperation e) {
//            e.printStackTrace();
//        }
    }

    private void placeCursorToEnd(EditText editText) {
        editText.setSelection(editText.getText().length());
    }

    public void onFunctionalKeyClick(View view) {
        Button btn = (Button) view;

        switch ((String) btn.getText()) {
            case "=":

//                try {
                evaluateSecondOperand();
//                    String result = performOperation(firstOperand, lastOperation, secondOperand).toString();
//                setOperation();
                setFirstOperand(null);
//                    inputField.setText(result);
                placeCursorToEnd(inputField);
//                } catch (NumberFormatException | NullOperandException | DivisionByZeroException | NotSupportedOperation e) {
//                    inputField.setText("");
//                }

                break;
        }
    }

    public void onUnaryOperationClick(View view) throws OperationNotFoundException {
        Button btn = (Button) view;

        OperationFactory factory = new UnaryOperationFactory(this.secondOperand);
        Operation op = factory.getOperation(btn.getId());

        evaluateSecondOperand();
        this.lastOperation = op;
    }

    public void onBinaryOperationClick(View view) throws OperationNotFoundException {
        Button button = (Button) view;
        OperationFactory factory = new BinaryOperationFactory(firstOperand, secondOperand);
        Operation op = factory.getOperation(button.getId());

        evaluateSecondOperand();
        Double result = this.lastOperation.evaluate();
        setFirstOperand(result);

        this.lastOperation = op;
        this.operationField.setText(button.getText());
    }

    public void setOperation(Operation operation) {
        this.operationField.setText(operation.toString());
        this.inputField.setText("");
        operation.getClass();
        this.lastOperation = operation;
    }

    private String doubleToText(Double var) {
        return (var == null) ? "" : var.toString();
    }

    public void setSecondOperand(Double secondOperandVal) {
        this.secondOperand = secondOperandVal;
        this.inputField.setText(doubleToText(secondOperandVal));
    }

    public void setFirstOperand(Double firstOperandVal) {
        if (firstOperandVal == null) {
            firstOperandVal = secondOperand;
            setSecondOperand(null);
        }

        this.firstOperand = firstOperandVal;
        this.bufferField.setText(doubleToText(firstOperandVal));
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
