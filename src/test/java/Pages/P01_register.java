package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P01_register {
    private WebDriver driver ;

    public P01_register(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //select registration page from main pge
    public void goToRegisterPage() {
        driver.findElement(By.cssSelector("a[class=\"ico-register\"]")).click();
    }

    //    select your gender
    public void selectGender(String gender) {
        if ((gender.equals("female")) || (gender.equals("Female"))) {
            driver.findElement(By.cssSelector("input[id=\"gender-female\"]")).click();
        } else if ((gender.equals("male")) || (gender.equals("Male"))) {
            driver.findElement(By.cssSelector("input[id=\"gender-male\"]")).click();
        } else {
            System.out.println("Please select your gender");
        }

    }

    public WebElement enterFirstName() {
        driver.findElement(By.cssSelector("input[id=\"FirstName\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"FirstName\"]"));
    }

    public WebElement enterLastName() {
        driver.findElement(By.id("LastName")).clear();
        return driver.findElement(By.id("LastName"));
    }

    public WebElement enterEmail() {
        driver.findElement(By.id("Email")).clear();
        return driver.findElement(By.id("Email"));
    }

    public WebElement enterCompany() {
        driver.findElement(By.id("Company")).clear();
        return driver.findElement(By.id("Company"));
    }

    public WebElement enterPassword() {
        driver.findElement(By.cssSelector("input[id=\"Password\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"Password\"]"));
    }

    public WebElement enterConfirmPassword() {
        driver.findElement(By.cssSelector("input[id=\"ConfirmPassword\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"ConfirmPassword\"]"));
    }

    public void pressRegisterButton() {
        driver.findElement(By.cssSelector("button[id=\"register-button\"]")).click();
    }

    public WebElement getEmailExistMessage() {
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }

    public WebElement getRegistrationMessageCompilation() {
        return driver.findElement(By.cssSelector("div[class=\"result\"]"));
    }

    public WebElement getConfirmPasswordError() {
        return driver.findElement(By.cssSelector("span[id=\"ConfirmPassword-error\"]"));
    }


    public WebElement getActualErrorMessages(int i) {
        switch (i) {
            case 0:
                return driver.findElement(By.cssSelector("span[id=\"FirstName-error\"]"));
            case 1:
                return driver.findElement(By.cssSelector("span[id=\"LastName-error\"]"));
            case 2:
                return driver.findElement(By.cssSelector("span[id=\"Email-error\"]"));
            case 3:
                return driver.findElement(By.cssSelector("span[id=\"Password-error\"]"));
            case 4:
                return getConfirmPasswordError();
        }
        return null;
    }
    public void setBirthday(String day, String month, String year){
        Select select=new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]")));
        select.selectByIndex(Integer.parseInt(day));
        select=new Select( driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]")));
        select.selectByValue(month);
        select= new Select( driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]")));
        select.selectByVisibleText(year);

    }
}
