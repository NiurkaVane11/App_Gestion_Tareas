package com.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    private JScrollPane scrollPane;
    private JPanel panelLista;
    private GestionTareasApp gesTareas; // Instancia de GestionTareasApp
    private JPanel tareaSeleccionada; // Panel de la tarea seleccionada
    private Set<String> tareasCompletadas; // Lista de tareas completadas

    public Panel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(223, 253, 222));
        GridBagConstraints constraints = new GridBagConstraints();

        gesTareas = new GestionTareasApp(new ArrayList<>()); // Inicializar la instancia de GestionTareasApp
        tareasCompletadas = new HashSet<>(); // Inicializar la lista de tareas completadas

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

        configurarBoton(botonGuardar);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 10, 0);
        add(botonGuardar, constraints);

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tarea = texto1.getText();
                    if (tarea.isEmpty()) {
                        Mensajes.showWarningMessage("Escriba la tarea", "Advertencia");
                    } else {
                        gesTareas.agregarTarea(tarea);
                        texto1.setText("");
                        actualizarLista();
                    }
                } catch (Exception ex) {
                    Mensajes.showErrorMessage("Ha ocurrido un error: " + ex.getMessage(), "Error");
                }
            }
        });

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
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(0, 20, 10, 0);
        add(texto2, constraints);

        botonBuscar = new JButton("Buscar tarea");
        configurarBoton(botonBuscar);
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 10, 0);
        add(botonBuscar, constraints);

        panelLista = new JPanel();
        panelLista.setLayout(new GridBagLayout());
        panelLista.setBackground(Color.WHITE);
        panelLista.setBorder(BorderFactory.createLineBorder(Color.decode("#C6A170"), 2));
        scrollPane = new JScrollPane(panelLista);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        add(scrollPane, constraints);

        botonTareaCompletada = new JButton("Tarea completada");
        configurarBoton(botonTareaCompletada);
        botonTareaCompletada.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 20, 20, 0);
        add(botonTareaCompletada, constraints);

        botonTareaCompletada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tareaSeleccionada == null) {
                    Mensajes.showWarningMessage("Seleccione una tarea para marcar como completada", "Advertencia");
                    return; // Evita que el código continúe si no hay tarea seleccionada
                }

                try {
                    String tarea = ((JLabel) tareaSeleccionada.getComponent(1)).getText();
                    tareasCompletadas.add(tarea);
                    tareaSeleccionada.setBackground(Color.decode("#C6A170"));
                    tareaSeleccionada = null; // Resetea la tarea seleccionada para forzar una nueva selección
                } catch (Exception ex) {
                    Mensajes.showErrorMessage("Ha ocurrido un error: " + ex.getMessage(), "Error");
                }
            }
        });

        botonEliminar = new JButton("Eliminar tarea");
        configurarBoton(botonEliminar);
        botonEliminar.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 20, 20, 0);
        add(botonEliminar, constraints);

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tareaSeleccionada == null) {
                    Mensajes.showWarningMessage("Seleccione una tarea para eliminar", "Advertencia");
                    return; // Evita que el código continúe si no hay tarea seleccionada
                }

                try {
                    String tarea = ((JLabel) tareaSeleccionada.getComponent(1)).getText();
                    gesTareas.eliminarTarea(tarea);
                    tareasCompletadas.remove(tarea);
                    tareaSeleccionada = null; // Resetea la tarea seleccionada para forzar una nueva selección
                    actualizarLista();
                } catch (Exception ex) {
                    Mensajes.showErrorMessage("Ha ocurrido un error: " + ex.getMessage(), "Error");
                }
            }
        }); // Add this closing brace to complete the ActionListener

    } // Add this closing brace to complete the constructor

    private void actualizarLista() {
        panelLista.removeAll();
        panelLista.revalidate();
        panelLista.repaint();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        for (String tarea : gesTareas.getTareas()) {
            JPanel tareaPanel = new JPanel(new GridBagLayout());

            if (tareasCompletadas.contains(tarea)) {
                tareaPanel.setBackground(Color.decode("#C6A170"));
            } else {
                tareaPanel.setBackground(Color.WHITE);
            }

            JButton botonSeleccion = new JButton("\u25CF");
            configurarBotonSeleccion(botonSeleccion);
            botonSeleccion.setFont(new Font("Arial", Font.BOLD, 20));
            botonSeleccion.setBorder(BorderFactory.createEmptyBorder());
            botonSeleccion.setBackground(Color.WHITE);
            botonSeleccion.setForeground(Color.decode("#707070"));
            botonSeleccion.setFocusPainted(false);
            botonSeleccion.setPreferredSize(new Dimension(30, 30));

            botonSeleccion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tareaSeleccionada != null) {
                        String tareaAnterior = ((JLabel) tareaSeleccionada.getComponent(1)).getText();
                        if (!tareasCompletadas.contains(tareaAnterior)) {
                            tareaSeleccionada.setBackground(Color.WHITE);
                        }
                    }
                    tareaSeleccionada = tareaPanel;
                    tareaSeleccionada.setBackground(Color.LIGHT_GRAY);
                }
            });

            JLabel tareaLabel = new JLabel(tarea);
            tareaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            tareaLabel.setForeground(Color.decode("#707070"));

            GridBagConstraints gbcTarea = new GridBagConstraints();
            gbcTarea.gridx = 0;
            gbcTarea.gridy = 0;
            gbcTarea.anchor = GridBagConstraints.WEST;
            tareaPanel.add(botonSeleccion, gbcTarea);

            gbcTarea.gridx = 1;
            gbcTarea.insets = new Insets(0, 10, 0, 0);
            tareaPanel.add(tareaLabel, gbcTarea);

            panelLista.add(tareaPanel, gbc);
            gbc.gridy++;
        }

        panelLista.revalidate();
        panelLista.repaint();
    }

    private void configurarBoton(JButton boton) {
        boton.setBackground(Color.WHITE);
        boton.setFont(new Font("Shiny Flakes", Font.BOLD, 25)); // Cambiar a "Shiny Flakes"
        boton.setForeground(Color.decode("#707070"));
        boton.setBorder(BorderFactory.createLineBorder(Color.decode("#707070"), 2));
    }

    private void configurarBotonSeleccion(JButton boton) {
        boton.setFont(new Font("Shiny Flakes", Font.BOLD, 25)); // Cambiar a "Shiny Flakes"
        boton.setBorder(BorderFactory.createLineBorder(Color.decode("#707070"), 2, true));
        boton.setBackground(Color.WHITE);
        boton.setForeground(Color.decode("#707070"));
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(30, 30));
    }
}