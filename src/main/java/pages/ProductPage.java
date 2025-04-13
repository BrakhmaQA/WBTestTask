package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    private WebDriver driver;

    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='product-page__title']")
    public WebElement productTitle;

    @FindBy(xpath = "//div[@class='product-page__aside']//button[@class='order__button btn-main']")
    public WebElement addToBasket;

    @FindBy(xpath = "//div[@class='product-page__aside']//button[@class='order__button btn-main hide']")
    public List<WebElement> hiddenAddToBasket;

    @FindBy(xpath = "//div[@class='product-page__aside']//span[contains(@class, 'price-block__wallet-price')]")
    public WebElement walletProductPrice;

    @FindBy(xpath = "//div[@class='product-page__aside']//ins[@class='price-block__final-price wallet']")
    public WebElement finalProductPrice;

    @FindBy(xpath = "//div[@class='product-page__aside']//del[@class='price-block__old-price']/span")
    public WebElement oldProductPrice;

    @Step("Получение заголовка товара")
    public String getProductTitle() {
        wait.until(ExpectedConditions.visibilityOf(productTitle));

        return productTitle.getText();
    }

    @Step("Получение цены товары при оплате с кошелька")
    public String getProductWalletPrice() {
        return walletProductPrice.getText();
    }

    @Step("Получение финальной цены товара")
    public String getProductFinalPrice() {
        return finalProductPrice.getText();
    }

    @Step("Получение старой цены товара")
    public String getProductOldPrice() {
        return oldProductPrice.getText();
    }

    @Step("Добавление товара в корзину")
    public ProductPage addingProductToBasket() {
        addToBasket.click();

        return this;
    }

    @Step("Кнопка добавить в корзину скрыта")
    public boolean isAddToBasketHidden() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='product-page__aside']//button[@class='order__button btn-main hide']")));

        return !hiddenAddToBasket.isEmpty();
    }
}
