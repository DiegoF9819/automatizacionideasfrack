package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Mfa extends Base {

    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");

    private By botonMfa= By.id("infoAuthMFA");

    private By getBotonMfa=By.className("iconChange");







    public Mfa(WebDriver driver) {super(driver);}

    public void ejecutarMfa(){



        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botonMfa,120);
        click(this.botonMfa);
        esperaEspecifica(2000);
        waitForItem(getBotonMfa,120);
        click(this.getBotonMfa);





    }
}


