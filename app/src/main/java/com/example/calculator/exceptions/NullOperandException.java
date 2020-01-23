package com.example.calculator.exceptions;

public class NullOperandException extends Exception {
    private OPERAND operand;
    public enum OPERAND {
        FIRST,
        SECOND,
        THIRD
    };

    public NullOperandException(OPERAND op) {
        this.operand = op;
    }

    public OPERAND getOperand() {
        return operand;
    }
}
