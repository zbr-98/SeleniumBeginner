import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalendarRSA {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Date of travel']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);


//        driver.findElement(By.xpath("//input[@placeholder='Date of travel']")).click();

        while(!driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains("October")) {
            WebElement el= driver.findElement(By.xpath("//div[@class='flatpickr-month']//span[@class='flatpickr-next-month']"));
            js.executeScript("arguments[0].click();", el);
        }
        List<WebElement> dates= driver.findElements(By.className("flatpickr-day"));
        int N=driver.findElements(By.className("flatpickr-day")).size();

        for(int i=0;i<N;i++){
            String text=driver.findElements(By.className("flatpickr-day")).get(i).getText();
            if(text.equalsIgnoreCase("10")) {
                driver.findElements(By.className("flatpickr-day")).get(i).click();
                break;
            }
        }
    }

}