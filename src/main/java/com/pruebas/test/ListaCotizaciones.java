package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaCotizaciones extends Base {


    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");

    private By botonreservas= By.id("btnListTripNotes");







    public ListaCotizaciones(WebDriver driver) {super(driver);}

    public void ejecutarListaCotizaciones(){



        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botonreservas,120);
        click(this.botonreservas);





    }
}


