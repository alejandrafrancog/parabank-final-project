package com.parabank.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//input[@value='Log In']");
    private By logoutButton = By.xpath("//a[contains(text(),'Log Out')]");
    private By registerLink = By.xpath("//p//a[contains(text(),'Register')]");
    private By loginMessage = By.xpath("//h1[contains(text(),'Accounts Overview')]");

    public void setUsername(String username) {
        setLocator(usernameField,username);
    }
    public void setPassword(String password) {
        setLocator(passwordField,password);
    }
    public By getLogoutButtonLocator(){
        return logoutButton;
    }
    public RegisterPage goToRegisterPage() {
        click(registerLink);
        return new RegisterPage();
    }
    public AccountsServicesPage clickLoginButton(){
        //Transition method
        WebElement openAccountButton = find(loginButton,10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButt = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButt);
        openAccountButton.click();
        System.out.println("_--------------CLICKED LOGIN!!!!!!!--------------");
        click(loginButton);
        return new AccountsServicesPage();
    }
    public AccountsServicesPage logIntoApplication(String username, String password){
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }
    public String getLoginText(){
        return find(loginMessage,10).getText();
    }
    public void clickLogoutButton(){
        WebElement logOutButt = find(logoutButton,10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutButt = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logOutButt);
        logoutButt.click();
        System.out.println("_--------------CLICKED LOGIN!!!!!!!--------------");
        click(logoutButton);
    }
}
