package com.megayasa.Backend.Exceptions;

import javax.swing.*;
import java.util.Objects;

public class WarningException extends RuntimeException{
    public WarningException() {
    }

    public WarningException(String message) {
        super(message);
        Icon warningIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/warning.png")));
        JOptionPane.showMessageDialog(null, message, "Perhatian", JOptionPane.ERROR_MESSAGE, warningIcon);
        throw new RuntimeException(message);
    }
}
