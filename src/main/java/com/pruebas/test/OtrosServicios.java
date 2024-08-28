package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtrosServicios extends Base {
    //Selectores login
    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");




    By botonOtrosServicios = By.xpath("//*[@id=\"innerMainMenu\"]/ul/li[8]/a");

    public OtrosServicios(WebDriver driver) {
        super(driver);
    }

    public void ejecutarOtrosServicios(){
        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botonOtrosServicios,120);
        click(botonOtrosServicios);
    }
}
