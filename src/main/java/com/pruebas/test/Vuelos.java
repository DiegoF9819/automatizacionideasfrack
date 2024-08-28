package com.pruebas.test;

import com.pruebas.Base;
import com.pruebas.utils.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Vuelos extends Base {

    //Selectores opciones
    private By vuelos = By.className("icoPlane");

    //SELECTORES TIPO DE VUELO
    private By selectSoloIda = By.id("oneway_searchBox_flights_div");
    private By selectMultiplesVuelos = By.id("multiples_searchBox_flights_div");
    private By input1Ciudad = By.id("OrigemText_searchBox_flights_div");
    private By inputFecha = By.id("FechaIni_searchBox_flights_div");
    private By horario1 = By.id("HoraIda_searchBox_flights_div");
    private By inputDestino = By.id("DestinoText_searchBox_flights_div");
    private By inputFechaFinal = By.id("FechaFin_searchBox_flights_div");
    private By option1 = By.className("ui-menu-item");
    private By option2 = By.cssSelector("ul[id=\"ui-id-23\"]>li[class = \"ui-menu-item\"]");
    private By horirario2 = By.id("HoraVolta_searchBox_flights_div");
    private By selectPasager = By.id("selAdults_searchBox_flights_div");
    private By selectNinhos = By.id("selChildren_searchBox_flights_div");
    private By selectBabys = By.id("selBabies_searchBox_flights_div");
    private By cabina = By.id("Cabine_searchBox_flights_div");
    private By moneda = By.id("Currency_searchBox_flights_div");
    private By buttonSearch = By.id("btnSearchByPrice_searchBox_flights_div");

    //Cias Aéreas
    private By ciasAereas = By.id("allCias_searchBox_flights_div");
    private By amadeus = By.id("Source_amadeusws_1243");
    private By avianca = By.id("Source_aviancandc_2864");
    private By conviasa = By.id("Source_conviasa_2703");
    private By copa = By.id("Source_copandc_2241");
    private By estelar = By.id("Source_estelar_2738");
    private By gcaAirlines = By.id("Source_gca_1767");
    private By iberia = By.id("Source_iberiandc_2843");
    private By laser = By.id("Source_laser_1680");
    private By latamNdc = By.id("Source_latamndc_2506");
    private By rutaca = By.id("Source_rutaca_2785");
    private By sabre = By.id("Source_sabre_1875");
    private By satena = By.id("Source_satena_1259");

    private By getButonreserveMultiVuelo = new By.ByXPath("//*[@id=\"GrupoPrecio_0\"]/div[2]/span/a");
    //selectores agendar


    private By butonreserve = By.cssSelector("span[id=\"btnMakeReserve_0\"]>a[class=\"slidingButton\"]");

    private By ordenarPor = By.id("selOrderDirection");
    private By buttonMejorarCondiciones = By.id("butttonPrecioUpsell_0");
    private By selectEconomy = By.id("radUpsell_0_1_Economy");
    private By botonContinuar = By.xpath("//*[@id=\"divGroupPrecioUpsell_0\"]/div[1]/span[2]/a");
    private By reservar = By.id("btnMakeReserve_0");

    public Vuelos(WebDriver driver) {
        super(driver);
    }

    public void selectAndinsertData(int opcion,String codSeg){

        try {
            System.out.println("Ejecutando test...");

            Login login = new Login(this.getDriver());
            login.initLogin(codSeg);

            //Opción Vuelos
            waitForItem(this.vuelos, 120);
            click(this.vuelos);
            if (opcion ==2){
                click(selectSoloIda);
            }else if(opcion == 3){
                click(selectMultiplesVuelos);
                MultiplesVuelos multiplesVuelos = new MultiplesVuelos(this.getDriver());
                multiplesVuelos.ejecutarMultiplesVuelos();
            }
            if (opcion == 1 || opcion == 2){
                escribir("BOG", this.input1Ciudad);
                waitForItem(option1,20);
                click(option1);
                escribir("01-12-2024",this.inputFecha);
                selectOption(2, this.horario1);
                escribir("mde",this.inputDestino);
                Thread.sleep(1000);
                click(option2);
            }
            if (opcion ==1){
                escribir("17-12-2024",this.inputFechaFinal);
                selectOption(3,this.horirario2);
            }
            selectOption(2,this.selectPasager);
            selectOption(2,this.selectNinhos);
            selectOption(2,this.selectBabys);
            selectOption(1,this.cabina);
            selectOption(1,this.moneda);

            //Seleccionar CIAS
            if (opcion != 3){
                waitForItem(this.ciasAereas,120);
                click(this.ciasAereas);
                click(this.amadeus);
            }



            if (isDisplayed(this.buttonSearch)){
                esperaEspecifica(2000);
                ScreenShots.screenShots(this.getDriver(),"vuelos"+(opcion == 3?"_multiples":""));
            }
            //Botón buscar
            click(this.buttonSearch);



            //Agendar Vuelo
            if (opcion == 3 ){
                waitForItem(this.getButonreserveMultiVuelo,120);
                esperaEspecifica(2000);
                ScreenShots.screenShots(this.getDriver(),"vuelos");
                scrollY(3);
                esperaEspecifica(2000);
                ScreenShots.screenShots(this.getDriver(),"vuelos");
                click(this.getButonreserveMultiVuelo);
                waitForItem(this.butonreserve,120);
                scrollY(-3);
                esperaEspecifica(2000);
                ScreenShots.screenShots(this.getDriver(),"vuelos");
                click(this.butonreserve);


            }else{
                waitForItem(this.ordenarPor,60);
                selectOption(1,this.ordenarPor);
                waitForItem(this.buttonMejorarCondiciones,60);
                click(this.buttonMejorarCondiciones);
                esperaEspecifica(2000);
                ScreenShots.screenShots(this.getDriver(),"vuelos");
                waitForItem(this.selectEconomy,60);
                click(this.selectEconomy);
                waitForItem(this.botonContinuar,30);
                click(this.botonContinuar);
                esperaEspecifica(2000);
                ScreenShots.screenShots(this.getDriver(),"vuelos");
                waitForItem(this.reservar,60);
                click(this.reservar);

            }
            esperaEspecifica(2000);
            ScreenShots.screenShots(this.getDriver(),"vuelos"+(opcion == 3?"_multiples":""));
            System.out.println("////Test finalizado////\n");



        }catch (Exception e){
            System.out.println("////Error al ejecutar el test////");
            e.printStackTrace();
            ScreenShots.screenShots(this.getDriver(),"ERROR");
        }




    }
}
