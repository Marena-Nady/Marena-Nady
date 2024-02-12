package Pages;

import com.shaft.driver.SHAFT;

public class P02_Home {
    SHAFT.GUI.WebDriver driver;
    public P02_Home(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }
    public void successfulLoginValidation()
    {
        driver.assertThat().browser().url().isEqualTo("https://www.saucedemo.com/inventory.html").perform();

    }

}
