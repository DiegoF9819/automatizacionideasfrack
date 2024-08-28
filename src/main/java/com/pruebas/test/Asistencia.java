
package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Asistencia extends Base {

    //Selectores login
    private By username = By.id("userName");

    private By buton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");



    //Selectores Asistencia
    private By icoInsurances = By.className("icoInsurances");
    private By inputpaisorigen = By.id("origenPaisTextToDescripcion");

    private By selectinputpaisorigen = By.className("ui-menu-item");

    private By inputzonadestino = By.id("seguro_destino_idsearchBox_seguros_div");


    private By selectinputzonadestino = By.className("destinosTextToDescripcionsearchBox_seguros_div");



    private By fechaorigen = By.id("seguro_checkin_datesearchBox_seguros_div");

    private By fechallegada = By.id("seguro_checkout_datesearchBox_seguros_div");

    private By pasajeros = By.id("");

    private By edad = By.id("");

    private By primeraedad= By.className("");
    //CheckBoxes

    //Boton Buscar
    private By btoDetalle = By.id("btnVistaDetalle");
    private By buscarButton = By.id("searchButton_searchBoxsegurosDiv");

    private By option1 = By.className("ui-menu-item");

    private By Labelshortlabel= By. id ("listSources_searchBox_seguros_div");


    //Seleccionadores Reserva
    private By solicitarcotizacion = By.xpath("(//a[@id='btnSearch_searchBox_seguros_div']//span");

    public Asistencia(WebDriver driver) {
        super(driver);
    }

    public void selectAndinsertData(String codSeg){
        try {
            Login login = new Login(this.getDriver());
            login.initLogin(codSeg);
            //Login
            escribir("fer.salazar",this.username);
            escribir("1234Godie1987*",this.password);
            click(this.loginButton);

            //Elegir y rellenar opción Asistencia
            waitForItem(this.icoInsurances,120);
            click(this.icoInsurances);
            esperaEspecifica(2000);
            escribir("Colombia",this.inputpaisorigen);
            waitForItem(this.selectinputpaisorigen,120);
            click(this.selectinputpaisorigen);
            waitForItem(this.selectinputzonadestino,120);
            selectOption(1,this.inputzonadestino);
            click(this.selectinputzonadestino);
            selectOption(1,this.selectinputzonadestino);
            click(option1);
            esperaEspecifica(1000);
            borrar(this.fechaorigen);
            borrar(this.fechallegada);
            escribir("01-04-2024",this.fechaorigen);
            selectOption(35,this.fechaorigen);
            escribir("07-04-2024",this.fechallegada);
            selectOption(36,this.fechallegada);
            waitForItem(this.pasajeros,120);
            click(this.edad);
            escribir("25",this.primeraedad);
            click(this.Labelshortlabel);
            click(this.buscarButton);



            System.out.println("////Test finalizado////");
        }catch (ArithmeticException e){
            System.out.println("////Error en la ejecución del test////");
        }


    }

}
