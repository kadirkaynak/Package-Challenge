package com.kadirkaynak.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class ItemException extends Exception {

    private long lineNum;

    public ItemException(String message, long lineNum) {
        super(message);
        this.lineNum = lineNum;
    }

}
