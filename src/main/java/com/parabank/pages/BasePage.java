package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class BasePage {
    public static WebDriver driver;
    public String firstName = "Paco";
    public String lastName = "De Lucia";
    public String address = "Awesome Street 123",city="Los Angeles",state="California";
    public String zipCode = "0000";
    public String phone = "+1-587-530-2271";
    public String ssn = "123"; //social security number
    public String generatedUsername = BasePage.generateUsername();
    public String generatedPassword = BasePage.generatePassword();

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }
    protected WebElement find(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected ArrayList<WebElement> findElements(By locator,int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return (ArrayList<WebElement>)wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    protected void setLocator(By locator, String text) {
        find(locator,10).clear(); // clears in case there's text in input
        find(locator,10).sendKeys(text); // writes data
    }
    protected void click(By locator) {
        find(locator,10).click();

    }
    public static String generateUsername(){
        int random_number= new Random().nextInt(100,2000);
        return "p"+ random_number+"a"+random_number+"b";
    }
    public static String generatePassword(){
        int random_number= new Random().nextInt(100,2000);
        return "HelloItsMe"+random_number;
    }

}
