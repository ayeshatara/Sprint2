package steps;

import Pages.CartPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserManager;
import utils.QAprops;
import utils.TestDataReader;
import java.util.HashMap;

public class StepDefinition {
    private WebDriver driver;
    CartPage cartPage;
    public String url,url1;
    HashMap<String,String>data;
    Scenario scenario;
    @Before(order = 1)
    public void before(Scenario scenario){
        this.scenario=scenario;
    }
    public  StepDefinition(BrowserManager browserManager){
        this.driver= browserManager.getDriver();
    }


   @Given("The user navigate to home page.")
    public void the_user_navigate_to_home_page() {
        url= QAprops.getValue("url");
        driver.get(url);
       data= TestDataReader.getData(scenario.getName());
    }
    @When("The user goes to login page.")
    public void the_user_goes_to_home_page() {
        cartPage=new CartPage(driver);
        cartPage.getSignIn().click();

    }
    @And("Enters valid credentials.")
    public void entersValidCredentials() {
        cartPage.getMobNumber().sendKeys(data.get("userEnter"));
        cartPage.getSubmitNum().click();
        cartPage.getPassword().sendKeys(data.get("password"));//data.get("password")
        cartPage.getSubmitPass().click();
    }

    @Then("The user should Logged-in Successfully.")
    public void theUserShouldLoggedInSuccessfully() {
        String text = cartPage.getRetrieveText().getText();
        Assert.assertEquals(text,"Hello, Ayesha");
 }

    @Given("The user navigate to the home page.")
    public void theUserNavigateToTheHomePage() {
        url= QAprops.getValue("url");
        driver.get(url);
    }

    @When("The user enters Product Name.")
    public void theUserEntersProductName() {
        cartPage=new CartPage(driver);
        WebElement element= cartPage.getSearchBox();
        element.sendKeys("Lipstick");
        element.sendKeys(Keys.ENTER);
    }

    @Then("The user should get entered product result.")
    public void theUserShouldGetEnteredProductResult() {
        String text = cartPage.getRetrieveProduct().getText();
        Assert.assertEquals(text,"\"Lipstick\"");
    }
    @Test(priority = 2)
    @Given("The user navigate to selected product page.")
    public void theUserNavigateToSelectedProductPage() throws InterruptedException {
        url1= QAprops.getValue("url1");
        driver.get(url1);
        Thread.sleep(4000);
    }

    @When("User selects the quantity of the product")
    public void userSelectsTheQuantityOfTheProduct() {
        cartPage=new CartPage(driver);
        Select dropDown = new Select(cartPage.getDropDown());
        dropDown.selectByIndex(2);
    }
    @And("Clicks to the Add_To_Cart Button.")
    public void clicksToTheAdd_To_CartButton() {
        cartPage.getAddToCartButton().click();
    }
    @Then("The message Added To Cart should displayed.")
    public void theMessageShouldDisplayed() {
        String text=cartPage.CartText.getText();
        Assert.assertEquals(text,"Added to Cart");
    }

    @Given("The user goes to selected product page.")
    public void theUserGoesToSelectedProductPage() {
        url1= QAprops.getValue("url1");
        driver.get(url1);
    }

    @When("The user checks the stock updates.")
    public void theUserChecksTheStockUpdates() {
        cartPage=new CartPage(driver);
        String text = cartPage.getInStockText().getText();
     }

    @Then("The message In Stock or Out Of Stock should display.")
    public void theMessageInStockOrOutOfStockShouldDisplay() {
        String text = cartPage.getInStockText().getText();
        Assert.assertEquals(text,"In stock");
    }

    @Given("User navigate to product page.")
    public void userNavigateToProductPage() {
    url1= QAprops.getValue("url1");
    driver.get(url1);
    }

    @When("Click On Review Link.")
    public void clickOnReviewLink() {
        cartPage = new CartPage(driver);
        cartPage.getReviewLink().click();
    }

    @And("Click On Images with Review.")
    public void clickOnImagesWithReview() throws InterruptedException {
        CartPage review = new CartPage(driver);
        cartPage.getReviewImage().click();
        Thread.sleep(4000);
    }

    @Then("Reviews with Images page should get open.")
    public void reviewsWithImagesPageShouldGetOpen() {
        String text =cartPage.getReviewText().getText();
        Assert.assertEquals(text,"Reviews with images");
    }

    @Given("User navigate to the product page.")
    public void userNavigateToTheProductPage() {
        url1= QAprops.getValue("url1");
        driver.get(url1);
    }

    @When("check the delivery charges update.")
    public void checkTheDeliveryChargesUpdate() {
        cartPage=new CartPage(driver);
    }

    @Then("Either Free Delivery or Shipping charges should visible.")
    public void eitherFreeDeliveryOrShippingChargesShouldVisible() {
        String text =cartPage.getDeliveryCharge().getText();
        Assert.assertEquals(text,"FREE delivery");
    }

    @Given("User navigates to product page.")
    public void userNavigatesToProductPage() {
    url1= QAprops.getValue("url1");
    driver.get(url1);
    }

    @When("Click Add address Link.")
    public void clickAddAddressLink() {
        cartPage=new CartPage(driver);
        cartPage.getAddressLink().click();
    }

    @Then("Choose your Location page should display.")
    public void chooseYourLocationPageShouldDisplay() {
        String text = cartPage.getAddressText().getText();
        Assert.assertEquals(text,"Choose your location");

    }

    @Given("The user goes to the home page.")
    public void theUserGoesToTheHomePage() throws InterruptedException {
        url= QAprops.getValue("url");
        driver.get(url);
    }

    @When("The user navigates to sing in page.")
    public void theUserNavigatesToSingInPage() throws InterruptedException {
        cartPage=new CartPage(driver);
        cartPage.getSignIn().click();
    }

    @And("enter {string}")
    public void enter(String phoneNumber) throws InterruptedException {
        cartPage.getMobNumber().sendKeys(phoneNumber);
        cartPage.getSubmitNum().click();
    }

    @Then("Error {string} should Displayed.")
    public void errorMessageShouldDisplayed(String EMessage) {
        String text=cartPage.getErrorText().getText();
       Assert.assertEquals(text,"Incorrect phone number");
    }
}
