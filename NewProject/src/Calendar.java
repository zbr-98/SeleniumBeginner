import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {
        Scanner in=new Scanner(System.in);

        System.out.print("Enter month and date to be clicked: ");
        String month=in.next();
        String day=in.next();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.irctc.co.in/nget/train-search");
        selectDate(driver, month, day);
    }
    public static void selectDate(WebDriver driver, String month, String day) throws InterruptedException {
        driver.findElement(By.xpath("//p-calendar//input")).click();
        Thread.sleep(1000);

        while(!driver.findElement(By.xpath("//div[contains(@class,'ui-datepicker')]/span")).getText().contains(month)){
            driver.findElement(By.xpath("//a/span[contains(@class,'ui-datepicker-next')]")).click();
        }

        List<WebElement> days = driver.findElements(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//td"));
        int N = days.size();

        for(int i=0;i<N;i++){
            String date= driver.findElements(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//td")).get(i).getText();
            if(date.equalsIgnoreCase(day)){
                driver.findElements(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//td")).get(i).click();
                break;
            }
        }
    }
}
