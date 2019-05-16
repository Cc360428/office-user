package com.office.user.service.ex;

public class AccountConflictException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public AccountConflictException() {
    }

    public AccountConflictException(String message) {
        super(message);
    }

    public AccountConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountConflictException(Throwable cause) {
        super(cause);
    }

    public AccountConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
