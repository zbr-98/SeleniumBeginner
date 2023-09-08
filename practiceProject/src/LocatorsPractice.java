import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LocatorsPractice {
    public static void main(String[] args) {
        //chromeOptions object to set chrome with options
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir="+"C:\\Users\\imzub\\AppData\\Local\\Google\\Chrome\\User Data"); //for opening chrome user profile which I want
//        options.addArguments("--start-maximized"); //for max window

        WebDriver driver = new ChromeDriver(); //Chromedriver object

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        String name= "Zubair";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  //setting timeout to wait for some seconds to login and then print

        driver.findElement(By.id("inputUsername")).sendKeys(name); //finding elemnt by ID
        driver.findElement(By.name("inputPassword")).sendKeys("zbr123"); //finding elemnt by name
        driver.findElement(By.className("signInBtn")).click();  //finding element by classname

        String txt = driver.findElement(By.cssSelector(".error")).getText();  //finding element by css Selector
        System.out.println(txt);
    }
}
