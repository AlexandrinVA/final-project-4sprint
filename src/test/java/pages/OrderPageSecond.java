package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPageSecond {

    private WebDriver driver;

    // Дата доставки
    private By orderPageDeliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // срок аренды
    private By orderPageRentalPeriodField = By.xpath(".//div[text()='* Срок аренды']");
    // количество дней аренды dropdown
    private By orderPageRentalPeriodDropDownMenu = By.xpath(".//div[text()='двое суток']");
    // Цвет самоката чекбокс Черный
    private By orderPageSamokatColourBlackCheckbox = By.xpath(".//input[@id='black']");
    // Цвет самоката чекбокс Серый
    private By orderPageSamokatColourGreyCheckbox = By.xpath(".//input[@id='grey']");
    // Комментарий для курьера
    private By orderPageCommentCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка Заказать
    private By orderPageCreateOrderBtn = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    // Кнопка Да в попапе подтверждения
    private By orderPageConfirmOrderBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    // Заказ оформлен
    private By orderPagePopupOrderSuccess = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    public OrderPageSecond(WebDriver driver){
        this.driver = driver;
    }

    public void setDeliveryDateToDeliveryDateField(String date) {
        driver.findElement(orderPageDeliveryDate).clear();
        driver.findElement(orderPageDeliveryDate).sendKeys(date);
        driver.findElement(orderPageDeliveryDate).sendKeys(Keys.ENTER);

    }

    public void orderPageRentalPeriodFieldClick() {
        driver.findElement(orderPageRentalPeriodField).click();
    }

    public void orderPageRentalPeriodDropDownMenuClick() {
        driver.findElement(orderPageRentalPeriodDropDownMenu).click();
    }
    public void orderPageSamokatColourBlackCheckboxClick() {
        driver.findElement(orderPageSamokatColourBlackCheckbox).click();
    }

    public void setOrderPageCommentCourier(String text) {
        driver.findElement(orderPageCommentCourier).clear();
        driver.findElement(orderPageCommentCourier).sendKeys(text);
    }
    public void orderPageCreateOrderBtnClick() {
        driver.findElement(orderPageCreateOrderBtn).click();
    }

    public void orderPageConfirmOrderBtnClick() {
        driver.findElement(orderPageConfirmOrderBtn).click();
    }

    public String orderPageOrderSuccessGetText() {
        return driver.findElement(orderPagePopupOrderSuccess).getText();
    }


}
