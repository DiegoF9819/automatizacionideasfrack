package com.pruebas;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver cromeDriverConection() {
        System.setProperty("webdriver.chrome.driver", "./src/main/java/chromedriver/chromedriver1.exe");
        driver = new ChromeDriver();
        Point position = new Point(400, 0); // Posición en la pantalla
        driver.manage().window().setPosition(position);
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement finElemet(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElemets(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void escribir(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickElementList(int position, By locator) {
        List<WebElement> elementos = driver.findElements(locator);
        WebElement primerElemento = elementos.get(position);
        primerElemento.click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchContextException e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void waitForItem(By locator, int time) {
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(time));
        ewait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void esperaEspecifica(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    public void scrollY(int cant) {
        Dimension windowSize = driver.manage().window().getSize();
        Long scrollHeight = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + (scrollHeight / cant) + ")");
        Long newScrollY = (Long) ((JavascriptExecutor) driver).executeScript("return window.scrollY");
    }

    public Boolean validateTags(String data, By locator) {
        List<WebElement> tdElements = driver.findElements(locator);
        Boolean isLocate = false;
        for (WebElement item : tdElements) {
            String element = item.getText();
            if (element.equals(data)) {
                isLocate = true;
            }
        }
        return isLocate;
    }

    public String selectOption(int option, By locator) {
        Select optionSelect = new Select(finElemet(locator));
        optionSelect.selectByIndex(option);
        return getText(optionSelect.getFirstSelectedOption());
    }

    public void borrar(By locator) {
        driver.findElement(locator).clear();
    }
}
