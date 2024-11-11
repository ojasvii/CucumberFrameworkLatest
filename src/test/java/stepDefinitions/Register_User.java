package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.Base_PO;

import java.util.List;

public class Register_User extends Base_PO {


    @Given("the user launches the browser")
    public void the_user_launches_the_browser() {
        System.out.println("Launch browser");
    }
    @When("the user navigates to the url {string}")
    public void the_user_navigates_to_the_url(String url) {
       navigateTo_URL(url);
    }

    @Then("the home page should be visible successfully")
    public void the_home_page_should_be_visible_successfully() {
       String homeText = getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")).getText();
        Assert.assertEquals(homeText,"Home");
        System.out.println(homeText);
    }
    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String signupLogin) {
        WebElement signup = getDriver().findElement(By.xpath("//header[@id='header']/div/div/div/div[2]/div/ul/li[4]"));
       signup.click();

    }
    @Then("{string} should be visible")
    public void should_be_visible(String newUserText) {
        WebElement newUserSignUp = getDriver().findElement(By.xpath("//div[@class='signup-form']/h2"));
        String actualNewUserSignUp = newUserSignUp.getText().trim();  // Trim whitespace
        if (actualNewUserSignUp.contains("!")) {
            actualNewUserSignUp = actualNewUserSignUp.substring(0, actualNewUserSignUp.indexOf('!') + 1); // Extract up to '!'
        }
        System.out.println("NewuserSignUp: " + actualNewUserSignUp);
        Assert.assertEquals(actualNewUserSignUp, newUserText);
    }
    @When("Enter name and email address")
    public void enter_name_and_email_address() {
        WebElement name = getDriver().findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("ojasvii");


        WebElement email = getDriver().findElement(By.xpath("//div[@class='signup-form']//input[@name='email']"));
        email.sendKeys("sdet@team.com");

    }
    @When("Click signup {string} button")
    public void click_signup_button(String string) {
        WebElement button = getDriver().findElement(By.xpath("//div[@class='signup-form']//button"));
        button.click();
    }
    @Then("Verify that {} should be visible")
    public void verify_that_should_be_visible(String information) {
        WebElement accountInformationForm = getDriver().findElement(By.xpath("(//div[@class='login-form']//b)[1]"));
        String  aif  = accountInformationForm.getText();
        Assert.assertEquals(aif,information);
    }


    @When("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        WebElement title = getDriver().findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        title.click();

        WebElement name = getDriver().findElement(By.xpath("//input[@id='name']"));
        if(name.isEnabled()){
            name.clear();
            name.sendKeys("ojasvii");
        }



        WebElement email = getDriver().findElement(By.xpath("//input[@id='email']"));
        if(email.isEnabled()){
            email.clear();
            email.sendKeys("sdet@team.com");
        }


        WebElement passwrod = getDriver().findElement(By.xpath("//input[@id='password']"));
        passwrod.clear();
        passwrod.sendKeys("sdet@team.com");

        WebElement days = getDriver().findElement(By.xpath("//select[@id='days']"));

        Select select = new Select(days);
        select.selectByIndex(18);

        WebElement months = getDriver().findElement(By.xpath("//select[@id='months']"));

        Select select2 = new Select(months);
        select2.selectByIndex(1);

        WebElement year = getDriver().findElement(By.xpath("//select[@id='uniform-years']"));

        Select select3 = new Select(year);
        select3.selectByIndex(18);

    }
    @When("Select checkbox {string}")
    public void select_checkbox(String string) {
        WebElement newLetter = getDriver().findElement(By.xpath("//input[@id='newsletter']"));
        newLetter.click();

       WebElement offer = getDriver().findElement(By.xpath("//input[@id='optin']"));
       offer.click();
    }

    @When("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {

    }
    @When("Click {string}")
    public void click(String string) {

    }
    @When("Click on {string} button after account created")
    public void click_on_button_after_account_created(String string) {

    }
    @When("Click delete {string} button")
    public void click_delete_button(String string) {

    }
    @Then("click continue {string} button after account deleted")
    public void click_continue_button_after_account_deleted(String string) {

    }


}
