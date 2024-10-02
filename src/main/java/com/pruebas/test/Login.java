package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {

    // Selectores actualizados para los campos del formulario
    private By logina = By.id("logina"); // Campo de correo electrónico
    private By clavea = By.id("clavea"); // Campo de contraseña
    private By rol = By.id("roll");      // Selector de rol
    private By loginButton = By.xpath("//button[@type='submit']"); // Botón de enviar

    public Login(WebDriver driver) {
        super(driver);
    }

    public void initLogin() {
        // Espera y completa el formulario de inicio de sesión
        waitForItem(this.logina, 30);
        escribir("df.giraldo24@ciaf.edu.co", this.logina);

        waitForItem(this.clavea, 30);
        escribir("godie1987", this.clavea);

        waitForItem(this.rol, 30);
        click(this.rol);
        selectOption(2, this.rol); // Selecciona la opción deseada (ajusta el índice si es necesario)

        waitForItem(this.loginButton, 30);
        click(this.loginButton);

        // Opcional: Verifica que la acción de login haya sido exitosa
        // Puedes agregar aquí código para verificar la redirección o el éxito del login
    }
}
