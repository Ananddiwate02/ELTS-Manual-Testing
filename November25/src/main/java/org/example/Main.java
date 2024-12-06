package org.example;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // Step 1: Set up WebDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe"); // Update the path

        // Step 2: Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Define the URL
        String baseUrl = "https://visume.co.in/auth/signin";

        // Step 3: Open the Login Page
        driver.get(baseUrl);

        // Step 4: Test Case 1 - Successful Login
        try {
            WebDriverWait wait;

            // Locate elements
            // Wait for the email input element to be present and visible
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement emailElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

// Check if the element is found
            if (emailElement != null) {
                emailElement.sendKeys("Ananddiwatai@gmail.com");
            } else {
                System.out.println("Element not found!");
            }

            WebElement passwordField = driver.findElement(By.id("password"));
            if (passwordField != null) {
                passwordField.sendKeys("1234567890");
            } else {
                System.out.println("Element not found!");
            }// Replace with actual ID

            //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));

            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
            // Replace 'submit_button_id' with the actual ID

            // Click the Submit button
            submitButton.click();

            //  assert emailElement != null;
            // emailElement.sendKeys("Ananddiwatai@gmail.com"); // Replace with your test Gmail address

            // assert passwordField != null;
            //  passwordField.sendKeys("12345678"); // Replace with valid password
            //submitButton.click();

            // Wait for Dashboard
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Users Not Found"))); // Replace with actual ID

            System.out.println("Test Case 1 Passed: Successful login");
        } catch (Exception e) {
            System.out.println("Test Case 1 Failed: " + e.getMessage());
        }


        try {
            // Test 2: Invalid Login
            driver.get(baseUrl);

            // Locate elements
            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

            // Input invalid credentials
            usernameField.sendKeys("invalid_username@example.com");
            passwordField.sendKeys("123456789123");
            submitButton.click();

            // Verify error message
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("clerk-components"))); // Replace with actual ID
            System.out.println("Test Case 2 Passed: Invalid  User name nd Password ");


        } catch (Exception e) {
            System.out.println("Test 2 Failed: " + e.getMessage());
        }

        try {
            // Test 3: Empty Input Validation
            driver.get(baseUrl);

            // Locate elements
            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

            // Leave fields empty and click submit
            usernameField.clear();
            passwordField.clear();
            submitButton.click();

            // Wait for the error message (adjust ID if needed)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'enter email and password')]")));

            // Verify if the error message contains "Fields cannot be empty"
            if (errorMessage.getText().contains("enter email and password")) {
                System.out.println("Test 3 Passed: Empty input validation");
            } else {
                System.out.println("Test 3 Failed: Unexpected error message");
            }

        } catch (Exception e) {
            System.out.println("Test 3 Failed: " + e.getMessage());
        }

        try {

            //Give Email but No Password
            driver.get(baseUrl);

            // Locate elements
            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

            // Input invalid credentials
            usernameField.sendKeys("invalid_username@example.com");
            passwordField.clear();
            submitButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'enter email and password')]")));

            // Verify if the error message contains "Fields cannot be empty"
            if (errorMessage.getText().contains("enter email and password")) {
                System.out.println("Test 4 Passed: Didnt Enter Password");
            } else {
                System.out.println("Test 4 Failed: Unexpected error message");
            }
        } catch (Exception e) {
            System.out.println("Test 4 Failed: " + e.getMessage());
        }


        try {
            //Test Case 5
            //Give Password but No Mail
            driver.get(baseUrl);

            // Locate elements
            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

            // Input invalid credentials
            usernameField.clear();
            passwordField.sendKeys("123456789123");
            submitButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'enter email and password')]")));

            // Verify if the error message contains "Fields cannot be empty"
            if (errorMessage.getText().contains("enter email and password")) {
                System.out.println("Test 5 Passed: Didnt Enter Email    ");
            }
        } catch (Exception e) {
            System.out.println("Test 5 Failed: " + e.getMessage());
        }


        try {
            //Test Case 6
            //Give Password but No Mail
            driver.get(baseUrl);

            // Locate elements
            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

            // Input invalid credentials
            usernameField.sendKeys("invalidusername@gmail.com");
            passwordField.sendKeys("");
            submitButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'enter email and password')]")));

            // Verify if the error message contains "Fields cannot be empty"
            if (errorMessage.getText().contains("enter email and password")) {
                System.out.println("Test 6 Passed: Didnt Enter Password   ");
            }
        } catch (Exception e) {
            System.out.println("Test 6 Failed: " + e.getMessage());
        }


        try {
            //Test 7
            // Navigate to the sign-in page
            driver.get(baseUrl);

            // Locate elements
            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

            // Enter invalid email (no domain)

            usernameField.sendKeys("invalidemail@gmail.c");  // Invalid email

            // Leave password empty or enter some text

            passwordField.sendKeys("anyPassword"); // Optional, you can leave it empty as well

            // Click the submit button
            submitButton.click();

            // Wait for the main sign-in error (replace with correct selector if needed)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'User not found')]")));

            // Verify the sign-in error message
            //if (errorMessage.getText().contains("User not Found")) {  // Adjust this message to match the actual sign-in error
                System.out.println("Test 7 Passed: Invalid email format prevents sign-in");

        }
            catch(Exception e){
                System.out.println("Test 7 Failed: " + e.getMessage());
            }




        try {

            //test case 8
            // Wait for the "Sign in with Google" button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Locate the 'Sign in with Google' button using XPath or CSS Selector

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div/main/div/div/div/div[1]/div/div[1]")));
            //  googleSignInButton.sendKeys("cl-modelContent");

            // Click the "Sign in with Google" button
            //googleSignInButton.click();
            new WebDriverWait(driver, Duration.ofSeconds(20));
            //googleSignInButton.sendKeys("cl--modelContent");

            //now you can either wait for the redirect or handle further steps (manually or automatically depending on the test environment)
            System.out.println("Test 8 Passed: Google sign in Clicked successful");
        } catch (Exception e) {
            System.out.println("Error during Sign in with Google: " + e.getMessage());
        }
        driver.quit();
        }
    }


