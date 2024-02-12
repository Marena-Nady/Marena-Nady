package Test_Scenarios;


import Pages.P01_Login;
import Pages.P02_Home;
import com.shaft.driver.SHAFT;
//import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class T01_Login {

    public static SHAFT.GUI.WebDriver driver;
    //public static JSONFileManager testData;
    //String username, password;
    public static P01_Login loginPage;
    public static P02_Home homePage;
    String errorMsgText = "Epic sadface: Username and password do not match any user in this service";
    //String emptyUserErrorText = "Epic sadface: Username is required";
    String EmptyPasswordErrorText = "Epic sadface: Password is required";


    @Test
    public void EmptyUserNameField() {
        loginPage.loginWith("  ", "secret_sauce");
        loginPage.invalidLoginValidations(errorMsgText);
    }

    @Test
    public void EmptyPasswordField() {
        loginPage.loginWith("standard_user", "");
        loginPage.invalidLoginValidations(EmptyPasswordErrorText);
    }

    @Test
    public void loginWithInvalidUsername() {
        loginPage.loginWith("standahfdjn", "secret_sauce");
        loginPage.invalidLoginValidations(errorMsgText);
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.loginWith("standard_user", "sekvnjk");
        loginPage.invalidLoginValidations(errorMsgText);
    }

    @Test
    public void loginWithInvalidPasswordAndUsername() {
        loginPage.loginWith("Marena", "P@ssw0rd");
        loginPage.invalidLoginValidations(errorMsgText);
    }


    @Test
    public void MaxLimitForUsernameField() {
        loginPage.loginWith("standard_userfghfjgmkifjcdmnkrtjgfmdkjrhfndejrhfndjfdfndjrehnfjdhenfcdbrnhfcdrjfhrnkkkkkkkkkkkkkngfyhnkju98765678iplhtrfghn@#$%jfdhnrf", "secret_sauce");
        loginPage.invalidLoginValidations(errorMsgText);
    }

    @Test
    public void MaxLimitForPasswordField() {
        loginPage.loginWith("standard_user", "secret_saucedfghjkdfjhgrbdnmfgkjvhfbrdenmrk5turielk,dfmngtbv gnfmvcjfhdrbnmftgbrdnemdxbfrhjnmedfkjgnvf ");
        loginPage.invalidLoginValidations(errorMsgText);
    }

    @Test
    public void loginWithValidData() {
        loginPage.loginWith("standard_user", "secret_sauce");
        homePage.successfulLoginValidation();
    }


    @BeforeClass
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.saucedemo.com/");
        SHAFT.Properties.flags.set().attemptClearBeforeTyping(true);
        loginPage = new P01_Login(driver);
        homePage = new P02_Home(driver);

    }

  /*  @BeforeMethod
    public void prepareData(Method method) {
        username = testData.getTestData(method.getName() + ".username");
        password = testData.getTestData(method.getName() + ".password");
    }*/

    @AfterClass
    public void close() {
        driver.quit();
    }
}
