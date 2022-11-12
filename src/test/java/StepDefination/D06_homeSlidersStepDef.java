package StepDefination;

import Pages.P03_homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class D06_homeSlidersStepDef {
    private P03_homePage home;
    private String expectedNokiaUrl="https://demo.nopcommerce.com/nokia-lumia-1020";
    private String expectedIPhoneUrl="https://demo.nopcommerce.com/iphone-6";

    @Given("initialize slider feature")
    public void init() {
        home = new P03_homePage(Hooks.driver);
    }


    @When("user select Nokia picture")
    public void userSelectNokiaPicture() {

        Hooks.driver.navigate().to(home.selectSliderPicture("nokia"));
    }
    @Then("user should navigate to Nokia page")
    public void checkOnNokiaUrl(){
        Assert.assertEquals(home.getUrl(),expectedNokiaUrl);
    }

    @When("user select iphone picture")
    public void userSelectIphonePicture() {

        Hooks.driver.navigate().to(home.selectSliderPicture("iphone"));
    }
    @Then("user should navigate to iphone page")
    public void checkOnIphoneUrl(){
        Assert.assertEquals(home.getUrl(),expectedIPhoneUrl);
    }
}
