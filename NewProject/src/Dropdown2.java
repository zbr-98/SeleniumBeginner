import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Dropdown2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");
        driver.findElement(By.xpath("//div[contains(text(),'1 Adult')]")).click();

//        Thread.sleep(5000);

        for(int i=0;i<5;i++)
            driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj r-d9fdf6']//div[1]//div[2]//div[3]")).click();

        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();
    }
}
