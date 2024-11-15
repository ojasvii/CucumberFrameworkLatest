package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;

public class LoginUserValid extends Base_PO {


    @Given("Launch browser")
    public void launch_browser() {
        System.out.println("Browser opened");
    }

    @Given("Navigate to the automation exercise url")
    public void navigate_to_the_automation_exercise_url() {
        navigateTo_URL("http://automationexercise.com");
    }
    @Then("Verify that the home page is visible successfully")
    public void verify_that_the_home_page_is_visible_successfully() {
         String homeText = getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")).getText();
        Assert.assertEquals(homeText,"Home");
        System.out.println(homeText);
    }
    @When("Click on the signup login button")
    public void click_on_the_signup_login_button() {
        WebElement signup = getDriver().findElement(By.xpath("//header[@id='header']/div/div/div/div[2]/div/ul/li[4]"));
        signup.click();
    }
    @Then("Verify login to your account is visible")
    public void verify_login_to_your_account_is_visible() {
        WebElement loginTextHeader = getDriver().findElement(By.xpath("//div[@class='login-form']/h2"));
        String loginAccount = loginTextHeader.getText();
        Assert.assertEquals(loginAccount,"Login to your account");
    }
    @When("Enter correct email address and password")
    public void enter_correct_email_address_and_password() {
       WebElement email= getDriver().findElement(By.xpath("//div[@class='login-form']/form//input[@name='email']"));
    email.sendKeys("ojas@team.com");

    WebElement pass = getDriver().findElement(By.xpath("//div[@class='login-form']/form//input[@name='password']"));
        pass.sendKeys("sdet@team.com");
    }

    @Then("Verify the logged in as username is visible")
    public void verify_the_logged_in_as_username_is_visible() {

    }
    @When("click delete account button")
    public void click_delete_account_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify that the account delete is visible")
    public void verify_that_the_account_delete_is_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Enter incorrect email address and password")
    public void enter_incorrect_email_and_password(){
        WebElement email= getDriver().findElement(By.xpath("//div[@class='login-form']/form//input[@name='email']"));
        email.sendKeys("ojas@team.com");

        WebElement pass = getDriver().findElement(By.xpath("//div[@class='login-form']/form//input[@name='password']"));
        pass.sendKeys("sdet@team.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("click on the login button")
    public void click_on_the_login_button() {
        WebElement loginButton = getDriver().findElement(By.xpath("//div[@class='login-form']//button"));
        System.out.println("Found the login button");
        loginButton.click();
        System.out.println("Clicked on login button");
    }

    @Then("Verify error your email or password is incorrect is visible")
    public void verify_error_your_email_or_password_is_incorrect_is_visible (){
        WebElement errorMessage =  getDriver().findElement(By.xpath("//div[@class='login-form']//p"));
        try {
            Thread.sleep(5000);
            String error = errorMessage.getText();
            Assert.assertEquals(error,"Your email or password is incorrect!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
