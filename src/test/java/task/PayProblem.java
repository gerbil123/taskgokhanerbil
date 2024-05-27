package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PayProblem {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("www.gokhanticaret.com");
    }

    @Test
    public void ürünSecme() {
        // Ürün seçme
        WebElement product = driver.findElement(By.id("product-id"));
        product.click();
        //Ürünü sepete ekleme
        WebElement addToCart = driver.findElement(By.id("add-to-cart"));
        addToCart.click();

        // Sepeti onaylama ve ödeme sayfasına geçiş
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        // Ödeme bilgilerini girme
        WebElement cardNumber = driver.findElement(By.id("card-number"));
        cardNumber.sendKeys("251864255952");
        WebElement expirationDate = driver.findElement(By.id("expiration-date"));
        expirationDate.sendKeys("11/27");
        WebElement cvv = driver.findElement(By.id("cvv"));
        cvv.sendKeys("365");

        // Ödeme yapma
        WebElement payButton = driver.findElement(By.id("pay-button"));
        payButton.click();

        // Sonucu kontrol etme
        WebElement confirmationMessage = driver.findElement(By.id("confirmation-message"));
        assertEquals("Ödeme başarılı!", confirmationMessage.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
