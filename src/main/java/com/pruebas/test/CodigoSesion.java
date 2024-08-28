package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CodigoSesion  extends Base {

    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");

    private By botonCodigoSesion= By.id("copyButton");

    private By getBotonCodigoSesion=By.className("iconChange");







    public CodigoSesion(WebDriver driver) {super(driver);}

    public void ejecutarCodigoSesion(){



        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botonCodigoSesion,120);
        click(this.botonCodigoSesion);
        esperaEspecifica(2000);
        waitForItem(getBotonCodigoSesion,120);
        click(this.getBotonCodigoSesion);







    }
}



