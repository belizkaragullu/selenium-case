package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void goToSeturUrl() {
        driver.get("https://www.setur.com.tr/");
    }

    public void verifySeturUrl() {

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("setur.com.tr")) {
            System.out.println("Setur URL verified.");
        } else {
            System.out.println("Setur URL not verified.");
        }
    }

    public void verifyDefaultOtel() {

        WebElement hotelTab = driver.findElement(By.linkText("Otel"));
        if (hotelTab.getText().equals("Otel")) {
            System.out.println("Otel is default");
        } else {
            System.out.println("Otel is not default.");
        }

    }

    public void cleanAddAndCookies() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"close-button-1454703513202\"]")));
        closeBtn.click();

        WebElement closeCookies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        closeCookies.click();

    }


    public void enterDestination(String destination) {

        WebElement destinationInput = driver.findElement(By.cssSelector("input[placeholder='Otel Adı Veya Konum']"));

        destinationInput.sendKeys(destination);
        destinationInput.click();
    }


    public void selectAntalyaOption() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By firstOptionLocator = By.xpath("//strong[text()='Antalya']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstOptionLocator));


        WebElement firstOption = driver.findElement(firstOptionLocator);
        firstOption.click();
    }

    public void selectDate() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div/div/div/span[2]/span")).click();
        driver.findElement(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/button[2]/span/span")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/button[2]/span/span")).click();
        driver.findElement(By.cssSelector("td.CalendarDay_1[aria-label*='1 Nisan']")).click();
        driver.findElement(By.cssSelector("td.CalendarDay_1[aria-label*='7 Nisan']")).click();
    }

    public void increaseAdult() {
        driver.findElement(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div[1]/div[2]/span/span")).click();

        driver.findElement(By.cssSelector("button[data-testid=\"increment-button\"]")).click();
        driver.findElement(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div[1]/div[2]/span/span")).click();


    }

    public void isSearchButtonVisible() {
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[3]/button/span"));
        if (searchButton.isDisplayed()) {
            System.out.println("Search button is visible.");
        } else {
            System.out.println("Search button is not visible.");
        }
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[3]/button/span")).click();
    }

    public void isUrlContainsAntalya() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("antalya"));

        if (driver.getCurrentUrl().contains("antalya")) {
            System.out.println("URL contains 'antalya'.");
        } else {
            System.out.println("URL not contains 'antalya'.");
        }
        Thread.sleep(4000);
    }



}
