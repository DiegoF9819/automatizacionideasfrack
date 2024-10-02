package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Programas extends Base {

    // Selectores para los campos del formulario
    private By logina = By.id("logina"); // Correo electrónico
    private By clavea = By.id("clavea"); // Contraseña
    private By rol = By.id("roll");      // Selector de rol
    private By loginButton = By.xpath("//button[@type='submit']"); // Botón de enviar
    private By closeButton = By.cssSelector("button.close[data-dismiss='modal']"); // Botón para cerrar el modal
    private By programasLink = By.xpath("//a[contains(@class, 'nav-link') and contains(., 'Programas')]"); // Enlace a programas
    private By ingenieriaSoftwareLink = By.xpath("//a[@title='Profesional en ingeniería de software']"); // Selector para el enlace

    public Programas(WebDriver driver) {
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

        // Hacer clic en el enlace "Programas"
        clickEnProgramas();

        // Ahora hacer clic en "Profesional en Ingeniería de Software"
        clickEnIngenieriaSoftware();
    }

    private void clickEnProgramas() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        try {
            WebElement programasElement = wait.until(ExpectedConditions.elementToBeClickable(programasLink));

            // Verificación adicional antes de hacer clic
            if (programasElement.isDisplayed() && programasElement.isEnabled()) {
                programasElement.click();
            } else {
                System.out.println("El enlace 'Programas' no está visible o habilitado.");
            }
        } catch (Exception e) {
            System.out.println("No se pudo hacer clic en el enlace 'Programas': " + e.getMessage());
        }
    }

    private void clickEnIngenieriaSoftware() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        try {
            WebElement ingenieriaElement = wait.until(ExpectedConditions.elementToBeClickable(ingenieriaSoftwareLink));

            // Verificación adicional antes de hacer clic
            if (ingenieriaElement.isDisplayed() && ingenieriaElement.isEnabled()) {
                ingenieriaElement.click();
            } else {
                System.out.println("El enlace 'Profesional en Ingeniería de Software' no está visible o habilitado.");
            }
        } catch (Exception e) {
            System.out.println("No se pudo hacer clic en el enlace 'Profesional en Ingeniería de Software': " + e.getMessage());
        }
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

    private void esperarCarga() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            // Espera a que un elemento clave de la página esté visible (ajusta según tu caso)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementoClave"))); // Cambia "elementoClave" según lo que necesites
        } catch (Exception e) {
            System.out.println("No se pudo confirmar la carga de la página: " + e.getMessage());
        }
    }
}
