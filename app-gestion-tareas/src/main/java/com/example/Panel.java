package com.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel extends JPanel {

    private JLabel titulo;
    private JLabel agregar;
    private JTextField texto1;
    private JTextField texto2;
    private JButton botonGuardar;
    private JLabel lista;
    private JButton botonBuscar;
    private JButton botonEliminar;
    private JButton botonTareaCompletada;
    private JTextArea textArea;

    public Panel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(223, 253, 222));
        GridBagConstraints constraints = new GridBagConstraints();

        titulo = new JLabel("GESTIÓN DE TAREAS");
        titulo.setFont(new Font("Shiny Flakes", Font.BOLD, 50));
        titulo.setForeground(Color.decode("#707070"));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(20, 0, 20, 0);
        add(titulo, constraints);

        agregar = new JLabel("Agregar tarea");
        agregar.setFont(new Font("Shiny Flakes", Font.BOLD, 35));
        agregar.setForeground(Color.decode("#707070"));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 20, 10, 0);
        add(agregar, constraints);

        texto1 = new JTextField(50);
        texto1.setBorder(BorderFactory.createLineBorder(new Color(0x70, 0x70, 0x70), 2));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(0, 20, 10, 0);
        add(texto1, constraints);

        botonGuardar = new JButton("Guardar tarea");
        botonGuardar.setBackground(Color.WHITE);
        botonGuardar.setFont(new Font("Shiny Flakes", Font.BOLD, 25));
        botonGuardar.setForeground(Color.decode("#707070"));
        botonGuardar.setBorder(BorderFactory.createLineBorder(Color.decode("#707070"), 2));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 10, 0);
        add(botonGuardar, constraints);

        lista = new JLabel("Lista de tareas");
        lista.setFont(new Font("Shiny Flakes", Font.BOLD, 35));
        lista.setForeground(Color.decode("#707070"));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(20, 20, 10, 0);
        add(lista, constraints);

        texto2 = new JTextField(20);
        texto2.setBorder(BorderFactory.createLineBorder(new Color(0x70, 0x70, 0x70), 2));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL; // Expande horizontalmente
        constraints.weightx = 1.0; // Asigna espacio adicional horizontal
        constraints.insets = new Insets(0, 20, 10, 0);
        add(texto2, constraints);

        botonBuscar = new JButton("Buscar tarea");
        botonBuscar.setBackground(Color.WHITE);
        botonBuscar.setFont(new Font("Shiny Flakes", Font.BOLD, 25));
        botonBuscar.setForeground(Color.decode("#707070"));
        botonBuscar.setBorder(BorderFactory.createLineBorder(Color.decode("#707070"), 2));
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 10, 0);
        add(botonBuscar, constraints);

        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createLineBorder(new Color(0x70, 0x70, 0x70), 2));
        JScrollPane scrollPane = new JScrollPane(textArea);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(0, 20, 20, 20);
        add(scrollPane, constraints);

        botonTareaCompletada = new JButton("Tarea completada");
        botonTareaCompletada.setBackground(Color.WHITE);
        botonTareaCompletada.setFont(new Font("Shiny Flakes", Font.BOLD, 25));
        botonTareaCompletada.setForeground(Color.decode("#707070"));
        botonTareaCompletada.setBorder(BorderFactory.createLineBorder(Color.decode("#707070"), 2));
        botonTareaCompletada.setPreferredSize(new Dimension(200, 50)); // Tamaño preferido
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.weightx = 0; // No expandir horizontalmente
        constraints.weighty = 0; // No expandir verticalmente
        constraints.fill = GridBagConstraints.NONE; // No llenar espacio extra
        constraints.insets = new Insets(0, 20, 20, 0);
        add(botonTareaCompletada, constraints);

        botonEliminar = new JButton("Eliminar tarea");
        botonEliminar.setBackground(Color.WHITE);
        botonEliminar.setFont(new Font("Shiny Flakes", Font.BOLD, 25));
        botonEliminar.setForeground(Color.decode("#707070"));
        botonEliminar.setBorder(BorderFactory.createLineBorder(Color.decode("#707070"), 2));
        botonEliminar.setPreferredSize(new Dimension(200, 50)); // Tamaño preferido
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 20, 20, 0);
        add(botonEliminar, constraints);
    }
}