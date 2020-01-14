package de.wizy.webapp.business.enums;


public enum ErrorCodes {

    INPUT_URL_INVALID(1001, "Input url is invalid"), JSOUP_PARSING_ERROR(1002, "The URL is not reachable");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
