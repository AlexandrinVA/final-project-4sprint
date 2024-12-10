package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SamokatMainPage {
    private static WebDriver driver;

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


    // Accordion list
    public static String accordionLocatorOne = "accordion__heading-0";
    public static String accordionLocatorTwo = "accordion__heading-1";
    public static String accordionLocatorThree = "accordion__heading-2";
    public static String accordionLocatorFour = "accordion__heading-3";
    public static String accordionLocatorFive = "accordion__heading-4";
    public static String accordionLocatorSix = "accordion__heading-5";
    public static String accordionLocatorSeven = "accordion__heading-6";
    public static String accordionLocatorEight = "accordion__heading-7";
    // Accordion text list
    public static String accordionLocatorTextOne = ".//div[@id='accordion__panel-0']/p";
    public static String accordionLocatorTextTwo = ".//div[@id='accordion__panel-1']/p";
    public static String accordionLocatorTextThree = ".//div[@id='accordion__panel-2']/p";
    public static String accordionLocatorTextFour = ".//div[@id='accordion__panel-3']/p";
    public static String accordionLocatorTextFive = ".//div[@id='accordion__panel-4']/p";
    public static String accordionLocatorTextSix = ".//div[@id='accordion__panel-5']/p";
    public static String accordionLocatorTextSeven = ".//div[@id='accordion__panel-6']/p";
    public static String accordionLocatorTextEight = ".//div[@id='accordion__panel-7']/p";
    // Accordion expected text list
    public static String accordionLocatorExpTextOne = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static String accordionLocatorExpTextTwo = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static String accordionLocatorExpTextThree = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static String accordionLocatorExpTextFour = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static String accordionLocatorExpTextFive = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static String accordionLocatorExpTextSix = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static String accordionLocatorExpTextSeven = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static String accordionLocatorExpTextEight = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public SamokatMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickBtnDropDownHowPriceHowPayFAQ() {
        driver.findElement(dropDownHowPriceHowPayFAQ).click();
    }
    // локатор первого акордиона
    public WebElement btnDropDownHowPriceHowPayFAQ() {
        return driver.findElement(dropDownHowPriceHowPayFAQ);
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

    public static void waitForChangedActivity(String text) {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text)));
    }
}



