package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.sql.Timestamp;
import static driver.DriverFactory.cleanupDriver;
import static driver.DriverFactory.getDriver;

public class Hooks  {

    public WebDriver driver;

    @Before
    public void setup() {
            getDriver();
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }

    @AfterStep

    public void captureExceptionImage(Scenario scenario){
        if(scenario.isFailed()){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
           String timeMilliseconds =  Long.toString(timestamp.getTime());

           byte[] screenshot = ((TakesScreenshot) getDriver())
                   .getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot,"image/jpg",timeMilliseconds);


        }

    }
}
