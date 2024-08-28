package com.pruebas.test;

import com.pruebas.Base;
import com.pruebas.utils.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Autos extends Base {
    //Selectores login
    private By icoCar = By.className("icoCar");
    private By inputRetirada = By.id("autosTextFromDescsearchBox_autos_div");
    private By selectInputRetirada = By.className("ui-menu-item");
    private By fechaRetirada = By.id("autosDateFromsearchBox_autos_div");
    private By horaRetirada = By.id("horaRetiradasearchBox_autos_div");
    private By fechaEntrega = By.id("autosDateTosearchBox_autos_div");
    private By horaEntrega = By.id("horaEntregasearchBox_autos_div");
    private By localRetiro = By.id("placeCarsFromsearchBox_autos_div");
    private By ciudadDevolucion = By.id("autosTextToDescsearchBox_autos_div");
    private By selectCiudadDev = By.cssSelector("ul[id=\"ui-id-17\"]>li");
    private By localEntrega = By.id("placeCarsTosearchBox_autos_div");
    private By moneda = By.id("tipoMonedasearchBox_autos_div");
    private By tipoVehiculo = By.id("tiposAutossearchBox_autos_div");
    private By sources = By.id("allSourcesCarsCheckbox");
    private By amadeusCarros = By.id("SourceCar_cars_amadeus_ws");
    private By botonBuscar = By.id("btnSearchAutossearchBox_autos_div");

    private By noHayDisponibilidad = By.cssSelector("div[id=\"resultByBrand_0\"]>div>div[class=\"alert\"]");
    private By botonSeleccionVehiculo = By.className("slidingButton");




    public Autos(WebDriver driver) {
        super(driver);
    }


    public void selectAndinsertData(String codSeg){
        try {
            Login login = new Login(this.getDriver());
            login.initLogin(codSeg);

            //Agendar vehiculo
            waitForItem(this.icoCar,120);
            click(this.icoCar);
            escribir("MIA",this.inputRetirada);
            waitForItem(this.selectInputRetirada,30);
            click(this.selectInputRetirada);
            escribir("01-04-2024",this.fechaRetirada);
            selectOption(35,this.horaRetirada);
            escribir("07-04-2024",this.fechaEntrega);
            selectOption(36,this.horaEntrega);
            selectOption(0,this.localRetiro);
            borrar(this.ciudadDevolucion);
            escribir("JFK",this.ciudadDevolucion);
            waitForItem(this.selectCiudadDev,60);
            click(this.selectCiudadDev);
            esperaEspecifica(1000);
            selectOption(0,this.localEntrega);
            selectOption(1,this.moneda);
            selectOption(0,this.tipoVehiculo);
            click(this.sources);
            click(this.amadeusCarros);
            ScreenShots.screenShots(this.getDriver(),"autos");
            //Botón buscar
            click(this.botonBuscar);

            try{
                waitForItem(By.id("tabSources"),120);
                scrollY(5);
                ScreenShots.screenShots(this.getDriver(),"autos");
                esperaEspecifica(6000);
                clickElementList(7,this.botonSeleccionVehiculo); //Elegir a partir del 6to elemento
            }catch (ArithmeticException e){
                waitForItem(this.noHayDisponibilidad,60);
                System.out.println("No hay disponibilidad");
            }
            ScreenShots.screenShots(this.getDriver(),"autos");




        }catch (ArithmeticException e){
            System.out.println("////Error al ejecutar el test////");
            e.printStackTrace();
            ScreenShots.screenShots(this.getDriver(),"ERROR");
        }
    }
}
