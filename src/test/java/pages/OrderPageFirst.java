package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageFirst {

    private WebDriver driver;

    // Имя
    private By orderPageNameField = By.xpath(".//input[@placeholder='* Имя']");
    // Фамилия
    private By orderPageSurnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // Адрес доставки
    private By orderPageDeliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Станция метро выпадающий список
    private By orderPageMetroStationDropDown = By.xpath(".//input[@placeholder='* Станция метро']");
    // Станция метро "Комсомольская"
    private By orderPageMetroStationKomsomolskaya = By.xpath(".//div[@class='Order_Text__2broi' and text()='Комсомольская']");
    // Номер телефона
    private By orderPagePhoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка "Далее"
    private By orderPageNextStepBtn = By.xpath(".//button[text()='Далее']");


    public OrderPageFirst(WebDriver driver){
        this.driver = driver;
    }



    public void setNameToFieldNameOrderPage(String name) {
        driver.findElement(orderPageNameField).clear();
        driver.findElement(orderPageNameField).sendKeys(name);
    }

    public void setSurnameToFieldSurnameOrderPage(String surname) {
        driver.findElement(orderPageSurnameField).clear();
        driver.findElement(orderPageSurnameField).sendKeys(surname);
    }

    public void setOrderPageDeliveryAddressToFieldDeliveryAddressOrderPage(String text) {
        driver.findElement(orderPageDeliveryAddress).clear();
        driver.findElement(orderPageDeliveryAddress).sendKeys(text);
    }

    public void orderPageMetroStationDropDownClick() {
        driver.findElement(orderPageMetroStationDropDown).click();
    }

    public void orderPageMetroStationKomsomolskayaClick() {
        driver.findElement(orderPageMetroStationKomsomolskaya).click();
    }

    public void setOrderPagePhoneNumberField(String text) {
        driver.findElement(orderPagePhoneNumberField).clear();
        driver.findElement(orderPagePhoneNumberField).sendKeys(text);
    }
    public void orderPageNextStepBtnClick() {
        driver.findElement(orderPageNextStepBtn).click();
    }


}
