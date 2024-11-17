package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderTest {
public WebDriver driver;
    @BeforeClass
    public void setUp()
    {
        //System.out.println("opening browser"); //https://www.saucedemo.com/
        // Setup Chrome options to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");  // Disables all browser notifications
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();


    }
    @Test(dataProvider = "dp1")
    public void login(String name, String pwd) throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(name);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        boolean logo=driver.findElement(By.xpath("//div[text()='Swag Labs']")).isDisplayed();
        if(logo==true) {
            driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
            Thread.sleep(2000);
            Assert.assertTrue(true);

        }
        else {
            Assert.fail();
        }
    }


    @AfterClass
    public void tearDown()
    {
        driver.close();
    }


    @DataProvider(name="dp1", indices = {0,2})
    Object[][] loginData()
    {
        Object data[][]={ {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"error_user","secret"},
                {"time_user","secret_sauce"}

        };

        return data;
    }

}
