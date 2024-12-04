package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SamokatMainPage {
    private WebDriver driver;

    // Сколько это стоит? И как оплатить?
    private By dropDownHowPriceHowPayFAQ = By.id("accordion__heading-0");
    // содержимый текст пункта "Сколько это стоит? И как оплатить?"
    private By dropDownHowPriceHowPayFAQText = By.xpath(".//div[@id='accordion__panel-0']/p");
    // Куки ацепт
    private By acceptCookie = By.id("rcc-confirm-button");
    // Верхняя кнопка заказа самоката

    private By headerOrderBtn = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text() = 'Заказать']");
    // Нижняя кнопка заказа самоката
    private By finishOrderBtn = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text() = 'Заказать']");

    public SamokatMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickBtnDropDownHowPriceHowPayFAQ() {
        driver.findElement(dropDownHowPriceHowPayFAQ).click();
    }

    public String getTextDropDownHowPriceHowPayFAQText(){
        String text = driver.findElement(dropDownHowPriceHowPayFAQText).getText();
        return text;
    }

    public void cookieAcceptClick(){
        driver.findElement(acceptCookie).click();
    }

    public void headerOrderBtnClick(){
        driver.findElement(headerOrderBtn).click();
    }

    public void finishOrderBtnClick(){
        driver.findElement(finishOrderBtn).click();
    }

}

