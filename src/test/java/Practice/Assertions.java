package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {

    @Test
    void titleTest()
    {
        String act_value="snapshot";
        String exp_value="snapshot";
//        Assert.assertEquals(act_value,exp_value,"test case failed");
        if(act_value.equals(exp_value))
        {
//            System.out.println("test is passed");
            Assert.assertTrue(true); //pass
            //Assert.assertTrue(1=1);//pass
           // Assert.assertFalse(false); //pass
        }
        else
        {
//            System.out.println("test is failed");
            Assert.assertTrue(false,"test failed"); //fail
           // Assert.assertTrue(1=2);//fail
           // Assert.assertFalse(true);//fail
        }

        Assert.fail(); // to fail a test case without checking conditions
    }
}
