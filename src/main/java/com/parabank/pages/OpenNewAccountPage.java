package com.parabank.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.ArrayList;

public class OpenNewAccountPage extends BasePage {
    private By accountTypeDropDown = By.id("type");
    private By selectAccountDropDown = By.id("fromAccountId");
    private By openNewAccountButton = By.cssSelector("input.button");
    private By message = By.cssSelector("#openAccountResult h1");
    private By transferFundsLink = By.xpath("//a[contains(text(),'Transfer')]");
    private By openNewAccountTitle = By.xpath("//div//h1[contains(text(),'Open New Account')]");
    private By errorNotAuthenticated = By.className("error");
    protected RegisterPage registerPage;
    protected LoginPage loginPage;

    public void clickOpenNewAccountButton()  {
        WebElement openAccountButton = find(openNewAccountButton,10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement openAccButton = wait.until(ExpectedConditions.elementToBeClickable(openAccountButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", openAccountButton);
        openAccountButton.click();
        System.out.println("_--------------CLICKED!!!!!!!--------------");
        click(openNewAccountButton);
    }
    public void createNewAccount(OpenNewAccountPage page){
        registerPage = loginPage.goToRegisterPage(); // user goes to the register page
        AccountsServicesPage accountServices = registerPage.register(firstName, lastName,
                address, city, state,
                zipCode, phone, ssn,
                generatedUsername,
                generatedPassword);
        page = accountServices.clickOpenNewAccountLink();
        try{
            Thread.sleep(40000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        page.clickOpenNewAccountButton();
    }
    public void clickAccountTypeDropDown(){
        click(accountTypeDropDown);
    }
    public void clickFundingAccountDropDown(){
        click(selectAccountDropDown);
    }
    public ArrayList<WebElement> getAvailableAccounts(){
        ArrayList<WebElement> elements = findElements(selectAccountDropDown,50);
        return elements;
    }
    public void clickAvailableAccount() throws InterruptedException{
        int random = new Random().nextInt(getAvailableAccounts().size());
        System.out.println(getAvailableAccounts().get(random).getText()+"\n");
        Thread.sleep(2000);
        By option = By.id(getAvailableAccounts().get(random).getText());
        click(option);
        System.out.println("_--------------CLICKED!!!!!!!--------------");
    }
    public String getSuccessfullyOpenedAccountMessage() {
        String message_shown = find(message,30).getText();
        return message_shown;
    }
    public TransferFundsPage clickTranferFundsLink(){
        click(transferFundsLink);
        return new TransferFundsPage();
    }
    public String getOpenNewAccountTitle(){
        return find(openNewAccountTitle,10).getText();
    }
    public OpenNewAccountPage getOpenNewAccountURL(){
        String url = "https://parabank.parasoft.com/parabank/openaccount.htm";
        driver.get(url);
        return new OpenNewAccountPage();
    }
    public String getNotAuthenticatedError(){
        return find(errorNotAuthenticated,20).getText();
    }
}
