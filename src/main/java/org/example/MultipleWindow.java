package org.example;

//test changes
//import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

public class MultipleWindow {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver chromeDriver = new ChromeDriver();
        //WebDriver edgeBrowser = new InternetExplorerDriver();
        //WebDriver firefoxDriver = new FirefoxDriver();
        //Implicit Wait---For Driver(Browser)
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        chromeDriver.get("http://google.com");
        chromeDriver.manage().window().maximize();
        //JavascriptExecutor js = (JavascriptExecutor) chromeDriver;

       // js.executeScript("window.open()");
       // js.executeScript("window.open()");
       chromeDriver.switchTo().newWindow(WindowType.TAB);
        chromeDriver.switchTo().newWindow(WindowType.TAB);
        chromeDriver.switchTo().newWindow(WindowType.TAB);
        Set<String> whs = chromeDriver.getWindowHandles();

        chromeDriver.switchTo().window(whs.toArray()[2].toString());
        chromeDriver.get("http://facebook.com");
        TakesScreenshot ss= (TakesScreenshot) chromeDriver;
        File sourceFile= ss.getScreenshotAs(OutputType.FILE);
        //File destinationFile = new File("C:\\Users\\mrunu\\OneDrive\\Pictures\\Screenshot1.jpg");
       // FileUtils.copyFile(sourceFile, destinationFile);

        chromeDriver.switchTo().window(whs.toArray()[3].toString());
        chromeDriver.get("https://www.walmart.com/");
        chromeDriver.switchTo().window(whs.toArray()[1].toString());
        chromeDriver.get("https://www.amazon.com/");
        Thread.sleep(4000);


        //Scrrenshots for randam number
        Random r = new Random();
        r.nextInt(1000);
        String screenshotName = "SC_001_"+ r.toString();
        System.out.println(screenshotName);
        File destinationFile = new File(System.getProperty("user.dir")+"//src//"+screenshotName+".png");
        FileUtils.copyFile(sourceFile, destinationFile);
       // Thread.sleep(10000);
        chromeDriver.quit();
    }
}
