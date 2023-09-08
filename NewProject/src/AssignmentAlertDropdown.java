import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentAlertDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement optEl= driver.findElement(By.xpath("//div[@id='checkbox-example']//label[2]/input"));
        optEl.click();

        String opt = optEl.getAttribute("value");

        WebElement el = driver.findElement(By.name("dropdown-class-example"));
        Select dropDown = new Select(el);
        dropDown.selectByValue(opt);

        driver.findElement(By.cssSelector("input#name")).sendKeys(opt);
        driver.findElement(By.id("alertbtn")).click();

        String txt = driver.switchTo().alert().getText();
        if(txt.contains(opt)){
            System.out.println(opt+" found in alert.");
        }else{
            System.out.println("Alert does not contain "+opt);
        }
    }
}
