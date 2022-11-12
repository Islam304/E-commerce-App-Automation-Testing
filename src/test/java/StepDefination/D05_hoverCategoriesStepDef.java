package StepDefination;

import Pages.P03_homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class D05_hoverCategoriesStepDef {
    private P03_homePage home;

    @Given("initialize hover to categories feature")
    public void init() {
        home = new P03_homePage(Hooks.driver);
    }

    @When("user select random category he should go its page")
    public void selectRandomCategory() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        String expectedTitle=null;
        List<WebElement> categories = home.getCategoriesWebElm();
        int count = categories.size();
        int min = 0;
        int max = count - 1;   //  selecting random value from 0 to size that's why  max = count-1
        int selectedMainCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
        action.moveToElement(categories.get(selectedMainCategory)).perform();
        Thread.sleep(2000);
        if(home.getSubCategoriesWebElm(selectedMainCategory).isEmpty()){
            expectedTitle= categories.get(selectedMainCategory).getText();
            home.navigateToCategory(categories.get(selectedMainCategory));
            Assert.assertEquals(home.getPageTitle(),expectedTitle);
        }
        else {
            //return list of all main sub-categories web element "sublist first-level"
            List<WebElement> subCategories= home.getSubCategoriesWebElm(selectedMainCategory);
            count = subCategories.size();
            max = count - 1;   // you are selecting random value from 0 to 2 that's why  max = count-1
            int selectedSub = (int) Math.floor(Math.random() * (max - min + 1) + min);
            System.out.println(count);
            System.out.println(selectedSub);

            if(home.getSubCategoryTitle(subCategories.get(selectedMainCategory),selectedSub)!=null){
                expectedTitle = home.getSubCategoryTitle(subCategories.get(selectedMainCategory),selectedSub);
                System.out.println(expectedTitle);

            }
            home.navigateToSubCategory(subCategories.get(selectedMainCategory),selectedSub);
            System.out.println(home.getPageTitle());
            Assert.assertTrue(expectedTitle.contains(home.getPageTitle().toLowerCase()));
        }
    }
}
