package tests.chrome;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.SamokatMainPage;

import static org.junit.Assert.assertEquals;

public class SamokatTest {

     private WebDriver driver;

    @Test
    public void checkOpenOrderPageFromHeaderOrderBtn() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatMainPage samokatMainPage = new SamokatMainPage(driver);
        samokatMainPage.cookieAcceptClick();
        samokatMainPage.headerOrderBtnClick();
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void checkOpenOrderPageFromPageOrderBtn() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatMainPage samokatMainPage = new SamokatMainPage(driver);
        samokatMainPage.cookieAcceptClick();
        samokatMainPage.finishOrderBtnClick();
        Thread.sleep(1000);
        driver.quit();

}
}