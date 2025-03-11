package com.example;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mensajes {
    // Método para mostrar un mensaje de información
    public static void showInfoMessage(JFrame parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para mostrar un mensaje de advertencia
    public static void showWarningMessage(JFrame parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
    }

    // Método para mostrar un mensaje de error
    public static void showErrorMessage(JFrame parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }

    // Método para mostrar un mensaje de confirmación
    public static int showConfirmDialog(JFrame parent, String message, String title) {
        return JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION);
    }

    // Método para mostrar una entrada de texto
    public static String showInputDialog(JFrame parent, String message, String title) {
        return JOptionPane.showInputDialog(parent, message, title, JOptionPane.PLAIN_MESSAGE);
    }
}
