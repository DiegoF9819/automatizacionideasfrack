package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CambiarCliente extends Base {

    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");

    private By botonCambiarCliente= By.id("btnAlterClient");


    public CambiarCliente(WebDriver driver) {super(driver);}

    public void ejecutarCambiarCliente(){



        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botonCambiarCliente,120);
        click(this.botonCambiarCliente);





    }
}


