package tests.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.SamokatMainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParamAccordionTest {

    private final String actualResult;
    private final String expectedResult;
    private final String locator;

    public ParamAccordionTest(String locator,String actualResult, String expectedResult){
        this.locator = locator;
        this.actualResult = actualResult;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {".//div[@id='accordion__heading-0']",".//div[@id='accordion__panel-0']/p", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {".//div[@id='accordion__heading-1']",".//div[@id='accordion__panel-1']/p", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}

        };
    }


    private WebDriver driver;

    @Test
    public void checkTextFromDropDownFAQ() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatMainPage samokatMainPage = new SamokatMainPage(driver);
        samokatMainPage.cookieAcceptClick();
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(locator)).click();
        Thread.sleep(500);
        String result = driver.findElement(By.xpath(actualResult)).getText();
        assertEquals(result,expectedResult);
        driver.quit();
    }

}
