package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelTest {
    public WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    void setUp(String br,String url) throws InterruptedException {
//        driver= new EdgeDriver();
        switch (br.toLowerCase())
        {
            case "chrome": driver = new ChromeDriver();break;
            case "edge":driver=new EdgeDriver();break;
            case "firefox":driver = new FirefoxDriver();break;
            default:System.out.println("Invalid browser");return;
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(url);

    }

    @Test(priority=0)
    void title() throws InterruptedException {

        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
        Thread.sleep(3000);
    }

    @Test(priority=1)
    void url()
    {
Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority=2)
    void displayLogo()
    {
boolean display=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertEquals(display,true);
    }


    @AfterClass
    void tearDown()
    {
        driver.close();
    }
}
