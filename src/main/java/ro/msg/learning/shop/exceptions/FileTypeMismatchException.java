package ro.msg.learning.shop.exceptions;

import lombok.Data;

@Data
public class FileTypeMismatchException extends RuntimeException {

    private String details;

    public FileTypeMismatchException(String message, String details) {
        super(message);
        this.details = details;
    }
}