package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage extends BasePage {
    private By amount = By.id("amount");
    private By fromAccountDrop = By.id("fromAccountId");
    private By toAccountDrop = By.id("toAccountId");
    private By transferButton = By.xpath("//input[@value='Transfer']");

    public TransferFundsPage clickTransferFundsButton() {
        driver.findElement(transferButton).click();
        return new TransferFundsPage();
    }


}
