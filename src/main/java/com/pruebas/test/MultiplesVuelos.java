package com.pruebas.test;

import com.pruebas.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiplesVuelos extends Base {
    public MultiplesVuelos(WebDriver driver) {
        super(driver);
    }

    private static int cantSelect = 1;
    private By option1 = By.className("ui-menu-item");
    private By option2 = By.cssSelector("ul[id=\"ui-id-17\"]>li[class = \"ui-menu-item\"]");
    private By option3 = By.cssSelector("ul[id=\"ui-id-19\"]>li[class = \"ui-menu-item\"]");
    private By restarVuelos = By.id("btnRemoveDestination_searchBox_flights_div");
    private By botonSumarVuelos = By.id("btnAddDestination_searchBox_flights_div");

    public void ejecutarMultiplesVuelos(){
        escribir("BOG", By.id("multiOrigemText_searchBox_flights_div_"+ cantSelect));
        waitForItem(this.option1,20);
        click(this.option1);
        escribir("MIA", By.id("multiDestinoText_searchBox_flights_div_"+cantSelect));
        waitForItem(this.option2,20);
        click(this.option2);
        escribir("01-12-2024", By.id("multiFechaIni_searchBox_flights_div_"+cantSelect));
        selectOption(2, By.id("multiHoraIda_searchBox_flights_div_"+cantSelect));

        // Incrementa cantSelect para seleccionar el próximo div
        cantSelect += 1;
        escribir("MAD", By.id("multiDestinoText_searchBox_flights_div_"+cantSelect));
        waitForItem(this.option3,20);
        click(this.option3);
        escribir("02-12-2024", By.id("multiFechaIni_searchBox_flights_div_"+cantSelect));
        selectOption(2, By.id("multiHoraIda_searchBox_flights_div_"+cantSelect));

        click(restarVuelos);
        //click(botonSumarVuelos);
        //cantSelect += 1;
        //escribir("MAD", By.id("multiDestinoText_searchBox_flights_div_"+cantSelect));
        //waitForItem(this.option3,20);
        //click(this.option3);
        //escribir("02-12-2024", By.id("multiFechaIni_searchBox_flights_div_"+cantSelect));
        //selectOption(2, By.id("multiHoraIda_searchBox_flights_div_"+cantSelect));
    }
}
