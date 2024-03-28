package com.megayasa.Backend.Exceptions;

import javax.swing.*;
import java.util.Objects;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
        Icon notFoundIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/no-results.png")));
        JOptionPane.showMessageDialog(null, message, "Tidak Ditemukan", JOptionPane.ERROR_MESSAGE, notFoundIcon);
        throw new RuntimeException(message);
    }
}
