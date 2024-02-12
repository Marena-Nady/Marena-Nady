package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_Login {
    SHAFT.GUI.WebDriver driver;
    public P01_Login(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");
    By errorMsg = By.xpath("//button[@class=\"error-button\"]//parent:: h3");



    public void loginWith(String username, String password){
        driver.element().type(usernameInput,username).
                type(passwordInput,password).
                click(loginButton);
    }
    public void invalidLoginValidations(String errorMsgText)
    {
        driver.assertThat().element(errorMsg).text().isEqualTo(errorMsgText).perform();
    }
}
