package Practice.Grouping;

import org.testng.annotations.Test;

public class ProductTest {

    @Test(priority=5,groups={"sanity","regression","functional"})
    void watch()
    {
        System.out.println("adding watch");
    }
    @Test(priority=6,groups={"sanity","regression","functional"})
    void shoe()
    {
        System.out.println("adding shoe");
    }
}
