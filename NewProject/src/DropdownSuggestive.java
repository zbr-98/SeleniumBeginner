import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DropdownSuggestive {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/howto/howto_js_autocomplete.asp");

        driver.findElement(By.id("myInput")).sendKeys("I");

        List<WebElement> liItems = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']/div"));

        Thread.sleep(3000);
        for(WebElement li:liItems){
            if(li.getText().equalsIgnoreCase("India")){
                li.click();
                break;
            }
        }
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

//        alerts in selenium
        driver.switchTo().alert().dismiss();

    }
}
