package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CambiarAgencia extends Base {
    //Selectores login
    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");

    private By botonCambiaragencia= By.id("btnAlterAgency");



    private By botoncambiar= By.id("d_detalles_32467");



    public CambiarAgencia(WebDriver driver) {super(driver);}

    public void ejecutarCambiarAgencia(){



        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);

        waitForItem(botonCambiaragencia,120);
        click(this.botonCambiaragencia);
        esperaEspecifica(2000);
        waitForItem(botoncambiar,60);
        click(this.botoncambiar);






    }
}

