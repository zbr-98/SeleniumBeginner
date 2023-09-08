package WindowHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

public class Practise {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.className("blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();

        Iterator<String> it= windows.iterator();
        String parentWindow=it.next();
        driver.switchTo().window(it.next());

        String userName=driver.findElement(By.cssSelector("p.im-para.red")).getText();
//      Please email us at mentor@rahulshettyacademy.com with below template to receive response
        userName=userName.split("at")[1].trim().split(" ")[0];
        System.out.println(userName);

        driver.switchTo().window(parentWindow);
        driver.findElement(By.name("username")).sendKeys(userName);


    }
}
