package com.epam.Task1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Mariya_Belemenko on 6/21/2016.
 */
public class TestClass {
    @Test
    public void sum() {
        int a = 2;
        int b = 2;
        int res = 4;
        Assert.assertEquals(a + b, res, "The sum is not equal to " + res);
    }
}
