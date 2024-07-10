package com.megayasa.Backend.Dialogs;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ConfirmationDialog {
    private static final ImageIcon deleteIcon = new ImageIcon(Objects.requireNonNull(ConfirmationDialog.class.getResource("/icon/delete2.png")));
    private static final ImageIcon saveIcon = new ImageIcon(Objects.requireNonNull(ConfirmationDialog.class.getResource("/icon/save.png")));
    private static final ImageIcon otherIcon = new ImageIcon(Objects.requireNonNull(ConfirmationDialog.class.getResource("/icon/question.png")));
    private static final Font customFont = new Font("Arial", Font.PLAIN, 14);

    static {
        UIManager.put("OptionPane.messageFont", customFont);
    }

    private static int showConfirmation(String message, String title, Icon icon) {
        return JOptionPane.showOptionDialog(
                null,
                message,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,
                new Object[]{"Ya", "Tidak"},
                "Ya"
        );
    }

    public static int deleteConfirmation(String message, String title) {
        return showConfirmation(message, title, deleteIcon);
    }

    public static int saveConfirmation(String message, String title) {
        return showConfirmation(message, title, saveIcon);
    }

    public static int otherConfirmation(String message, String title) {
        return showConfirmation(message, title, otherIcon);
    }

}
