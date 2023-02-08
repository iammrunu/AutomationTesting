import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class Screenshot {
    WebDriver chromeDriver = null;
    @Given("User open the browser and navigate to {string}")
    public void userOpenTheBrowserAndNavigateTo(String url)
    {
        chromeDriver= new ChromeDriver();
        //Implicit Wait---For Driver(Browser)
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        chromeDriver.get(url);
        chromeDriver.manage().window().maximize();
    }

    @Then("User enter {string}")
    public void userEnter(String searchString)
    {
        chromeDriver.findElement(By.name("q")).sendKeys(searchString);
    }

    @Then("User click the google search button")
    public void userClickTheGoogleSearchButton()
    {
        chromeDriver.findElement(By.className("gNO89b")).click();
    }

    @When("User click on search button result should displayed")
    public void userClickOnSearchButtonResultShouldDisplayed() {

    }

    @Then("User select or click JavaScript Tutorial")
    public void userSelectOrClickJavaScriptTutorial()
    {
        WebDriverWait explicitWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(40));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.linkText("JavaScript Tutorial")));
        chromeDriver.findElement(By.linkText("JavaScript Tutorial")).click();
    }

    @When("User click JavaScript Tutorial assert JavaScript Tutorial is loaded or not")
    public void userClickJavaScriptTutorialAssertJavaScriptTutorialIsLoadedOrNot()
    {
        /*WebElement e= chromeDriver.findElement(By.xpath("/html/body/div[8]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/table/tbody/tr[4]/td/div/h3"));
        boolean isLeblePresent = e.isDisplayed();
        boolean isLablePresnt = false;
        Assert.assertTrue("Lable is not present",isLablePresnt);
       String expectedTitle= "JavaScript Tutorial";
        String actualTitle= chromeDriver.getTitle();
        Assert.assertEquals("The Title is not expected",expectedTitle,actualTitle);*/

    }

    @Then("User take screenshot and stored it")
    public void userTakeScreenshotAndStoredIt() throws IOException {
        TakesScreenshot ss= (TakesScreenshot) chromeDriver;
        File sourceFile= ss.getScreenshotAs(OutputType.FILE);
        Random r = new Random();
        r.nextInt(1000);
        String screenshotName = "SC_001_"+ r.toString();
        System.out.println(screenshotName);
        File destinationFile = new File(System.getProperty("user.dir")+"//src//"+screenshotName+".png");
        FileUtils.copyFile(sourceFile, destinationFile);
        chromeDriver.quit();
    }


}
