package CleverVorobev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsFrameWindowsTest {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    void setup () {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com");
        WebElement elements = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elements.click();
    }

    @Test
    @DisplayName("Проверка открытия новой вкладки")
    void browserWindowTest () {

        WebElement element = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        element.click();
        WebElement btn = driver.findElement(By.id("tabButton"));
        btn.click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String url = driver.getCurrentUrl();
        assertEquals(url, "https://demoqa.com/sample");
        driver.quit();

    }

    @Test
    @DisplayName("Проверка обычного браузерного алерта")
    void alertTest () {

      driver.findElement(By.xpath("//span[text()='Alerts']")).click();
      driver.findElement(By.id("alertButton")).click();
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();
      assertEquals(text, "You clicked a button");
      alert.accept();
      driver.quit();
    }
}
