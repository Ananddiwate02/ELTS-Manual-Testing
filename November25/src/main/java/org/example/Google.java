package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google {

    public static void main(String[] args) {
        // Set up ChromeOptions to avoid detection
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Google Login page
            driver.get("https://accounts.google.com/signin");

            // Enter Email
            WebElement emailField = driver.findElement(By.id("identifierId"));
            emailField.sendKeys("Ananddiwatai@gmail.com");

            // Click Next
            WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']/.."));
            nextButton.click();

            // Wait for the password field to load
            Thread.sleep(6000); // Use WebDriverWait for a more robust solution

            // Enter Password
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("02081999");

            // Click Next
            WebElement loginButton = driver.findElement(By.xpath("//span[text()='Next']/.."));
            loginButton.click();

            // Add a wait to observe the result
            Thread.sleep(5000); // Adjust this as needed
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
