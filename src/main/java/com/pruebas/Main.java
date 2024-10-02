package com.pruebas;


import java.util.Scanner;

import com.pruebas.utils.CountTime;
import org.openqa.selenium.WebDriver;
import com.pruebas.test.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static long startTime;
    static WebDriver driver;
    static Inicio inicio;
    static Tablero tablero;

    static Programas programas ;
    static RecursosDigitales recursosDigitales;

    static Caracterizacion caracterizacion;
    static HistorialAcademico historialAcademico;

    static  MisCertificados misCertificados;

    static Renovacion renovacion;

    static MiFinanciacion miFinanciacion;

    static FeriaEmprendimiento feriaEmprendimiento;

    static MiCarnet miCarnet;
    static Pqrs pqrs;



    public static void main (String[] args){
        menuTest();
    }

    public static void menuTest(){
        Scanner scanner = new Scanner(System.in);
        int option;
        do{

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

            switch(option){


                case 1:
                    inicio = new Inicio(driver);
                    driver = inicio.cromeDriverConection();
                    inicio.visit("https://www.ciaf.digital");
                    inicio.ejecutarLista();
                    break;

                case 2:
                    tablero = new Tablero(driver);
                    driver = tablero.cromeDriverConection();
                    tablero.visit("https://www.ciaf.digital");
                    tablero.ejecutarLista();
                    break;

                case 3:
                    programas = new Programas(driver);
                    driver = programas.cromeDriverConection();
                    programas.visit("https://www.ciaf.digital");
                    programas.ejecutarLista();
                    break;

                case 4:
                    recursosDigitales= new RecursosDigitales(driver);
                    driver= recursosDigitales.cromeDriverConection();
                    recursosDigitales.visit("https://www.ciaf.digital");
                    recursosDigitales.ejecutarLista();
                    break;

                case 5:
                    caracterizacion= new Caracterizacion(driver);
                    driver= caracterizacion.cromeDriverConection();
                    caracterizacion.visit("https://www.ciaf.digital");
                    caracterizacion.ejecutarOtrosServicios();
                    break;


                case 6:
                    historialAcademico = new HistorialAcademico(driver);
                    driver = historialAcademico.cromeDriverConection();
                    historialAcademico.visit("https://www.ciaf.digital");
                    historialAcademico.ejecutarLista();
                    break;


                case 7:
                    misCertificados = new MisCertificados(driver);
                    driver = misCertificados.cromeDriverConection();
                    misCertificados.visit("https://www.ciaf.digital");
                    misCertificados.ejecutarLista();
                    break;



                case 8:
                    renovacion= new Renovacion(driver);
                    driver=renovacion.cromeDriverConection();
                    renovacion.visit("https://www.ciaf.digital");
                    renovacion.ejecutarLista();
                    break;

                case 9:
                    miFinanciacion= new MiFinanciacion(driver);
                    driver=miFinanciacion.cromeDriverConection();
                    miFinanciacion.visit("https://www.ciaf.digital");
                    miFinanciacion.ejecutarLista();
                    break;

                case 10:
                    feriaEmprendimiento= new FeriaEmprendimiento(driver);
                    driver=feriaEmprendimiento.cromeDriverConection();
                    feriaEmprendimiento.visit("https://www.ciaf.digital");
                    feriaEmprendimiento.ejecutarLista();
                    break;

                case 11:
                    miCarnet= new MiCarnet(driver);
                    driver=miCarnet.cromeDriverConection();
                    miCarnet.visit("https://www.ciaf.digital");
                    miCarnet.ejecutarListaCotizaciones();
                    break;

                case 12:
                    pqrs= new Pqrs(driver);
                    driver=pqrs.cromeDriverConection();
                    pqrs.visit("https://www.ciaf.digital");
                    pqrs.ejecutarLista();
                    break;

            }
            CountTime.printTotalExecutionTime(Main.startTime);
        }while(option != 0);


    }

}
