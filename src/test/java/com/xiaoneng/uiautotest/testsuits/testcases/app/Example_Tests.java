package com.xiaoneng.uiautotest.testsuits.testcases.app;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.xiaoneng.uiautotest.base.AutoTestBase;
import com.xiaoneng.uiautotest.business.page_object.app.Elements_Example;
import com.xiaoneng.uiautotest.business.page_object.app.android.sdk.Elements_Activity_Main;
import com.xiaoneng.uiautotest.business.page_object.app.android.sdk.Elements_Home;
import com.xiaoneng.uiautotest.business.page_object.app.android.sdk.Elements_h5_sdk;
import com.xiaoneng.uiautotest.business.page_object.app.android.sdk.Elements_h5_sdk_webview;
import com.xiaoneng.uiautotest.business.page_object.web.Page_h5_chat;
import com.xiaoneng.uiautotest.util.Assertion;
import com.xiaoneng.uiautotest.util.Log;


/**
 * @author dell
 *	Demo
 */
public class Example_Tests extends AutoTestBase {
    private Elements_Activity_Main elements_activity_main;
    private Elements_Home elements_home;
    private Elements_h5_sdk elements_h5_sdk; 
    private Elements_h5_sdk_webview elements_h5_sdk_webview ;
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
    	elements_activity_main = new Elements_Activity_Main(driver);
    	elements_home = new Elements_Home(driver);
    	elements_h5_sdk = new Elements_h5_sdk(driver);
    	elements_h5_sdk_webview = new Elements_h5_sdk_webview(driver);
    }

    @Parameters({"test"})
    @Test(priority = 1, groups = {"p0"}, alwaysRun = true)
    public void example(String test) throws Throwable {
        Log.logFlow("登录－点击sdk原生入口");
        operateBase.click(elements_activity_main.sdk_lancher, "点击sdk原生入口");
        Assertion.verifyEquals(elements_home.sdk_destory.getText(), "注销SDK", "到达home页成功");
    }
    @Parameters({"test"})
    @Test(priority = 1, groups = {"p0"}, alwaysRun = true)
    public void exampleWeb(String test) throws Throwable {
        Log.logFlow("登录－点击sdk原生入口");
        operateBase.click(elements_activity_main.h5_lancher, "点击h5原生入口");
        Assertion.verifyEquals(elements_h5_sdk.getClass(),"MainContentActivity.class","到达html5页面");
        operateBase.click(elements_h5_sdk.button_h5_confirm, "点击确定跳转到资讯页面");
        toWebview();
//        System.out.println(driver.toString());
        operateBase.click(elements_h5_sdk_webview.button_openchat, "点击打开聊窗");
        toNative_app();
        Assertion.verifyEquals(elements_home.getClass(), "home说法斯蒂芬.class", "失败");
    }
}
