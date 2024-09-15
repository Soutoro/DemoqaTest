package CleverVorobev;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты на проверку вкладки Elements")
public class ElementsTest {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    void setup (){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com");
        WebElement elements = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elements.click();
    }

//    @Test
//    @DisplayName("Тест на проверку текстовой формы")
//    void textBoxValideTest () {
//
//        String  name = "TestName",
//                email = "test@mail.com",
//                currentAddress = "TestAddress",
//                permanentAddress = "TestPermanent";
//
//        WebElement element = driver.findElement(By.className("text"));
//        element.click();
//        WebElement userNameBox = driver.findElement(By.id("userName"));
//        userNameBox.sendKeys(name);
//        WebElement emailBox = driver.findElement(By.id("userEmail"));
//        emailBox.sendKeys(email);
//        WebElement currentAddressBox = driver.findElement(By.id("currentAddress"));
//        currentAddressBox.sendKeys(currentAddress);
//        WebElement permanentAddressBox = driver.findElement(By.id("permanentAddress"));
//        permanentAddressBox.sendKeys(permanentAddress);
//        WebElement btn = driver.findElement(By.id("submit"));
//        btn.click();
//        String nameText = driver.findElement(By.xpath("//p[@id='name']")).getText();
//        assertEquals(nameText, "Name:" + name);
//        String emailText = driver.findElement(By.xpath("//p[@id='email']")).getText();
//        assertEquals(emailText, "Email:" + email);
//        String currentAddressText = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
//        assertEquals(currentAddressText, "Current Address :" + currentAddress);
//        String permanentAddressText = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
//        assertEquals(permanentAddressText, "Permananet Address :" + permanentAddress);
//        driver.quit();
//
//    }

    @Test
    @DisplayName("Тест на проверку текстовой формы")
    void textBoxTest () {

        WebElement element = driver.findElement(By.className("text"));
        element.click();
        WebElement userNameBox = driver.findElement(By.id("userName"));
        WebElement emailBox = driver.findElement(By.id("userEmail"));
        WebElement currentAddressBox = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddressBox = driver.findElement(By.id("permanentAddress"));

        String[] test_data =     {"TestName", "test@mail.com", "TestAddress", "TestPermanent"};
        WebElement[] textBoxes = {userNameBox, emailBox, currentAddressBox, permanentAddressBox};

        for (int i = 0; i < 4; i++) {
            textBoxes[i].sendKeys(test_data[i]);
        }

        WebElement btn = driver.findElement(By.id("submit"));
        btn.click();
        String nameText = driver.findElement(By.xpath("//p[@id='name']")).getText();
        String emailText = driver.findElement(By.xpath("//p[@id='email']")).getText();
        String currentAddressText = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        String permanentAddressText = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();

        String[] result =      {nameText, emailText, currentAddressText, permanentAddressText};
        String[] result_Text = {"Name:", "Email:", "Current Address :", "Permananet Address :"};

        for (int i = 0; i < 4; i++) {
            assertEquals(result[i], result_Text[i] + test_data[i]);
        }

        driver.quit();

    }


    @Test
    @DisplayName("Тест на проверку клика по кнопке")
    void clickButton () {

        WebElement element = driver.findElement(By.id("item-4"));
        element.click();
        WebElement btn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        btn.click();
        String text = driver.findElement(By.id("dynamicClickMessage")).getText();
        assertEquals(text, "You have done a dynamic click");
        driver.quit();

    }

    @Test
    @DisplayName("Тест на проверку двойного клика по кнопке")
    void doubleClickButton () {

        WebElement element = driver.findElement(By.id("item-4"));
        element.click();
        WebElement btn = driver.findElement(By.id("doubleClickBtn"));
        new Actions(driver)
                .doubleClick(btn)
                .perform();
        String text = driver.findElement(By.id("doubleClickMessage")).getText();
        assertEquals(text, "You have done a double click");
        driver.quit();

    }
}
