package tests.firefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.SamokatMainPage;

import static org.junit.Assert.assertEquals;

public class SamokatTest {

     private WebDriver driver;

    @Test
    public void checkTextFromDropDownFAQ() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        SamokatMainPage samokatMainPage = new SamokatMainPage(driver);
        samokatMainPage.cookieAcceptClick();
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        samokatMainPage.clickBtnDropDownHowPriceHowPayFAQ();
        Thread.sleep(3000);
        String actualResult = samokatMainPage.getTextDropDownHowPriceHowPayFAQText();
        String expectedResult = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    @Test
    public void checkOpenOrderPageFromHeaderOrderBtn() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        SamokatMainPage samokatMainPage = new SamokatMainPage(driver);
        samokatMainPage.cookieAcceptClick();
        samokatMainPage.headerOrderBtnClick();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void checkOpenOrderPageFromPageOrderBtn() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        SamokatMainPage samokatMainPage = new SamokatMainPage(driver);
        samokatMainPage.cookieAcceptClick();
        samokatMainPage.finishOrderBtnClick();
        Thread.sleep(3000);
        driver.quit();

}
}