package com.office.user.service.ex;

public class AccountNotFoundException  extends ServiceException{
    private static final long serialVersionUID = 1L;

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotFoundException(Throwable cause) {
        super(cause);
    }

    public AccountNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
