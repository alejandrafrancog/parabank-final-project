package tests.openaccount;

import com.parabank.base.BaseTest;
import com.parabank.pages.AccountsServicesPage;
import com.parabank.pages.BasePage;
import com.parabank.pages.OpenNewAccountPage;
import com.parabank.pages.TransferFundsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import javax.crypto.spec.PSource;
import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class OpenNewAccountTests extends BaseTest {
    @Test
    public void openNewAccountSufficientFunds(){
        /*
            Smoke test to verify if an account can be opened when there's at least
            one funding account with at least $100 for the initial deposit
        */
        String message_shown;
        OpenNewAccountPage newPage = new OpenNewAccountPage();

        registerPage = loginPage.goToRegisterPage(); // user goes to the register page
        AccountsServicesPage accountServices = registerPage.register(firstName, lastName,
                address, city, state,zipCode,
                phone,
                ssn,
                generatedUsername,
                generatedPassword);
        newPage = accountServices.clickOpenNewAccountLink();
        try{
            Thread.sleep(40000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        newPage.clickOpenNewAccountButton();
        message_shown = newPage.getSuccessfullyOpenedAccountMessage();
        assertTrue(message_shown.contains("Opened!"));
    }
    @Test
    public void requestNotSentInsufficientFunds(){
        OpenNewAccountPage newPage = new OpenNewAccountPage();
        registerPage = loginPage.goToRegisterPage();
        AccountsServicesPage accountServices = registerPage.register(firstName, lastName,
                address, city, state,zipCode,
                phone,
                ssn,
                generatedUsername,
                generatedPassword);
        newPage = accountServices.clickOpenNewAccountLink();
        try{
            Thread.sleep(40000);
        }catch (Exception e){
            System.out.println(e.getMessage());}

        newPage = accountServices.clickOpenNewAccountLink();
        try{
            Thread.sleep(40000);
        }catch (Exception e){
            System.out.println(e.getMessage());}
        newPage.clickOpenNewAccountButton();
        /********   TRANSFER FUNDS ******/
        newPage.clickTranferFundsLink();
        ArrayList<WebElement> availableAccounts = newPage.getAvailableAccounts();
        int lastCreated = Integer.parseInt(availableAccounts.get(availableAccounts.size()-1).getText());
        System.out.println(lastCreated);

    }

    @Test
    public void openNewAccountLinkRedirectsToCorrectPage(){
        OpenNewAccountPage newPage = new OpenNewAccountPage();
        registerPage = loginPage.goToRegisterPage();
        registerPage.register(firstName,lastName,address,city,state,zipCode,phone,ssn,generatedUsername,generatedPassword);
        AccountsServicesPage accountServices = registerPage.register(firstName, lastName,
                address, city, state,zipCode,
                phone,
                ssn,
                generatedUsername,
                generatedPassword);
        newPage = accountServices.clickOpenNewAccountLink();
        String message = newPage.getOpenNewAccountTitle();
        assertTrue(message.contains("Open New Account"));

    }
    @Test
    public void onlyAuthenticatedUsersCanOpenNewAccount()  {
        OpenNewAccountPage newPage = new OpenNewAccountPage();
        newPage = newPage.getOpenNewAccountURL();
        String message = newPage.getNotAuthenticatedError();
        System.out.println(message.toUpperCase());
        assertTrue(message.contains("An internal error has occurred"));
    }

}
