package com.pruebas;

import java.util.Scanner;
import com.pruebas.utils.CountTime;
import org.openqa.selenium.WebDriver;
import com.pruebas.test.*;

public class Main {
    static long startTime;
    static WebDriver driver;
    static Inicio inicio;
    static Tablero tablero;
    static Programas programas;
    static RecursosDigitales recursosDigitales;
    static Caracterizacion caracterizacion;
    static HistorialAcademico historialAcademico;
    static MisCertificados misCertificados;
    static Renovacion renovacion;
    static MiFinanciacion miFinanciacion;
    static FeriaEmprendimiento feriaEmprendimiento;
    static MiCarnet miCarnet;
    static Pqrs pqrs;

    public static void main(String[] args) {
        System.out.println("Iniciando el programa...");
        startTime = System.currentTimeMillis(); // Inicializa el tiempo
        try {
            menuTest();
        } catch (Exception e) {
            System.out.println("Error en la ejecución: " + e.getMessage());
        }
    }

    public static void menuTest() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            // Mostrar menú
            System.out.println("1)   Inicio");
            System.out.println("2)   Tablero");
            System.out.println("3)   Programas");
            System.out.println("4)   Recursos Digitales");
            System.out.println("5)   Caracterización");
            System.out.println("6)   Historial Academico");
            System.out.println("7)   Mis Certificados");
            System.out.println("8)   Renovacion");
            System.out.println("9)   Mi Financiacion");
            System.out.println("10)  Feria Emprendimiento");
            System.out.println("11)  Mi Carnet");
            System.out.println("12)  PQRS");
            System.out.println("0) Salir");

            System.out.print("Ingrese una opción: ");
            option = scanner.nextInt();

            // Validación de la opción ingresada
            if (option < 0 || option > 12) {
                System.out.println("Opción no válida, por favor intente de nuevo.");
                continue; // Regresa al inicio del bucle
            }

            switch(option) {
                case 1:
                    try {
                        inicio = new Inicio(driver);
                        driver = inicio.cromeDriverConection();
                        inicio.visit("https://www.ciaf.digital");
                        inicio.ejecutarLista();
                        System.out.println("Acción de 'Inicio' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Inicio': " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        tablero = new Tablero(driver);
                        driver = tablero.cromeDriverConection();
                        tablero.visit("https://www.ciaf.digital");
                        tablero.ejecutarLista();
                        System.out.println("Acción de 'Tablero' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Tablero': " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        programas = new Programas(driver);
                        driver = programas.cromeDriverConection();
                        programas.visit("https://www.ciaf.digital");
                        programas.ejecutarLista();
                        System.out.println("Acción de 'Programas' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Programas': " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        recursosDigitales = new RecursosDigitales(driver);
                        driver = recursosDigitales.cromeDriverConection();
                        recursosDigitales.visit("https://www.ciaf.digital");
                        recursosDigitales.ejecutarLista();
                        System.out.println("Acción de 'Recursos Digitales' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Recursos Digitales': " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        caracterizacion = new Caracterizacion(driver);
                        driver = caracterizacion.cromeDriverConection();
                        caracterizacion.visit("https://www.ciaf.digital");
                        caracterizacion.ejecutarOtrosServicios();
                        System.out.println("Acción de 'Caracterización' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Caracterización': " + e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        historialAcademico = new HistorialAcademico(driver);
                        driver = historialAcademico.cromeDriverConection();
                        historialAcademico.visit("https://www.ciaf.digital");
                        historialAcademico.ejecutarLista();
                        System.out.println("Acción de 'Historial Academico' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Historial Academico': " + e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        misCertificados = new MisCertificados(driver);
                        driver = misCertificados.cromeDriverConection();
                        misCertificados.visit("https://www.ciaf.digital");
                        misCertificados.ejecutarLista();
                        System.out.println("Acción de 'Mis Certificados' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Mis Certificados': " + e.getMessage());
                    }
                    break;

                case 8:
                    try {
                        renovacion = new Renovacion(driver);
                        driver = renovacion.cromeDriverConection();
                        renovacion.visit("https://www.ciaf.digital");
                        renovacion.ejecutarLista();
                        System.out.println("Acción de 'Renovación' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Renovación': " + e.getMessage());
                    }
                    break;

                case 9:
                    try {
                        miFinanciacion = new MiFinanciacion(driver);
                        driver = miFinanciacion.cromeDriverConection();
                        miFinanciacion.visit("https://www.ciaf.digital");
                        miFinanciacion.ejecutarLista();
                        System.out.println("Acción de 'Mi Financiación' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Mi Financiación': " + e.getMessage());
                    }
                    break;

                case 10:
                    try {
                        feriaEmprendimiento = new FeriaEmprendimiento(driver);
                        driver = feriaEmprendimiento.cromeDriverConection();
                        feriaEmprendimiento.visit("https://www.ciaf.digital");
                        feriaEmprendimiento.ejecutarLista();
                        System.out.println("Acción de 'Feria Emprendimiento' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Feria Emprendimiento': " + e.getMessage());
                    }
                    break;

                case 11:
                    try {
                        miCarnet = new MiCarnet(driver);
                        driver = miCarnet.cromeDriverConection();
                        miCarnet.visit("https://www.ciaf.digital");
                        miCarnet.ejecutarListaCotizaciones();
                        System.out.println("Acción de 'Mi Carnet' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'Mi Carnet': " + e.getMessage());
                    }
                    break;

                case 12:
                    try {
                        pqrs = new Pqrs(driver);
                        driver = pqrs.cromeDriverConection();
                        pqrs.visit("https://www.ciaf.digital");
                        pqrs.ejecutarLista();
                        System.out.println("Acción de 'PQRS' ejecutada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en la opción 'PQRS': " + e.getMessage());
                    }
                    break;
            }

            CountTime.printTotalExecutionTime(Main.startTime);
        } while(option != 0);
    }
}
