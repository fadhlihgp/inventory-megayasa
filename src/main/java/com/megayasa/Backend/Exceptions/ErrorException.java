package com.megayasa.Backend.Exceptions;

import javax.swing.*;
import java.util.Objects;

public class ErrorException extends RuntimeException{
    public ErrorException() {
    }
    public ErrorException(String message) {
        super(message);
        Icon errorIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/error.png")));
        JOptionPane.showMessageDialog(null, message, "Error App", JOptionPane.ERROR_MESSAGE, errorIcon);
        throw new RuntimeException(message);
    }
}
