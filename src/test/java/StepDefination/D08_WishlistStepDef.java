package StepDefination;

import Pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDef {
    private P03_homePage home;
    private String[] productsName={"Apple MacBook Pro 13-inch","HTC One M8 Android L 5.0 Lollipop"};
    @Given("initialize wish list feature")
    public void init() {
        home = new P03_homePage(Hooks.driver);
    }
    @When("user select to add HTC phone to wish list")
    public void addProductToWishList() throws InterruptedException {
        //adding htc phone
        home.addProductToWishList(productsName[1]);


    }
    @Then("user should get a success message")
    public void checkOnAddToWishMessage(){
        SoftAssert soft= new SoftAssert();
        String actualMessageText= home.getAddToWishListMessageText();
        String actualMessageBackGroundColor = home.getAddToWishListMessageBackGroundColor();
        String expectedText="The product has been added to your wishlist";
        String expectedColor="rgba(75, 176, 122, 1)";
        soft.assertTrue(expectedText.equals(actualMessageText));
        soft.assertTrue(expectedColor.equals(actualMessageBackGroundColor));
        soft.assertAll();

    }
    @And("click on wish list")
    public void clickOnWishList() throws InterruptedException {
        Thread.sleep(6000);
        home.goToWishList();

    }
    @Then("user should find the product")
    public void checkOnProduct(){
        //Assert htc phone
        System.out.println(home.findProductQty(productsName[1]));
        Assert.assertTrue(home.findProductQty(productsName[1])>0);


    }
}
