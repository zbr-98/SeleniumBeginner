package WindowHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class LinksPlay {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/");
        int size=driver.findElements(By.xpath("(//footer[@id='FooterWraper']//div//ul)[2]//a")).size();

        for(int i=0; i<size; i++){
            String clickTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            driver.findElements(By.xpath("(//footer[@id='FooterWraper']//div//ul)[2]//a")).get(i).sendKeys(clickTab);
        }
//        get title from different links using windows handle
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
