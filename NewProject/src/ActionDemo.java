import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.browserstack.com/guide/action-class-in-selenium");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//button[@id='developers-menu-toggle']"))).build().perform();



    }
}
