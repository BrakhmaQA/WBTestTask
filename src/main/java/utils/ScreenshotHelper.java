package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;

public class ScreenshotHelper {

    public static void attachPageScreenshot(WebDriver webDriver) {
        byte[] screenshotBytes = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        Allure.attachment("Screenshot on failure (" + LocalDateTime.now() + ")", new ByteArrayInputStream(screenshotBytes));
    }
}
