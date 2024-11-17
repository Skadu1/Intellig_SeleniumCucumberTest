package testng.grouping;

import org.testng.annotations.Test;

public class LoginTest {

    @Test(priority=3,groups={"sanity"})
    void instaLogin()
    {
        System.out.println("instalogin");
    }
    @Test(priority=4,groups={"sanity"})
    void fbLogin()
    {
        System.out.println("fblogin");
    }
}
