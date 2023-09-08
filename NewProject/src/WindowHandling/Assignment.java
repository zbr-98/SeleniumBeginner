package WindowHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector(".example>a")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parentWindow=it.next();
        String childWindow =it.next();

        driver.switchTo().window(childWindow);

        System.out.println(driver.findElement(By.cssSelector("div h3")).getText());
        driver.switchTo().window(parentWindow);

        System.out.println(driver.findElement(By.cssSelector("#content div h3")).getText());
        driver.switchTo().window(childWindow);
//        driver.quit();
    }
}
