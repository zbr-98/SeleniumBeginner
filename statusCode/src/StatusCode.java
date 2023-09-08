import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class StatusCode{
    public static void main(String[] args) throws
            MalformedURLException, IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        //implicit wait
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //URL launch
        driver.get("https://www.livehindustan.com/");

//       driver.manage().window().maximize();
        List<WebElement> allLinks = driver.findElements(By.xpath("(//span[normalize-space()='Hindi News'])/../..//a[contains(@class,'wdgt-subtitle') or contains(@class,'big-news-title')]"));
        int n=allLinks.size();

        for(int i=0;i<n;i++){
            List<WebElement> allLink = driver.findElements(By.xpath("(//span[normalize-space()='Hindi News'])/../..//a[contains(@class,'wdgt-subtitle') or contains(@class,'big-news-title')]"));

            allLink.get(i).click();
//          String link = allLink.get(i).getAttribute("href");
            String link = driver.getCurrentUrl();
            URL url=new URL(link);

            HttpURLConnection cn = (HttpURLConnection) url.openConnection();
            cn.setRequestMethod("GET");

            //get response code
            int res = cn.getResponseCode();
            System.out.println("Http response code: " + res);

            cn.disconnect();

            driver.navigate().to("https://www.livehindustan.com/");
        }

        driver.quit();
    }
}