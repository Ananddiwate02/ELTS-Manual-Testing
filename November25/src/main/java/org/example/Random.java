package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Random {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Load an existing Chrome profile
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        try {
            // Launch the website
            driver.get("https://eltscertification.in/?BAId=KPETPVE");
            driver.manage().window().maximize();
            System.out.println("ELT site launched successfully!");
            Thread.sleep(4000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Wait for the Register button to be clickable and click it
            WebElement emailElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("eltsintlogin")));

            emailElement.click();
            System.out.println("Register button clicked successfully!");

            // Pause for observation
            Thread.sleep(4000);
            System.out.println("Navigated to Gmail.");

            // Wait for the email field to be visible and enter the email
           // WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
            if (!driver.findElements(By.id("identifierId")).isEmpty()) {
                WebElement emailField = driver.findElement(By.id("identifierId"));
                emailField.sendKeys("Ananddiwatai@gmail.com");
                driver.findElement(By.xpath("//span[text()='Next']")).click();
                options.addArguments("--disable-blink-features=AutomationControlled");
                WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
                passwordField.sendKeys("your-password");
                driver.findElement(By.xpath("//span[text()='Next']")).click();
            } else {
                System.out.println("Already logged in using the profile.");
            }

            // Verify successful login
            if (driver.getCurrentUrl().contains("inbox")) {
                System.out.println("Successfully logged into Gmail!");
            } else {
                System.out.println("Login failed or additional verification is required.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
