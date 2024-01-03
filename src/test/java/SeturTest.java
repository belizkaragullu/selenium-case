import org.example.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class SeturTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void testSetur() throws InterruptedException {
        driver.manage().window().maximize();

        // Sayfaya gidilir
        homePage.goToSeturUrl();

        // Sayfadaki reklam ve cookie kapatılır
        homePage.cleanAddAndCookies();

        // Setur URL kontrol edilir
        homePage.verifySeturUrl();

        // Otel tabı default kontrol edilir
        homePage.verifyDefaultOtel();

         // Gidilecek yere "Antalya" yazılır
        homePage.enterDestination("Antalya");

        // Antalya yazınca ilk çıkana basılır
        homePage.selectAntalyaOption();

        // Tarih olarak Nisan ilk haftası yazılır
        homePage.selectDate();

        // Yetişkin sayısı 1 artırılır
        homePage.increaseAdult();

        // Ara butonunun görünürlüğü kontrol edilir
        homePage.isSearchButtonVisible();

        // Ara butonuna basılır
        homePage.clickSearchButton();

        // Yeni açılan pencerenin URL sinde antalya kelimesi kontrol edilir
         homePage.isUrlContainsAntalya();


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}


