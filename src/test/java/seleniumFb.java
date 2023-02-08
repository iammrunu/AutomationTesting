//import graphql.Assert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//import static graphql.Assert.*;

public class seleniumFb
{
  public static void main(String[] args) throws InterruptedException
  {
      WebDriver chromeDriver= new ChromeDriver();
      //Implicit Wait---For Driver(Browser)
      chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
      chromeDriver.get("http://google.com");
      chromeDriver.manage().window().maximize();
      //Thread.sleep(1000);
     // chromeDriver.navigate().to("https://www.facebook.com/");

      //Explicit Wait----for particular element.
      chromeDriver.findElement(By.name("q")).sendKeys("w3schools");
      chromeDriver.findElement(By.className("gNO89b")).click();
      WebDriverWait explicitWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(40));
      explicitWait.until(ExpectedConditions.elementToBeClickable(By.linkText("JavaScript Tutorial")));

      chromeDriver.findElement(By.linkText("JavaScript Tutorial")).click();
     // WebElement e= chromeDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/table/tbody/tr[3]/td/div/h3/a"));

     /* String expectedTitle= "Facebook - log in or sign up";
      String actualTitle= chromeDriver.getTitle();
      Assert.assertEquals("The Title is not expected",expectedTitle,actualTitle);
      //condition to check fb logo is exists
      boolean isLeblePresent = chromeDriver.findElement(By.className("fb_logo")).isDisplayed();*/
      //display an error message fb logo does not exist

      //boolean isLablePresnt = false;
      //Assert.assertTrue("Lable is not present",isLablePresnt);

      //Thread.sleep(1000);
     // chromeDriver.navigate().back();
      chromeDriver.close();


  }
}
