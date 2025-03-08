package org.example.selenium_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumWebdriverTest {


    private WebDriver webDriver;

    @BeforeEach
    void setup() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Test
    void testSteps() throws InterruptedException {

        // open
        webDriver.get("https://vitimex.com.vn/");

        // click menu
        webDriver.findElement(By.xpath("//*[@id=\"myPage\"]/header/div[2]/div/div[2]/div[2]/div[2]")).click();
//
//        // log in
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"ModalLogin\"]/div/div/div/div[1]/div[3]/a[1]")).click();
//
//        // input value into forms
        webDriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Vương Tri Kiên");
        webDriver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("0987654321");
        webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kien23@gmail.com");
        webDriver.findElement(By.xpath("//*[@id=\"pass-regis\"]")).sendKeys("kien23102004");
        webDriver.findElement(By.xpath("//*[@id=\"pass-confirm\"]")).sendKeys("kien23102004");
        Thread.sleep(2000);

        // submit form
        webDriver.findElement(By.xpath("//*[@id=\"register-btn\"]")).click();
//
//        // test
//        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"ShoeType\"]"));
//
//        String actualFirstCategory = webElement.getText();
//        String expectedFirstCategory = "Formal Shoes";
//        assertEquals(expectedFirstCategory, actualFirstCategory);
//
//        // ...
//
        webDriver.quit();

    }


}
