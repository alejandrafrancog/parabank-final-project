package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountsServicesPage extends BasePage{
    private final By openNewAccountLink = By.xpath("//li//a[contains(text(),'Open')]");
    private final By transferFundsLink = By.xpath("//li//a[contains(text(),'Transfer')]");
    public OpenNewAccountPage clickOpenNewAccountLink() {
        find(openNewAccountLink,10).click();
        return new OpenNewAccountPage();
    }
    public TransferFundsPage clickTransferFundsLink() {
        find(transferFundsLink,10).click();
        return new TransferFundsPage();
    }

}
