package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        Random r = new Random();
        driver.get("http://localhost:4567");
        
        //epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
        
//        System.out.println(driver.getPageSource());
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//        System.out.println(driver.getPageSource());
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akke");
//        element = driver.findElement(By.name("login"));
//        
//        
//        element.submit();
//        System.out.println(driver.getPageSource());

        //uuden käyttäjätunnuksen luominen
        
//        System.out.println(driver.getPageSource());
//        WebElement element = driver.findElement(By.linkText("register new user"));
//        element.click();
//        System.out.println(driver.getPageSource());
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("matti"+r.nextInt(100000));
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("ittam");
//        element = driver.findElement(By.name("passwordConfirmation"));
//        element.sendKeys("ittam");
//        element = driver.findElement(By.name("signup"));

        //uuden käyttäjätunnuksen luomisen jälkeen tapahtuva uloskirjautuminen sovelluksesta
        
        System.out.println(driver.getPageSource());
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys("matti"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("ittam");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("ittam");
        element = driver.findElement(By.name("signup"));
        
        element.submit();
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.linkText("logout"));
        element.click();

        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
