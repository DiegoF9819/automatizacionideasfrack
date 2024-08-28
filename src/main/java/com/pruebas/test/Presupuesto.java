package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Presupuesto extends Base {
    //Selectores login
    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");




    By botonPresupuesto = By.xpath("//*[@id=\"innerMainMenu\"]/ul/li[8]/a");

    public Presupuesto(WebDriver driver) {
        super(driver);
    }

    public void ejecutarPresupuesto(){
        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botonPresupuesto,120);
        click(botonPresupuesto);
    }
}
