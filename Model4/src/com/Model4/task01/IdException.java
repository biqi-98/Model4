package com.Model4.task01;

/**
 * 学号异常类
 */
public class IdException extends Exception {

    private static final long serialVersionUID = -2431956620343885565L;

    public IdException() {
    }

    public IdException(String message) {
        super(message);
    }
}
