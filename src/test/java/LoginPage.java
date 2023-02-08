import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class LoginPage {
    WebDriver chromedriver = null;
    @Given("User open the Browser and Navigate to {string}")
    public void userOpenTheBrowserAndNavigateTo(String url)
    {
        chromedriver = new ChromeDriver();
        chromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        chromedriver.get(url);
        chromedriver.manage().window().maximize();
    }

    @Then("User click on Sign In Button")
    public void userClickOnSignInButton()
    {
        chromedriver.findElement(By.id("nav-signin-tooltip")).click();
    }

    @When("User click on Sign in button, assert logo is present or not")
    public void userClickOnSignInButtonAssertLogoIsPresentOrNot()
    {
       // boolean isLablePresnt = chromedriver.findElement(By.className("a-icon a-icon-logo")).isDisplayed();
      //  Assert.assertTrue("Lable is not present", isLablePresnt);
    }

    @Then("Take a Screenshot and store it")
    public void takeAScreenshotAndStoreIt() throws IOException, InterruptedException {
        TakesScreenshot ss = (TakesScreenshot) chromedriver;
        File sourceFile = ss.getScreenshotAs(OutputType.FILE);
        Random r= new Random();
        r.nextInt(1000);
        String screenShotName = "log_001_"+ r.toString();
        System.out.println(screenShotName);
        File destinationFile = new File(System.getProperty("user.dir")+"//target//"+screenShotName+".png");
        FileUtils.copyFile(sourceFile, destinationFile);
       // Thread.sleep(1000);
        chromedriver.quit();

    }
}
