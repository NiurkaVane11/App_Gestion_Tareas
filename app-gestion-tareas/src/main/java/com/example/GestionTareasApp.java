package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestionTareasApp {

    // Atributos
    private List<String> tareas;

    // Constructor
    public GestionTareasApp(List<String> tareas) {
        this.tareas = tareas;
    }

    // Métodos get y set
    public List<String> getTareas() {
        return tareas;
    }

    public void setTareas(List<String> tareas) {
        this.tareas = tareas;
    }

    // Métodos
    public void agregarTarea(String tarea) {
        this.tareas.add(tarea);
    }

    public void eliminarTarea(String tarea) {
        this.tareas.remove(tarea);
    }

    public void mostrarTareas() {
        for (String tarea : tareas) {
            System.out.println(tarea);
        }
    }

    // Método para filtrar tareas usando regex
    public List<String> buscarTareasRegex(String textoBusqueda) {

        List<String> tareasFiltradas = new ArrayList<>();

        Pattern pattern = Pattern.compile(textoBusqueda, Pattern.CASE_INSENSITIVE);

        for (String tarea : tareas) {

            Matcher matcher = pattern.matcher(tarea);

            if (matcher.find()) {
                tareasFiltradas.add(tarea);
            }
        }

        return tareasFiltradas;
    }

}
