package com.office.user.service.ex;

public class InsertDataException extends  ServiceException{
    private static final long serialVersionUID = 1L;

    public InsertDataException() {
    }

    public InsertDataException(String message) {
        super(message);
    }

    public InsertDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertDataException(Throwable cause) {
        super(cause);
    }

    public InsertDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
