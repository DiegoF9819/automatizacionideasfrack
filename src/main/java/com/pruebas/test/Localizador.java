package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Localizador extends Base {

    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");

    private By botonLoc= By.id("fieldLOCQuick");

    private By getBotonLoc=By.className("button");

    private By botonBuscar=By.className("Buscar");







    public Localizador(WebDriver driver) {super(driver);}

    public void ejecutarLocalizador(){



        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botonLoc,120);
        click(this.botonLoc);
        esperaEspecifica(2000);
        waitForItem(getBotonLoc,120);
        click(this.getBotonLoc);
        escribir("AADOIWJ",this.getBotonLoc);
        waitForItem(this.botonBuscar,60);
        click(this.botonBuscar);






    }
}


