package tests.firefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.OrderPageFirst;
import pages.OrderPageSecond;
import pages.SamokatMainPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

public class CreateOrderTest {

    private WebDriver driver;

    @Test
    public void e2eCreationOrderTest() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        SamokatMainPage samokatMainPage = new SamokatMainPage(driver);
        samokatMainPage.cookieAcceptClick();
        samokatMainPage.headerOrderBtnClick();
        Thread.sleep(1000);
        OrderPageFirst orderPageFirst = new OrderPageFirst(driver);
        orderPageFirst.setNameToFieldNameOrderPage("Вася");
        orderPageFirst.setSurnameToFieldSurnameOrderPage("Пупкин");
        orderPageFirst.setOrderPageDeliveryAddressToFieldDeliveryAddressOrderPage("На красную площадь");
        orderPageFirst.orderPageMetroStationDropDownClick();
        orderPageFirst.orderPageMetroStationKomsomolskayaClick();
        orderPageFirst.setOrderPagePhoneNumberField("88005553535");
        orderPageFirst.orderPageNextStepBtnClick();
        OrderPageSecond orderPageSecond = new OrderPageSecond(driver);
        orderPageSecond.setDeliveryDateToDeliveryDateField("01.01.2999");
        orderPageSecond.orderPageRentalPeriodFieldClick();
        orderPageSecond.orderPageRentalPeriodDropDownMenuClick();
        orderPageSecond.orderPageSamokatColourBlackCheckboxClick();
        orderPageSecond.setOrderPageCommentCourier("Очень жду!!!");
        orderPageSecond.orderPageCreateOrderBtnClick();
        orderPageSecond.orderPageConfirmOrderBtnClick();
        String actualResult = orderPageSecond.orderPageOrderSuccessGetText();
        Assert.assertThat(actualResult, containsString("Заказ оформлен"));
        Thread.sleep(3000);
        driver.quit();
    }

}
