package StepDefination;

import Pages.P03_homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {
    private P03_homePage home;

    @Given("initialize follow us feature")
    public void init() {
        home = new P03_homePage(Hooks.driver);
    }

    @When("^user clicks \"(.*)\"$")
    public void clickOnIcon(String icon) {
        home.goToFollowUs(icon);
    }

    @Then("^user should go to selected \"(.*)\"$")
    public void checkOnUrl(String url) throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        if (!url.contains("new-online")) {
            Hooks.driver.switchTo().window(tabs.get(1));
        } else {
            Hooks.driver.switchTo().window(tabs.get(0));
        }
        Assert.assertEquals(home.getUrl(), url);
    }
}
