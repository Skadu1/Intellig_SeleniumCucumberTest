package Practice.Grouping;

import org.testng.annotations.Test;

public class SignUpTest {

    @Test(priority=0,groups={"regression"})
    void email()
    {
        System.out.println("using email");
    }
    @Test(priority=1,groups={"regression"})
    void username()
    {
        System.out.println("using username");
    }
}
