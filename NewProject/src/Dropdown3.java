import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dropdown3 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
//
//        driver.findElement(By.xpath("//div[contains(text(),'From')]/..")).click();
//        driver.findElement(By.xpath("//div[contains(text(),'BHU')]/..")).click();
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'IXB')]/..")).click();

//        checkboxes
        WebElement el = driver.findElement(By.xpath("//div[contains(@class,'r-m611by')]/descendant::div[contains(text(),'Senior Citizen')]/../.."));

        if(el.isSelected()==false){
            el.click();
        };





    }
}
