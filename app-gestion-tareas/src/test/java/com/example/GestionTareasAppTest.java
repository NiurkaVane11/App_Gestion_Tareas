package com.example;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestionTareasAppTest {

    private GestionTareasApp gestion;

    @BeforeEach
    void setUp() {
        List<String> tareas = new ArrayList<>();
        gestion = new GestionTareasApp(tareas);
    }

    @Test
    void testAgregarTarea() {
        gestion.agregarTarea("Comprar leche");
        assertEquals(1, gestion.getTareas().size());
        assertTrue(gestion.getTareas().contains("Comprar leche"));
    }

    @Test
    void testEliminarTarea() {
        gestion.agregarTarea("Estudiar Java");
        gestion.eliminarTarea("Estudiar Java");
        assertFalse(gestion.getTareas().contains("Estudiar Java"));
    }

    @Test
    void testBuscarTareasRegex() {
        gestion.agregarTarea("Hacer ejercicio");
        gestion.agregarTarea("Comprar pan");
        gestion.agregarTarea("Hacer tareas de matemáticas");

        List<String> resultados = gestion.buscarTareasRegex("Hacer");
        assertEquals(2, resultados.size());
        assertTrue(resultados.contains("Hacer ejercicio"));
        assertTrue(resultados.contains("Hacer tareas de matemáticas"));
    }
}
