package com.parabank.base;

import com.parabank.pages.BasePage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    private String URL = "https://parabank.parasoft.com/parabank/admin.htm";
    // data for the Test
    public String firstName = "Paco";
    public String lastName = "De Lucia";
    public String address = "Awesome Street 123",city="Los Angeles",state="California";
    public String zipCode = "0000";
    public String phone = "+1-587-530-2271";
    public String ssn = "123"; //social security number
    public String generatedUsername = BasePage.generateUsername();
    public String generatedPassword = BasePage.generatePassword();
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getURL());
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }
    public void setURL(String url){
        this.URL = url;
    }
    public String getURL(){
        return this.URL;
    }
    /*
    @AfterClass
    public void tearDown() {
        driver.quit();
    }*/
}
