package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Переход на навигационный таб {navbarItem}")
    public void goToNavBarItem(String navbarItem) {
        driver.findElement(By.xpath("//div[contains(@class, 'navbar-pc__item')]//span[contains(@class, '%s')]".formatted(navbarItem)))
                .click();
    }

    @Step("Получение значения счетчика {navbarItem}")
    public String getNavBarItemCount(String navbarItem) {
        return driver.findElement(By.xpath("//div[contains(@class, 'navbar-pc__item')]//span[contains(@class, '%s')]/span[@class='navbar-pc__notify']".formatted(navbarItem)))
                .getText();
    }
}
