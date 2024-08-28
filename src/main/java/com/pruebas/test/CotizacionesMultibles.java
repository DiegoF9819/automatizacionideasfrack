package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CotizacionesMultibles extends Base {

private By username = By.id("userName");
private By boton = By.id("");
private By password = By.id("password");
private By loginButton = By.id("btnLoginBoxAccept");

private By botonCotizacionesMultiples= By.id("btnListQuoteMultiple");

public CotizacionesMultibles(WebDriver driver) {super(driver);}

public void ejecutarCotizacionesMultiples(){



    //Login
    escribir("fer.salazar",this.username);
    escribir("1234Godie1987*",this.password);
    click(this.loginButton);

    waitForItem(botonCotizacionesMultiples,120);
    click(this.botonCotizacionesMultiples);

}



}

