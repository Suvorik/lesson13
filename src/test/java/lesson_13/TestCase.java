package lesson_13;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

public class TestCase {
    private static WebDriver driver;
    Logger logger = LoggerFactory.getLogger("Test-Cases");

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\НовыйЯ\\IdeaProjects\\lesson_13\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://andersenlab.com/");
    }

    @Test
    @DisplayName("Тест-кейс №1: Проверка отображения номера телефона на главной странице")
    public void testCase1() {
        driver.get("https://andersenlab.com/");
        String s = driver.findElement(By.xpath("//span[contains(@class,'phoneNumber')]")).getText();
        assertEquals("+375 17 388 40 22", s);
        logger.info("Тест-кейс №1 пройден");
    }

    @Test
    @DisplayName("Тест-кейс №2: Проверка правильности отображения электронной почты на главной странице")
    public void testCase2() {
        // тестовые действия
        driver.get("https://andersenlab.com/");
        String s = driver.findElement(By.xpath("//span[contains(@class,'mail')]")).getText();
        assertEquals("vn@andersenlab.com", s);
        logger.info("Тест-кейс №2 пройден");
    }

    @Test
    @DisplayName("Тест-кейс №3: Проверка отображения кнопки Skype")
    public void isSkypeButtonDisplayed() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 8000)");
        WebElement skypeButton = driver.findElement(By.xpath("//a[contains(@href,'//join.skype.com/')]"));
        if (skypeButton.isDisplayed()) skypeButton.getText();
        String heading = skypeButton.getText();
        assertEquals("skype", heading);
        System.out.println(heading);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}