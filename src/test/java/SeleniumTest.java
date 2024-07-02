import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest {

    WebDriver driver;

    @BeforeEach
    public void before() {
        driver = new ChromeDriver();
        driver.get("https://skryabin.com/market/quote.html");
    }

    @AfterEach
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @DisplayName("End to End test")
    @Test
    public void e2eTest() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jdoe@example.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("welcome");
        driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("welcome");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        driver.findElement(By.xpath("//button[@id='formSubmit']")).click();
        String resultSection = driver.findElement(By.xpath("//div[@id='quotePageResult']//section")).getText();
        String usernameText = driver.findElement(By.xpath("//b[@name='username']")).getText();
        String agreedText = driver.findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(resultSection).contains("jdoe@example.com");
        assertThat(resultSection).contains("John Doe");
        assertThat(resultSection).doesNotContain("welcome");
        assertThat(usernameText).isEqualTo("jdoe");
        assertThat(agreedText).isEqualTo("true");
    }

    @DisplayName("Negative test")
    @Test
    public void errorTest() {
        driver.findElement(By.id("formSubmit")).click();
    }


}
