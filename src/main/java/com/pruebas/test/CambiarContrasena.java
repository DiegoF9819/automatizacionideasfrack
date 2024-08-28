package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;

public class CambiarContrasena extends Base {
    //Selectores login
            private By username = By.id("userName");
            private By boton = By.id("");
            private By password = By.id("password");
            private By loginButton = By.id("btnLoginBoxAccept");



            private By botonCambioContrasena= By.id("btnChangePass");

            private By  new_password_field = By.id ("newPass");

            private By  change_password_button = By.id ("btnChangeChangePass");

            private By  old_password_field = By.id("oldPass");



            private By confirm_new_password_field = By.id ("confirmNewPass");

            private By botoncambiar= By.className("slidinButton");





            public CambiarContrasena(WebDriver driver) {super(driver);}

            public void ejecutarCambioContrasena() {


               //Login
               escribir("fer.salazar", this.username);
               escribir("1234Godie1987*", this.password);
               click(this.loginButton);

               waitForItem(botonCambioContrasena, 120);
               click(this.botonCambioContrasena);
               esperaEspecifica(2000);
               waitForItem(old_password_field, 60);
               click(this.old_password_field);
               esperaEspecifica(2000);
               escribir("5678Godie1987*", this.old_password_field);
               click(this.old_password_field);
               waitForItem(new_password_field, 60);
               click(this.new_password_field);
               escribir("1234Godie1987*", this.new_password_field);
               waitForItem(confirm_new_password_field, 60);
               click(this.confirm_new_password_field);
               escribir("1234Godie1987*", this.confirm_new_password_field);
               click(this.confirm_new_password_field);
               waitForItem(change_password_button, 60);
               click(this.change_password_button);
               esperaEspecifica(2000);


                // Verificar el cambio de contraseña (se asume que hay un mensaje de éxito)
                if (isElementPresent(By.xpath("//div[@class='success-message']"))) {
                    System.out.println("Contraseña cambiada exitosamente!");
                } else {
                    System.out.println("Error: No se pudo encontrar el mensaje de éxito después de cambiar la contraseña.");
                }
            }

                private boolean isElementPresent(By locator) {
                 try {
                     WebElement driver = null;
                           driver.findElement(locator);
                      return true;
                 } catch (Exception e) {
                      return false;
               }
             }
            }






















