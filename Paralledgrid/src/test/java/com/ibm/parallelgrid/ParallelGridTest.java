package com.ibm.parallelgrid;

import com.ibm.screenshotutil.*;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParallelGridTest {

    public static void main(String[] args) throws InterruptedException {
        // Define test data
        String[][] testData = {
            {"https://www.flipkart.com/", "chrome"},
            {"https://www.amazon.in/", "firefox"},
            {"https://www.croma.com/", "MicrosoftEdge"}
        };

        // Create threads for parallel execution
        List<Thread> threads = new ArrayList<>();

        for (String[] data : testData) {
            String url = data[0];
            String browser = data[1];
            
            
            Thread thread = new Thread(() -> {
                runTest(url, browser);
            });
            
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All tests completed!");
    }

    public static void runTest(String url, String browserName) {
        WebDriver driver = null;
        try {
            // Setup capabilities
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName(browserName);
            cap.setPlatform(Platform.WIN11);

            // Create RemoteWebDriver
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
            
     
             
            // Navigate to URL
            driver.get(url);
            Thread.sleep(1000);
            pictureutility.takePic(driver,"./src/test/resources/");
            driver.manage().window().maximize();
            
            
            
            System.out.println("[" + browserName + "] Opened: " + url);
            System.out.println("[" + browserName + "] Title: " + driver.getTitle());
            System.out.println("[" + browserName + "] Url: "+driver.getCurrentUrl());
            
            // Wait for 5 seconds
            Thread.sleep(5000);
            
        }  catch (Exception e) {
            System.err.println("Error in test: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("[" + browserName + "] Browser closed");
            }
        }
    }
}