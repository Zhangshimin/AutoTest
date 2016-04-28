package com.xiaoneng.uiautotest.testsuits.testdata;

import org.testng.annotations.DataProvider;

/**
 * 备用--数据提供
 */
public class Example_data {
    @DataProvider(name = "Example_data")
    public static Object[][] loginData_error() {
        return new Object[][] {
                {
                        new String("test1"),
                        new String("test2")
                }
        };
    }
}
