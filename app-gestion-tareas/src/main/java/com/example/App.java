package com.example;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Frame ventana = new Frame();
                ventana.setVisible(true);
            }
        });
    }
}
