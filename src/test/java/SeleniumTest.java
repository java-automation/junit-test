import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    WebDriver driver;
    @BeforeEach
    public void before(){
       driver =  new ChromeDriver();
        driver.get("https://skryabin.com/market/quote.html");
    }
    @AfterEach
    public void after() throws InterruptedException{
        Thread.sleep(1000);
        driver.quit();
    }

    @DisplayName("End to End test")
    @Test
    public void e2eTest() throws InterruptedException{
        driver.findElement(By.name("username")).sendKeys("jdoe");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jdoe@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("welcome");
        driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("welcome", Keys.TAB);
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("John M Doe");
        driver.findElement(By.xpath("//input[@name='allowedToContact']")).click();
        driver.findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

   @DisplayName("Negative test")
    @Test
    public void errorTest() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://skryabin.com/market/quote.html");
        driver.findElement(By.id("formSubmit")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}
