package StepDefination;

import Pages.P03_homePage;
import Pages.P02_login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login login ;
    P03_homePage homepage;


    @Given("user navigate to login page")
    public void navigatesToLoginPage() throws InterruptedException {
        login= new P02_login(Hooks.driver);
        homepage= new P03_homePage(Hooks.driver);
        homepage.goToLoginPage();
        Thread.sleep(1000);
    }
    @When("^enter email \"(.*)\" and password \"(.*)\"$")
    public void validData(String email , String Password) throws InterruptedException {


        login.EnterEmail().sendKeys(email);

        login.EnterPass().sendKeys(Password);
        Thread.sleep(1000);

    }
    @When("user press forget password")
    public void pressForgetPassword(){
        login.pressForgetPassword();

    }
    @And("^user enter email \"(.*)\"$")
    public void enterEmail(String email){
        login.EnterEmail().sendKeys(email);
    }
    @And("user press login")
    public void pressLogin(){
        login.pressLoginButton();
    }
    @And("user press recover button")
    public void pressRecoverButton() throws InterruptedException {
        login.pressRecoverBtn();
        Thread.sleep(2000);
    }
    @Then("user go to home page")
    public void checkOnLogin(){
        SoftAssert soft =new SoftAssert();
        String actualResult=homepage.checkMyAccountIcon();
        String expectedResult="My account";
        soft.assertEquals(homepage.getUrl(),"https://demo.nopcommerce.com/");
        soft.assertTrue(expectedResult.equals(actualResult));
        soft.assertAll();
    }
    @Then("user logout")
    public void checkLoginStatus(){
        homepage.logout();
    }

    @Then("check on error message")
    public void checkOnInvalidLogin(){
        SoftAssert soft =new SoftAssert();
        String actualResult=login.getLoginErrorMessage().getText();
        String actualMessageColor=login.getLoginErrorMessage().getCssValue("color");
        String expectedResult="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String expectedMessageColor="rgba(228, 67, 75, 1)";
        soft.assertTrue(actualResult.equals(expectedResult));
        soft.assertTrue(actualMessageColor.equals(expectedMessageColor));
        soft.assertAll();
    }
    @Then("check on email error message")
    public void checkOnEmailErrorMessage(){
        String actualResult=Hooks.driver.findElement(By.cssSelector("span[id=\"Email-error\"]")).getText();
        String expectedResult="Wrong email";
        System.out.println(actualResult);
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Then("user gets instructions message has been sent")
    public void checkOnResetPasswordMessage(){
        String actualResult = login.getRecoveryMessage().getText();
        String expectedResult="Email with instructions has been sent to you.";
        Assert.assertTrue(expectedResult.contains(actualResult));
    }


}
