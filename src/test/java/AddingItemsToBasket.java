import org.junit.jupiter.api.Test;
import pages.BasketPage;
import pages.HeaderPage;
import pages.ProductPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddingItemsToBasket extends BaseWebTest {

    ProductPage productPage = new ProductPage(driver);

    HeaderPage headerPage = new HeaderPage(driver);

    BasketPage basketPage = new BasketPage(driver);

    @Test
    public void successAddingBook() {
        driver.navigate().to(BASE_CONFIGS.wbUrl() + TEST_DATA.bookEndpoint());

        String productTitle = productPage.getProductTitle();
        assertEquals(productTitle, TEST_DATA.bookTitle(), "Product title isn't matched.");

        String productWalletPrice = productPage.getProductWalletPrice();
        String productFinalPrice = productPage.getProductFinalPrice();

        productPage.addingProductToBasket();

        boolean isAddToBasketHidden = productPage.isAddToBasketHidden();
        assertTrue(isAddToBasketHidden, "Add to basket button isn't hidden.");

        String basketCount = headerPage.getNavBarItemCount("basket");
        assertEquals(basketCount, "1", "Basket count isn't matched.");

        headerPage.goToNavBarItem("basket");

        assertSoftly(softAssertions -> {
            assertThat(basketPage.getBasketHeader())
                    .withFailMessage("Basket header isn't matched.")
                    .isEqualTo(TEST_DATA.basketHeader());
            assertThat(basketPage.getGoodNamesList())
                    .withFailMessage("Books name isn't matched.")
                    .isEqualTo(List.of(TEST_DATA.bookTitle()));
            assertThat(basketPage.getGoodBrandsList())
                    .withFailMessage("Books brand isn't matched.")
                    .isEqualTo(List.of(TEST_DATA.bookBrand()));
            assertThat(basketPage.getWaletPricesList())
                    .withFailMessage("Books wallet price isn't matched.")
                    .isEqualTo(List.of(productWalletPrice));
            assertThat(basketPage.getNewPricesList())
                    .withFailMessage("Books final price isn't  matched.")
                    .isEqualTo(List.of(productFinalPrice));
        });
    }
}
