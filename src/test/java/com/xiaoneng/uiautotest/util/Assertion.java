package com.xiaoneng.uiautotest.util;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

/**
 * @author dell
 *	断言
 */
public class Assertion {

    public static boolean flag = true;
    public static List<Error> errors = new ArrayList<Error>();
    /**
     * 比较两个对象是否一致。
     *
     * @param actual   the actual object.
     * @param expected the expected object.
     */
    public static void verifyEquals(Object actual, Object expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Error e) {
        	errors.add(e);
            flag = false;
        }
    }

    /**
     * 比较两个对象是否一致。
     *
     * @param actual   the actual object.
     * @param expected the expected object.
     * @param message  the message for description.
     */
    public static void verifyEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (Error e) {
        	errors.add(e);
        	Log.logError(message);
            flag = false;
        }
    }

}
