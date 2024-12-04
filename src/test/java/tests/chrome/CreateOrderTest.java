package tests.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.OrderPageFirst;
import pages.OrderPageSecond;
import pages.SamokatMainPage;

public class CreateOrderTest {

    private WebDriver driver;

    @Test
    public void e2eCreationOrderTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatMainPage samokatMainPage = new SamokatMainPage(driver);
        samokatMainPage.cookieAcceptClick();
        samokatMainPage.headerOrderBtnClick();
        Thread.sleep(3000);
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
        Thread.sleep(3000);
        driver.quit();
    }

}
