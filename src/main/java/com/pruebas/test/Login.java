package com.pruebas.test;

import com.pruebas.Base;
import com.pruebas.utils.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class Login extends Base {
    public Login(WebDriver driver) {
        super(driver);
    }
    private By username = By.id("userName");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");
    private By conSegInput = By.id("InputCodeMFA");
    private By botonCodSeg = By.id("ValidCodeMFA");
    public void initLogin(String codSeg){
        Scanner scanner = new Scanner(System.in);

        //Login
        escribir("fer.salazar",this.username);
        escribir("1234Godie1987*",this.password);
        click(this.loginButton);
        waitForItem(this.conSegInput,120);
        escribir(codSeg,this.conSegInput);
        ScreenShots.screenShots(this.getDriver(),"login");
        click(this.botonCodSeg);

    }
}
