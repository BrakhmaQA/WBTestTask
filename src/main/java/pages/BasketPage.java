package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasketPage {

    private WebDriver driver;

    private WebDriverWait wait;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='basket-section__header-tabs']/h1")
    public WebElement basketHeader;

    @FindBy(xpath = "//span[@class='good-info__good-name']")
    public List<WebElement> goodName;

    @FindBy(xpath = "//span[@class='good-info__good-brand ']")
    public List<WebElement> goodBrand;

    @FindBy(xpath = "//div[contains(@class, 'list-item__price-wallet')]")
    public List<WebElement> walletProductPrice;

    @FindBy(xpath = "//div[@class='list-item__price-new wallet']")
    public List<WebElement> newProductPrice;

    @Step("Получение заголовка Корзина")
    public String getBasketHeader() {
        wait.until(ExpectedConditions.visibilityOf(basketHeader));

        return basketHeader.getText();
    }

    @Step("Получение названия всех товаров в корзине")
    public List<String> getGoodNamesList() {
        return goodName.stream().map(element -> element.getText()).toList();
    }

    @Step("Получение названия всех товаров в корзине")
    public List<String> getGoodBrandsList() {
        return goodBrand.stream().map(element -> element.getText()).toList();
    }

    @Step("Получение цен при оплате с кошелька")
    public List<String> getWaletPricesList() {
        return walletProductPrice.stream().map(element -> element.getText()).toList();
    }

    @Step("Получение старых цен")
    public List<String> getNewPricesList() {
        return newProductPrice.stream().map(element -> element.getText()).toList();
    }
}
