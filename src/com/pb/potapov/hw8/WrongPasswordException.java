package com.pb.potapov.hw8;

// эксперимет с переопределением, какие последствия?

public class WrongPasswordException extends Exception {

    private String exMsg;

    public WrongPasswordException(String s) {
        this.exMsg = s;
    }

    @Override
    public String getMessage() {
        return this.exMsg;
    }
}
