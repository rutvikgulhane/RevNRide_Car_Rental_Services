package com.revnride.app.exception;

 

public class WrongDataException extends RuntimeException {

	private String error;

  
    public WrongDataException(String error) {
        super(error);
        this.error = error;
    }


    public WrongDataException(String message, String error) {
        super(message);
        this.error = error;
    }


    public WrongDataException(String message, Throwable cause, String error) {
        super(message, cause);
        this.error = error;
    }

  
    public WrongDataException(Throwable cause, String error) {
        super(cause);
        this.error = error;
    }

    public WrongDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
