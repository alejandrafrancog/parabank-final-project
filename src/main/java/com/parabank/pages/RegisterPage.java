package com.parabank.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    protected LoginPage loginPage;
    private By firstnameField = By.id("customer.firstName");
    private By lastnameField = By.id("customer.lastName");
    private By addressField = By.id("customer.address.street");
    private By cityField = By.id("customer.address.city");
    private By stateField = By.id("customer.address.state");
    private By zipCodeField = By.id("customer.address.zipCode");
    private By phoneField = By.id("customer.phoneNumber");
    private By ssnField = By.id("customer.ssn");
    private By usernameField = By.id("customer.username");
    private By passwordField = By.id("customer.password");
    private By confirmPasswordField = By.id("repeatedPassword");
    private By registerButton = By.xpath("//input[@value='Register']");
    private By registrationMessage = By.className("title");
    private By userAlreadyExistsError = By.id("customer.username.errors");

    public void setFirstnameField(String firstname) {
        setLocator(firstnameField,firstname);
    }
    public void setLastnameField(String lastname) {
        setLocator(lastnameField,lastname);
    }
    public void setAddress(String address) {
        setLocator(addressField,address);
    }
    public void setCity(String city) {
        setLocator(cityField,city);
    }
    public void setState(String state) {
        setLocator(stateField,state);
    }
    public void setZipCode(String zipCode) {
        setLocator(zipCodeField,zipCode);
    }
    public void setPhone(String phone) {
        setLocator(phoneField,phone);
    }
    public void setSsn(String ssn) {
        setLocator(ssnField,ssn);
    }
    public void setUsername(String username) {
        setLocator(usernameField,username);
    }
    public void setPassword(String password) {
        setLocator(passwordField,password);
    }
    public void setConfirmPassword(String password) {
        setLocator(confirmPasswordField,password);
    }
    public String getRegistrationMessage(){
        return find(registrationMessage,10).getText();
    }
    public AccountsServicesPage clickRegisterButton(){
        click(registerButton);
        return new AccountsServicesPage();
    }
    public AccountsServicesPage register(String firstName, String lastName, String address, String ciy,
                                         String state, String zipCode, String phone, String ssn,
                                         String username, String password) {
        try{
            do {
                setFirstnameField(firstName);
                setLastnameField(lastName);
                setAddress(address);
                setCity(ciy);
                setState(state);
                setZipCode(zipCode);
                setPhone(phone);
                setSsn(ssn);
                setUsername(username);
                setPassword(password);
                setConfirmPassword(password);
                return clickRegisterButton();
            }while(find(userAlreadyExistsError,15).isDisplayed());


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new AccountsServicesPage();
    }
}
