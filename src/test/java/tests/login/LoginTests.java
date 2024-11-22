package tests.login;

import com.parabank.base.BaseTest;
import com.parabank.pages.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);

    @Test
    public void successfulRegistration() {
        registerPage = loginPage.goToRegisterPage();
        registerPage.register(firstName,
                lastName,
                address,
                city,
                state,
                zipCode,
                phone,
                ssn,
                generatedUsername,generatedPassword);
        String successfulRegistrationMessage = registerPage.getRegistrationMessage();
        System.out.println(successfulRegistrationMessage.toUpperCase());
        assertTrue(successfulRegistrationMessage.contains("Welcome"));
    }
    @Test
    public void successfulLogin() throws InterruptedException {
        registerPage = loginPage.goToRegisterPage();
        registerPage.register(firstName, lastName, address, city, state, zipCode, phone, ssn, generatedUsername, generatedPassword);
        loginPage.setUsername(generatedUsername);
        loginPage.clickLogoutButton();
        System.out.println("CLICKED LOGOUT BUTTON------------------");
        loginPage.setPassword(generatedPassword);
        loginPage.clickLoginButton();
        String loginText = loginPage.getLoginText();
        Thread.sleep(10000);
        assertTrue(loginText.contains("Accounts"));
    }

    @Test
    public void successfulLogout() {
        loginPage.setUsername(generatedUsername);
        loginPage.setPassword(generatedPassword);
        loginPage.clickLogoutButton();
    }
//    @Test
//    public void successfulLoginAfterRegistration() {
//
//    }
}
