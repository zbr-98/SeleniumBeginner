import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class LocatorsPractice {
    public static void main(String[] args) throws InterruptedException {
        //chromeOptions object to set chrome with options
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir="+"C:\\Users\\imzub\\AppData\\Local\\Google\\Chrome\\User Data"); //for opening chrome user profile which I want
//        options.addArguments("--start-maximized"); //for max window

        WebDriver driver = new ChromeDriver(options); //Chromedriver object

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        String name= "Zubair";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  //setting timeout to wait for some seconds to login and then print

        driver.findElement(By.id("inputUsername")).sendKeys(name); //finding elemnt by ID
        driver.findElement(By.name("inputPassword")).sendKeys("zbr123"); //finding elemnt by name
        driver.findElement(By.className("signInBtn")).click();  //finding element by classname

        String txt = driver.findElement(By.cssSelector(".error")).getText();  //finding element by css Selector
        System.out.println(txt);

        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("tech.zbr@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("8439437416");
        driver.findElement(By.cssSelector("div>button.reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        String password = getPassword(driver);

        driver.findElement(By.xpath("//div/button[1]")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys(password);

        driver.findElement(By.name("chkboxTwo")).click();
        driver.findElement(By.cssSelector(".submit.signInBtn")).click();

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());

//        assertions
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector(".login-container h2")).getText(), "Hello "+name+",");

        driver.findElement(By.className("logout-btn")).click();

    }
    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("div>button.reset-pwd-btn")).click();
        String passwordTxt= driver.findElement(By.cssSelector("form p")).getText();

        //Please use temporary password 'rahulshettyacademy' to Login.

        String[] passwordArray=passwordTxt.split("'");
        return passwordArray[1].split("'")[0];
        
    }
}
