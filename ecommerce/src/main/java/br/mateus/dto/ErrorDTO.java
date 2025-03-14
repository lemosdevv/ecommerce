package br.mateus.dto;

public class ErrorDTO {
    private String message;
    private int status;

    public ErrorDTO(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
