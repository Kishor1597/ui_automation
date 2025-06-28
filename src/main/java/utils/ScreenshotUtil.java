package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String dest = "test-output/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            Files.createDirectories(Paths.get("test-output/screenshots/"));
            Files.copy(src.toPath(), Paths.get(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }
}
