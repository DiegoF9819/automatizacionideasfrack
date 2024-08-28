
package com.pruebas.test;

import com.pruebas.Base;
import com.pruebas.utils.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Hoteles extends Base {
    //Selectores Hotel
    private By opcionHotel = By.className("icoBed");
    private By inputCiudad = By.id("hotelCityText_searchBoxHotelsDiv");
    private By selectPrimerCiudad = By.className("ui-menu-item");
    private By fechaCheckIn = By.id("hotelCheckinDate_searchBoxHotelsDiv");
    private By fechaCheckOut = By.id("hotelCheckoutDate_searchBoxHotelsDiv");
    private By selectHabitaciones = By.id("hotelRoomsSelect_searchBoxHotelsDiv");
    private By selectHabitacionAdultos = By.id("adultsSelect_searchBoxHotelsDiv_0");
    private By selectHabitacionesNinhos = By.id("childrenSelect_searchBoxHotelsDiv_0");
    private By edadNinhos = By.id("ageSelector_searchBoxHotelsDiv_0_0");

    //CheckBoxes
    private By proovedor = By.id("allSourcesCheckbox_searchBoxHotelsDiv");
    private By fastpayhotels = By.id("Source_searchBoxHotelsDiv_hotels_fastpay");
    private By bluediamond = By.id("Source_searchBoxHotelsDiv_hotels_bluediamond");
    private By catalonia = By.id("Source_searchBoxHotelsDiv_hotels_catalonia");
    private By oceanhotels = By.id("Source_searchBoxHotelsDiv_hotels_oceanhotels");
    private By amadeusHoteles = By.id("Source_searchBoxHotelsDiv_hotels_amadeus");
    private By americanExecutive = By.id("Source_searchBoxHotelsDiv_hotels_americanexecutive");
    private By bahiaPrincipe = By.id("Source_searchBoxHotelsDiv_hotels_dingus");
    private By goGoblalTravel = By.id("Source_searchBoxHotelsDiv_hotels_dingus");
    private By apitude = By.id("Source_searchBoxHotelsDiv_hotels_hotelbeds");
    private By hoteldo = By.id("Source_searchBoxHotelsDiv_hotels_hoteldo");
    private By palladium = By.id("Source_searchBoxHotelsDiv_hotels_palladium");
    private By riu = By.id("Source_searchBoxHotelsDiv_hotels_riu");
    private By sirenis = By.id("Source_searchBoxHotelsDiv_hotels_sirenis");
    private By tboholidays = By.id("Source_searchBoxHotelsDiv_hotels_tboholidays");
    private By omnibees = By.id("Source_searchBoxHotelsDiv_omnibees");


    //Inputs seleccionados pero no usados
    private By codigoPostal = By.id("zipCode_searchBoxHotelsDiv");
    private By nombreHotel = By.id("hotelName_searchBoxHotelsDiv");
    private By direccion = By.id("hotelAddress_searchBoxHotelsDiv");


    //Boton Buscar
    private By btoDetalle = By.id("btnVistaDetalle");
    private By buscarButton = By.id("searchButton_searchBoxHotelsDiv");


    //Seleccionadores Reserva
    private By reservar = By.xpath("(//*[@class='btn btn-primary btn-lg searchButton pull-right'])[1]");



    public Hoteles(WebDriver driver) {
        super(driver);
    }

    public void selectAndinsertData(String codSeg){

        try {
            //Login
            Login login = new Login(this.getDriver());
            login.initLogin(codSeg);

            //Elegir y rellenar opción Hotel
            waitForItem(this.opcionHotel,120);
            click(this.opcionHotel);
            escribir("MIA",this.inputCiudad);
            waitForItem(this.selectPrimerCiudad,120);
            click(this.selectPrimerCiudad);
            borrar(this.fechaCheckIn);
            borrar(this.fechaCheckOut);
            escribir("12-12-2024",this.fechaCheckIn);
            escribir("24-12-2024",this.fechaCheckOut);
            selectOption(0,this.selectHabitaciones);
            selectOption(0,this.selectHabitacionAdultos);
            selectOption(1,this.selectHabitacionesNinhos);
            selectOption(7,this.edadNinhos);


            //OPCIONALES
            //Seleccionar checkBoxes:

            //click(this.proovedor);
            //click(this.tboholidays);
            //click(this.apitude);


            //inputs de codigo postal, nombre hotel y dirección
            //escribir("0000",this.codigoPostal);
            //escribir("California",this.nombreHotel);
            //escribir("Carrera x # x-x",this.direccion);

            ScreenShots.screenShots(this.getDriver(),"hoteles");
            click(this.buscarButton);
            try{
                waitForItem(this.btoDetalle, 120);
                waitForItem(this.reservar, 120);
                ScreenShots.screenShots(this.getDriver(),"hoteles");
                click(this.reservar);
            }catch(ArithmeticException  e){
                System.out.println("No hay disponibilidad");
            }
            ScreenShots.screenShots(this.getDriver(),"hoteles");
            System.out.println("////Test finalizado////");
        }catch (ArithmeticException e){
            System.out.println("////Error al ejecutar el test////");
            e.printStackTrace();
            ScreenShots.screenShots(this.getDriver(),"ERROR");
        }


    }

}
