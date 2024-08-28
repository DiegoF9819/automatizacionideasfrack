package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reservas extends Base {

    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");

    private By botonReservas= By.id("btnListReservation");







    public Reservas(WebDriver driver) {super(driver);}

    public void ejecutarReservas(){



        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botonReservas,120);
        click(this.botonReservas);





    }
}



