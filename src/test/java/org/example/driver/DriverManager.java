package org.example.driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

// reusable/duplicated method to be used in different class

public class DriverManager {

    public static WebDriver driver;
    String browser = "chrome";
    String baseUrl = "https://demo.nopcommerce.com/";

    public DriverManager() {       //constructor
        PageFactory.initElements(driver, this);
    }

    public void runFromLocalBrowser() throws IllegalAccessException {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalAccessException("Unexpected browser");
        }
    }

    public void runInHeadlessMode() throws IllegalAccessException {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                chromeOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("headless", true);
                driver = new EdgeDriver(edgeOptions);
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                firefoxOptions.addArguments("--window-size=1920,1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new IllegalAccessException("Unexpected browser");
        }

    }

    public void maxBrowser() {
        driver.manage().window().maximize();
    }

    public void applyImplicitlywait() {

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void sleepBrowser(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    public void goToUrl() {
        driver.get(baseUrl);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement waitUntilElementIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public static String getRandomString(int length) {
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();

        while (length > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            length--;
        }
        return result.toString();
    }

    public void waitForElementVisibility(WebElement element, int timeout, String failureMessage) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(failureMessage);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //take element screenshot is from selenium 4.0 and is more for visual regression or screenshot comparison for
    // UI layout,lookandfill,font,colour, etc
    public void takeElementScreenshot(WebElement element, String fileName) {
        File scnFile = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scnFile, new File("./target/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(Scenario scenario) {

        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot, "image/png");
        //take a screenshot when scenario is failed
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("/Users/apple/Desktop/screenshotTests/Error.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//Users/apple/Desktop/screenshotTests
    //Users/apple/Desktop/screenshotTests
}

