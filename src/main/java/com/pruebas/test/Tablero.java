package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Tablero extends Base {
    // Selectores para los campos del formulario
    private By logina = By.id("logina"); // Correo electrónico
    private By clavea = By.id("clavea"); // Contraseña
    private By rol = By.id("roll");      // Selector de rol
    private By loginButton = By.xpath("//button[@type='submit']"); // Botón de enviar
    private By closeButton = By.cssSelector("button.close[data-dismiss='modal']"); // Botón para cerrar el modal
    private By tableroLink = By.xpath("//a[contains(@class, 'nav-link') and contains(., 'Tablero')]"); // Selector para el enlace "Tablero"

    public Tablero(WebDriver driver) {
        super(driver);
    }

    public void ejecutarLista() {
        // Login
        waitForItem(this.logina, 30);
        escribir("df.giraldo24@ciaf.edu.co", this.logina);

        waitForItem(this.clavea, 30);
        escribir("godie1987", this.clavea);

        waitForItem(this.rol, 30);
        click(this.rol);
        selectOption(2, this.rol); // Selecciona la opción "Estudiante"

        waitForItem(this.loginButton, 30);
        click(this.loginButton);

        // Cierra el modal si es necesario
        closeModal();

        // Espera un poco para confirmar que el login se realizó
        esperarCarga();

        // Hacer clic en el enlace "Tablero"
        clickEnTablero();
    }

    private void closeModal() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            // Espera a que el modal sea visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeButton));
            if (closeBtn.isDisplayed() && closeBtn.isEnabled()) {
                closeBtn.click();
            } else {
                System.out.println("El botón de cierre no está visible o habilitado.");
            }
        } catch (Exception e) {
            System.out.println("No se pudo cerrar el modal: " + e.getMessage());
        }
    }

    private void clickEnTablero() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        try {
            WebElement tableroElement = wait.until(ExpectedConditions.elementToBeClickable(tableroLink));
            // Verificación adicional antes de hacer clic
            if (tableroElement.isDisplayed() && tableroElement.isEnabled()) {
                tableroElement.click();
            } else {
                System.out.println("El enlace 'Tablero' no está visible o habilitado.");
            }
        } catch (Exception e) {
            System.out.println("No se pudo hacer clic en el enlace 'Tablero': " + e.getMessage());
        }
    }

    private void esperarCarga() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            // Espera a que un elemento clave de la página esté visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementoClave"))); // Cambia por un ID real
        } catch (Exception e) {
            System.out.println("No se pudo confirmar la carga de la página: " + e.getMessage());
        }
    }
}
