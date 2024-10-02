package com.pruebas.test;


import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Caracterizacion extends Base {
    // Selectores para los campos del formulario
    private By logina = By.id("logina"); // Correo electrónico
    private By clavea = By.id("clavea"); // Contraseña
    private By rol = By.id("roll");      // Selector de rol
    private By loginButton = By.xpath("//button[@type='submit']"); // Botón de enviar
    private By closeButton = By.cssSelector("button.close[data-dismiss='modal']"); // Botón para cerrar el modal
    private By caracterizacionButtonById = By.id("btnCaracterizacion"); // Usando id
    private By seresOriginalesLink = By.linkText("Seres originales"); // Selección por texto

    public Caracterizacion(WebDriver driver) {
        super(driver);
    }

    public void ejecutarOtrosServicios() {
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

        // Cierra la ventana/modal si está abierta
        closeModal();

        // Click en el botón "Caracterización"
        clickCaracterizacionButton();

        // Click en el enlace "Seres originales"
        clickSeresOriginales();
    }

    private void closeModal() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
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

    private void clickCaracterizacionButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            WebElement caracterizacionButton = wait.until(ExpectedConditions.elementToBeClickable(caracterizacionButtonById));
            if (caracterizacionButton.isDisplayed() && caracterizacionButton.isEnabled()) {
                caracterizacionButton.click();
            } else {
                System.out.println("El botón 'Caracterización' no está visible o habilitado.");
            }
        } catch (Exception e) {
            System.out.println("No se pudo hacer clic en el botón 'Caracterización': " + e.getMessage());
        }
    }

    private void clickSeresOriginales() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            WebElement seresOriginales = wait.until(ExpectedConditions.elementToBeClickable(seresOriginalesLink));
            if (seresOriginales.isDisplayed() && seresOriginales.isEnabled()) {
                seresOriginales.click();
            } else {
                System.out.println("El enlace 'Seres originales' no está visible o habilitado.");
            }
        } catch (Exception e) {
            System.out.println("No se pudo hacer clic en el enlace 'Seres originales': " + e.getMessage());
        }
    }
}

