package StepDefination;

import Pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDef {
    private P03_homePage home;
    @Given("initialize Search feature")
    public void init(){
        home=new P03_homePage(Hooks.driver);
    }
    @When("^user types \"(.*)\"$")
    public void enterProductName(String productName){
        home.searchField().sendKeys(productName);
    }
    @And("clicks on search")
    public void clickOnSearch() throws InterruptedException {
        home.searchBtn().click();
        Thread.sleep(1000);
    }
    @Then("^user should find the \"(.*)\"$")
    public void checkSearchResult(String productName){
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(home.getUrl().contains("https://demo.nopcommerce.com/search?q="));
        int i=0;
        List<WebElement> actualResults = home.getResults();
        System.out.println("Number of search results: "+actualResults.size());
        for (WebElement actualResult : actualResults){
            System.out.println(actualResults.get(i).getText().toLowerCase());
            soft.assertTrue(actualResults.get(i).getText().toLowerCase().contains(productName));
            i++;
        }
        soft.assertAll();
    }

    @When("^user types \"(.*)\" as product sku$")
    public void enterProductSku(String productSku){
        home.searchField().sendKeys(productSku);
    }


    @Then("^user should find the \"(.*)\" as product sku$")
    public void checkSkuSearchResult(String productSku){
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(home.getUrl().contains("https://demo.nopcommerce.com/search?q="));
        List<WebElement> actualResults=home.getResults();
        if(actualResults.size()==1){/*if the results are only one item navigate to this item's url and do the
            assertion*/
            Hooks.driver.navigate().to(home.getProductSkuUrl(home.getResults().get(0)));
            List<WebElement> actualTitlesElements =home.getProductTitlesElements();
            for(WebElement actualTitlesElement : actualTitlesElements) {
                if (actualTitlesElement.getAttribute("class").toString().contains("value")) {
                    soft.assertTrue(actualTitlesElement.getText().contains(productSku));
                }
            }
        }
        else {
            /*do nothing*/
        }

        soft.assertAll();



    }
}
