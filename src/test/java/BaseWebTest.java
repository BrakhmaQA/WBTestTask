import config.BaseConfigs;
import data.TestData;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static utils.ScreenshotHelper.attachPageScreenshot;

public class BaseWebTest {

    protected static WebDriver driver;

    protected static final BaseConfigs BASE_CONFIGS = ConfigFactory.create(BaseConfigs.class, System.getenv());

    protected static final TestData TEST_DATA = ConfigFactory.create(TestData.class, System.getenv());

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(BASE_CONFIGS.wbUrl());
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        attachPageScreenshot(driver);

        driver.quit();
    }
}
