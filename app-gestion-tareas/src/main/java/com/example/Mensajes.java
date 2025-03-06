package com.example;

import javax.swing.JOptionPane;

public class Mensajes {
    // Método para mostrar un mensaje de información
    public static void showInfoMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para mostrar un mensaje de advertencia
    public static void showWarningMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    // Método para mostrar un mensaje de error
    public static void showErrorMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.ERROR_MESSAGE);
    }

    // Método para mostrar un mensaje de confirmación
    public static int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
    }

    // Método para mostrar una entrada de texto
    public static String showInputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }
}