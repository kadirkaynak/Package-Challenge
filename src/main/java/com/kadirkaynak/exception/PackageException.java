package com.kadirkaynak.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class PackageException extends Exception {

    private long lineNum;

    public PackageException(String message, long lineNum) {
        super(message);
        this.lineNum = lineNum;
    }
}
