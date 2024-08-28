package com.pruebas.utils;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CountTime {
    public static void printTotalExecutionTime(long startTime) {
        long endTime = System.currentTimeMillis(); // Obtener el tiempo de finalización
        long totalTime = endTime - startTime; // Calcular el tiempo total de ejecución en milisegundos

        // Convertir el tiempo total a segundos y formatearlo en HH:mm:ss
        double segundos = totalTime / 1000.0;
        Duration duracion = Duration.ofSeconds(Math.round(segundos));
        LocalTime tiempo = LocalTime.MIDNIGHT.plus(duracion);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String tiempoFormateado = tiempo.format(formatter);

        // Imprimir el tiempo total de ejecución
        System.out.println("Tiempo total de ejecución: " + tiempoFormateado);
    }
}
