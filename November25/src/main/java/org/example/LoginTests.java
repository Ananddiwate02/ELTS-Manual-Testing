package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class LoginTests {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe"); // Update the path

    WebDriver driver = new ChromeDriver();

        try {
        // Open the site
        driver.get("https://qr-code-eight-ashy.vercel.app/");

        // Verify the page title
        String pageTitle = driver.getTitle();
        if (!pageTitle.isEmpty()) {
            System.out.println("Site loaded successfully. Title: " + pageTitle);
        } else {
            System.out.println("Failed to load the site.");
        }
            Thread.sleep(2000);
    } catch (Exception e) {
        e.printStackTrace();
    }
        try {
            // Navigate to the website
            driver.get("https://qr-code-eight-ashy.vercel.app/");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Locate the Register button using XPath and click it
            WebElement registerButton = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/a[2]/button"));
            registerButton.click();

            // Optional: Print confirmation
            System.out.println("Register button clicked successfully!");

            // Pause for a few seconds to observe (if needed)
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Regester the Email nd Password
            driver.get("https://qr-code-eight-ashy.vercel.app/register");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Locate and input the Name field
            //WebElement nameField = driver.findElement(By.xpath("//*[@id='root']/div/div/form/div[1]/input"));
           // nameField.sendKeys("Test User");

            // Locate and input the Email field
            WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/input"));
            emailField.sendKeys("Ananddiwatai1@gmail.com");

            // Locate and input the Password field
            WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[2]/input"));
            passwordField.sendKeys("Passwd1123");

            // Locate and input the Confirm Password field
          //  WebElement confirmPasswordField = driver.findElement(By.xpath("//*[@id='root']/div/div/form/div[4]/input"));
            //confirmPasswordField.sendKeys("password123");

            // Locate and click the Submit button
            WebElement submitButton = driver.findElement(By.xpath("//*[@id='root']/div/div/form/button"));
            submitButton.click();

            // Optional: Validate success
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.isEmpty()) { // Adjust as per actual URL or success criteria
                System.out.println("Registration Test Failed!");
            } else {
                System.out.println("Registration Test Passed!");
            }

            // Pause for observation (optional)
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Open the site
            driver.get("https://qr-code-eight-ashy.vercel.app/");

            // Verify the page title
            String pageTitle = driver.getTitle();
            if (!pageTitle.isEmpty()) {
                System.out.println("Site loaded successfully. Title: " + pageTitle);
            } else {
                System.out.println("Failed to load the site.");
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // Navigate to the website
            driver.get("https://qr-code-eight-ashy.vercel.app/");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Locate the Register button using XPath and click it
            WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/a[1]/button"));
           LoginButton.click();

            // Optional: Print confirmation
            System.out.println("Login button clicked successfully!");

            // Pause for a few seconds to observe (if needed)
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Enter Login Details
            driver.get("https://qr-code-eight-ashy.vercel.app/login");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Locate and input the Name field
            //WebElement nameField = driver.findElement(By.xpath("//*[@id='root']/div/div/form/div[1]/input"));
            // nameField.sendKeys("Test User");

            // Locate and input the Email field
            WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/input"));
            emailField.sendKeys("Ananddiwatai1@gmail.com");

            // Locate and input the Password field
            WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[2]/input"));
            passwordField.sendKeys("Passwd1123");

            // Locate and input the Confirm Password field
            //  WebElement confirmPasswordField = driver.findElement(By.xpath("//*[@id='root']/div/div/form/div[4]/input"));
            //confirmPasswordField.sendKeys("password123");

            // Locate and click the Submit button
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button"));
            submitButton.click();

            // Optional: Validate success
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.isEmpty()) { // Adjust as per actual URL or success criteria
                System.out.println("Login Test Failed!");
            } else {
                System.out.println("Login Test Passed!");
            }

            // Pause for observation (optional)
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // Enter Login Details
            driver.get("https://qr-code-eight-ashy.vercel.app/qr-scanner");
            driver.manage().window().maximize();
            Thread.sleep(3000);
            Thread.sleep(3000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //test case 3
       finally {
            driver.quit();
        }
    }
}
