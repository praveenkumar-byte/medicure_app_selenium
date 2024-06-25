package com.medicure.test.medicure_app_test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	  //load driver
        WebDriverManager.chromedriver().setup();
     	
          //setup configuration
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        System.out.println("Scripted Executing");
        driver.get("http://3.109.181.55:8082/contact.html");

     	
     
         //load application
        driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[1]/div[1]/div/input")).sendKeys("shivani"); 
        driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[1]/div[2]/div/input")).sendKeys("9876776659"); 
        driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/input")).sendKeys("ss123@gamil.com");
        driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[3]/input")).sendKeys("Excellent");
        
      
         //submit button to form
        driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[4]/button")).click();
        
        //response get
        String response =driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
        System.out.println(response);
        
        
        //take screenshot
        
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        
        File scrFile =scrShot.getScreenshotAs(OutputType.FILE);
        
        File destFile = new File("test-report.jpg");
        
        FileUtils.copyFile(scrFile, destFile);
        
        
    
      
        //validate response
        driver.quit();
     	
    }
}
