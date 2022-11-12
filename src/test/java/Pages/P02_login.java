package Pages;

import StepDefination.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class P02_login {

WebDriver driver;
    public P02_login(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
public WebElement EnterEmail()
{
      driver.findElement(By.id("Email")).clear();
      return driver.findElement(By.id("Email"));
}
    public WebElement EnterPass(){
        driver.findElement(By.id("Password")).clear();
        return driver.findElement(By.id("Password"));
    }
    public void pressLoginButton(){
        driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]")).click();
    }
    public WebElement getLoginErrorMessage(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));

    }

    public void pressRecoverBtn(){
        driver.findElement(By.cssSelector("button[name=\"send-email\"]")).click();
    }
    public WebElement getRecoveryMessage(){
        return driver.findElement(By.cssSelector("p[class=\"content\"]"));
    }
    public void pressForgetPassword(){
        driver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"]")).click();
    }
}


