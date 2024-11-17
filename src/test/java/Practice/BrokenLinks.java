package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

/*
1) check if the href attribute has a value
2) if href has a value then establish a connection with the server and get status code
3) If the status code is >=400 broken link else valid link.
4) Do the count of broken links
 */
public class BrokenLinks {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://www.deadlinkcity.com/");
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        System.out.println("Total no of links: "+allLinks.size());
      int broken_Link_Count=0;

    for(WebElement link:allLinks)
    {
        String att_value=link.getAttribute("href");
        if(att_value==null || att_value.isEmpty())
        {
            System.out.println("skip this link");
            continue;
        }

        try
        {
        URL url= new URL(att_value); //converting string to URL to pass it to server
       HttpURLConnection http= (HttpURLConnection)url.openConnection(); //establish connection
       http.connect(); //connect and send request to server

        if(http.getResponseCode()>=400)
        {
            System.out.println(http+"====>Broken Link");
            broken_Link_Count++;
        }
        else
        {
            System.out.println(http+"====>Valid Link");
        }} catch (Exception e) {

        }

    }
        System.out.println("no of broken links :"+broken_Link_Count);
    driver.close();
    }
}
