package com.example;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame {

    private CardLayout cardLayout;

    public Frame() {
        this.setTitle("Gestión de Tareas");
        this.setSize(500, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        this.getContentPane().setLayout(cardLayout);

        // Establecer el ícono de la ventana
        ImageIcon imagen = new ImageIcon("C:\\App_Gestion_Tareas\\icono.png");
        setIconImage(imagen.getImage());

        this.setResizable(false);

        // Agregar el Panel principal
        Panel panel = new Panel(this);
        this.getContentPane().add(panel, "PanelPrincipal");

        this.setVisible(true);
    }
}