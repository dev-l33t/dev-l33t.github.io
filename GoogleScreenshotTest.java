import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class GoogleScreenshotTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver"); // For local execution

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://www.google.com");

            // Take Screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), new File("screenshot.png").toPath());

            System.out.println("Screenshot taken: screenshot.png");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
