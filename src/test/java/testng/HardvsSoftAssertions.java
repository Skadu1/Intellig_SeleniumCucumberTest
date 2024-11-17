package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardvsSoftAssertions
{

    @Test
    void hardAssertion()
    {
        String act="people";
        String exp="girl";
        Assert.assertEquals(act,exp);

        System.out.println("this is testing");

    }


    @Test
    void softAssertion()
    {
        String act="tople";
        String exp="mean";
        SoftAssert sa= new SoftAssert();
        sa.assertEquals(act,exp);

        System.out.println("this is testing");
        sa.assertAll(); //mandatory

    }
}
