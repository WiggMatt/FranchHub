package ru.accelerator.FranchHub.exceptions;

public class CustomGetFranchiseInformationException extends RuntimeException {
    public CustomGetFranchiseInformationException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomGetFranchiseInformationException(String message) {
        super(message);
    }
}
