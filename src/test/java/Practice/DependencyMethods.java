package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods
{

    @Test(priority = 0)
    void openApp()
    {
        Assert.assertTrue(true);
    }


    @Test(priority = 1, dependsOnMethods = {"openApp"})
    void login()
    {
        Assert.assertTrue(false);
    }

    @Test(priority = 2,dependsOnMethods = {"login","openApp"})
    void search()
    {
        Assert.assertTrue(true);
    }

    @Test(priority = 3)
    void logout()
    {
        Assert.assertTrue(true);
    }

}
