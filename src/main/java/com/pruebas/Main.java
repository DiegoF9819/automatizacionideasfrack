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
    static Vuelos vuelos;
    static Hoteles hoteles;
    static Autos autos;

    static Asistencia Asistencia ;
    static Offline offline;

    static OtrosServicios otrosServicios;
    static Presupuesto presupuesto;

    static  CambiarContrasena CambiarContrasena;

    static gestion gestion;

    static CambiarAgencia cambiarAgencia;

    static CotizacionesMultibles cotizacionesMultibles;

    static ListaCotizaciones listaCotizaciones;

    static Reservas reservas;

    static CambiarCliente cambiarCliente;

    static CodigoSesion codigoSesion;

    static Mfa mfa;

    static CerrarSesion cerrarSesion;
    static Localizador localizador;






    public static void main (String[] args){
        menuTest();
    }



    public static void menuTest(){
        Scanner scanner = new Scanner(System.in);
        String codSeg = null;
        int option;
        do{
            if (codSeg != null){
                scanner.nextLine();
            }
            System.out.print("Ingrese el código de seguridad: ");
            codSeg = scanner.nextLine();
            System.out.println("////Menú principal////");
            System.out.println("1) Vuelos");
            System.out.println("2) Hotel");
            System.out.println("3) Autos");
            System.out.println("4) Asistencia");
            System.out.println("5) Offline");
            System.out.println("6) OtrosServicios ");
            System.out.println("7) presupuesto");
            System.out.println("8) CambioContrasena");
            System.out.println("9) gestion");
            System.out.println("10) CambiarAgencia");
            System.out.println("11) Cotizaciones Multiple");
            System.out.println("12) ListaCotizaciones");
            System.out.println("13) Reservas");
            System.out.println("14) Cambiar Cliente");
            System.out.println("15) Codigo Sesion");
            System.out.println("16) Mfa ");
            System.out.println("17) Cerrar Sesion");
            System.out.println("18) Localizador");
            System.out.println("0) Salir");
            System.out.print("Ingrese una opción: ");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.println("/////////////////////");
                    System.out.println("Elija tipo de test");
                    System.out.println("1. Ida y vuelta");
                    System.out.println("2. Solo ida");
                    System.out.println("3. Multiples trayectos");
                    System.out.print("Ingrese una opción: ");
                    int optionVuelo = scanner.nextInt();
                    while(true) {
                        if (optionVuelo == 1 || optionVuelo ==2 || optionVuelo ==3) {
                            break; // Rompe el bucle si se cumple la condición
                        }else{
                            System.out.println("Elije una opción valida");
                        }
                    }
                    Main.startTime = System.currentTimeMillis();
                    vuelos = new Vuelos(driver);
                    driver = vuelos.cromeDriverConection();
                    vuelos.visit("https://pre-prod.kontroltravel.com/");
                    vuelos.selectAndinsertData(optionVuelo,codSeg);
                    break;
                case 2:
                    hoteles = new Hoteles(driver);
                    driver = hoteles.cromeDriverConection();
                    hoteles.visit("https://pre-prod.kontroltravel.com/");
                    hoteles.selectAndinsertData(codSeg);
                    break;

                case 3:
                    autos = new Autos(driver);
                    driver = autos.cromeDriverConection();
                    autos.visit("https://pre-prod.kontroltravel.com/");
                    autos.selectAndinsertData(codSeg);
                    break;

                case 4:
                    Asistencia = new Asistencia(driver);
                    driver = Asistencia.cromeDriverConection();
                    Asistencia.visit("https://ideas.kontroltravel.com/default.aspx");
                    Asistencia.selectAndinsertData(codSeg);
                    break;

                case 5:
                    offline= new Offline(driver);
                    driver= offline.cromeDriverConection();
                    offline.visit("https://ideas.kontroltravel.com/");
                    offline.selectAndinsertData();
                    break;

                case 6:
                    otrosServicios= new OtrosServicios(driver);
                    driver= otrosServicios.cromeDriverConection();
                    otrosServicios.visit("https://pre-prod.kontroltravel.com/");
                    otrosServicios.ejecutarOtrosServicios();
                    break;


                case 7:
                    presupuesto = new Presupuesto(driver);
                    driver = presupuesto.cromeDriverConection();
                    presupuesto.visit("https://pre-prod.kontroltravel.com/");
                    presupuesto.ejecutarPresupuesto();
                    break;


                case 8:
                    CambiarContrasena  = new CambiarContrasena(driver);
                    driver = CambiarContrasena.cromeDriverConection();
                    CambiarContrasena.visit("https://ideas.kontroltravel.com/");
                    CambiarContrasena.ejecutarCambioContrasena();
                    break;



                case 9:
                    gestion= new gestion(driver);
                    driver=gestion.cromeDriverConection();
                    gestion.visit("https://pre-prod.kontroltravel.com/");
                    gestion.ejecutargestion();
                    break;

                case 10:
                    cambiarAgencia= new CambiarAgencia(driver);
                    driver=cambiarAgencia.cromeDriverConection();
                    cambiarAgencia.visit("https://pre-prod.kontroltravel.com/");
                    cambiarAgencia.ejecutarCambiarAgencia();
                    break;

                case 11:
                    cotizacionesMultibles= new CotizacionesMultibles(driver);
                    driver=cotizacionesMultibles.cromeDriverConection();
                    cotizacionesMultibles.visit("https://pre-prod.kontroltravel.com/");
                    cotizacionesMultibles.ejecutarCotizacionesMultiples();
                    break;

                case 12:
                    listaCotizaciones= new ListaCotizaciones(driver);
                    driver=listaCotizaciones.cromeDriverConection();
                    listaCotizaciones.visit("https://pre-prod.kontroltravel.com/");
                    listaCotizaciones.ejecutarListaCotizaciones();
                    break;

                case 13:
                    reservas= new Reservas(driver);
                    driver=reservas.cromeDriverConection();
                    reservas.visit("https://ideas.kontroltravel.com/");
                    reservas.ejecutarReservas();
                    break;

                case 14:
                    cambiarCliente=new CambiarCliente(driver);
                    driver=cambiarCliente.cromeDriverConection();
                    cambiarCliente.visit("https://pre-prod.kontroltravel.com/");
                    cambiarCliente.ejecutarCambiarCliente();
                    break;

                case 15:
                    codigoSesion=new CodigoSesion(driver);
                    driver=codigoSesion.cromeDriverConection();
                    codigoSesion.visit("https://pre-prod.kontroltravel.com/");
                    codigoSesion.ejecutarCodigoSesion();
                    break;

                case 16:
                    mfa=new Mfa(driver);
                    driver=mfa.cromeDriverConection();
                    mfa.visit("https://pre-prod.kontroltravel.com/");
                    mfa.ejecutarMfa();
                    break;

                case 17:
                    cerrarSesion=new CerrarSesion(driver);
                    driver=cerrarSesion.cromeDriverConection();
                    cerrarSesion.visit("https://pre-prod.kontroltravel.com/");
                    cerrarSesion.ejecutarCerrarSesion();
                    break;

                case 18:
                    localizador=new Localizador(driver);
                    driver=localizador.cromeDriverConection();
                    localizador.visit("https://pre-prod.kontroltravel.com/");
                    localizador.ejecutarLocalizador();
                    break;






            }
            CountTime.printTotalExecutionTime(Main.startTime);
        }while(option != 0);


    }

}
