package com.pruebas.test;

import com.pruebas.Base;
import com.pruebas.utils.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Time;

public class gestion extends Base {
    //Selectores login
    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");

    private By botongestion= By.className("icoCheckSquare");

    private By menuBackend=By.id("backendTopMenu");

    private By getMenuBackend=By.className("nav-collapse");



    private By botonEntidades= By.className("(//a[normalize-space()='Entidades'])[1]");

    public gestion (WebDriver driver) {super(driver);}

    public void ejecutarGestion() {

    }

    public void ejecutargestion() {


        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botongestion,120);
        click(this.botongestion);
        esperaEspecifica(2000);
        waitForItem(menuBackend,60);
        click(this.menuBackend);
        esperaEspecifica(2000);
        waitForItem(getMenuBackend,30);
        click(this.getMenuBackend);
        esperaEspecifica(2000);
        waitForItem(botonEntidades,30);
        selectOption(1, this.botonEntidades);
        click(this.botonEntidades);
        esperaEspecifica(2000);

        try{
            waitForItem(By.id("tabSources"),120);
            scrollY(5);
            ScreenShots.screenShots(this.getDriver(),"autos");
            esperaEspecifica(6000);
            clickElementList(7,this.getMenuBackend); //Elegir a partir del 6to elemento
        }catch (ArithmeticException e){
            waitForItem(this.botonEntidades,60);
            System.out.println("No hay disponibilidad");
        }
        ScreenShots.screenShots(this.getDriver(),"autos");





    }
}







