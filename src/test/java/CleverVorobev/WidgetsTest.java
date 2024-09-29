package CleverVorobev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WidgetsTest {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    void setup () {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com");
        driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
    }

    @Test
    void accordianTest () {

        driver.findElement(By.xpath("//span[text()='Accordian']")).click();
        String classValue = driver.findElement(By.id("section2Heading")).getAttribute("class");
        driver.findElement(By.id("section2Heading")).click();
        classValue.contains("collapse show");

    }

}
