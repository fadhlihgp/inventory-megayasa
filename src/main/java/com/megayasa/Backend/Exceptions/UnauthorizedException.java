package com.megayasa.Backend.Exceptions;

import javax.swing.*;
import java.util.Objects;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);
        ImageIcon unauthorizedIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/unauthorized.png")));
        JOptionPane.showMessageDialog(null, message, "Kesalahan Akses", JOptionPane.ERROR_MESSAGE, unauthorizedIcon);
        throw new RuntimeException(message);
//        System.out.println(message);
    }
}
