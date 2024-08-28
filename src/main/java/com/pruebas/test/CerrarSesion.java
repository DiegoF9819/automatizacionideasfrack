package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CerrarSesion extends Base {

    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");

    private By botonCerrarSesion= By.id("btnLogout");
    private By getBotonCerrarSesion=By.className("logout");






    public CerrarSesion(WebDriver driver) {super(driver);}

    public void ejecutarCerrarSesion(){



        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botonCerrarSesion,120);
        click(this.botonCerrarSesion);
        esperaEspecifica(2000);
        waitForItem(getBotonCerrarSesion,120);
        click(this.getBotonCerrarSesion);





    }
}



