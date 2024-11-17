package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Demo1
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();
        driver.get("http://www.demo.guru99.com/V4/");
        Thread.sleep(5000);
        driver.close();
    }
}
