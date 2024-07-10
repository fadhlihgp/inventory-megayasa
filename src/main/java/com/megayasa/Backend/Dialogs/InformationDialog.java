package com.megayasa.Backend.Dialogs;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class InformationDialog {
    private static final Icon successIcon = new ImageIcon(Objects.requireNonNull(InformationDialog.class.getResource("/icon/success.png")));
    private static final Icon deleteIcon = new ImageIcon(Objects.requireNonNull(InformationDialog.class.getResource("/icon/delete.png")));
    private static final Font customFont = new Font("Arial", Font.PLAIN, 14);

    static {
        UIManager.put("OptionPane.messageFont", customFont);
    }
    private static void showInformation(String message, Icon icon) {
        JOptionPane.showMessageDialog(null, message, "Berhasil", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    public static void successMessage(String message) {
        showInformation(message, successIcon);
    }
    public static void deleteSuccess(String message) {
        showInformation(message, deleteIcon);
    }
}
