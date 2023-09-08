import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NumberingStories {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.livehindustan.com/");

        List<String> expectedHeading = new ArrayList<>();
        expectedHeading.add("Hindi News");
        expectedHeading.add("मनोरंजन");
        expectedHeading.add("पॉडकास्ट");

        List<WebElement> widgets = driver.findElements(By.xpath("//h1[contains(@class,'wdgt-hdng')]/span | //div[contains(@class,'wdgt-hdng')]/h2/a"));

        for(int widget=0;widget<3;widget++){
            String widgetText = widgets.get(widget).getText().trim();
            Assert.assertTrue(widgetText.equals(expectedHeading.get(widget)),"Index "+widget+" is not "+widgetText);
            System.out.println("Expected: "+expectedHeading.get(widget)+" & Actual: "+widgetText);
        }
    }
}
