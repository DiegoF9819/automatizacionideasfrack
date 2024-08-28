package com.pruebas.test;

import com.pruebas.Base;
import com.pruebas.utils.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Time;

public class Offline extends Base {
    //Selectores login
    private By username = By.id("userName");
    private By buscarButton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");
    private By botonListaReservas= By.id ("(//a[normalize-space()='Lista de reservas'])[1]");



    public Offline(WebDriver driver) {super(driver);}

    public void selectAndinsertData(){




            //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);


        waitForItem(botonListaReservas,120);
        selectOption(1,this.botonListaReservas);
        click(botonListaReservas);
        ScreenShots.screenShots(this.getDriver(),"Offline");
            click(this.buscarButton);






        }
    }

