package com.xiaoneng.uiautotest.business.page_object.app.android.sdk;

import com.xiaoneng.uiautotest.base.PageObjectBase;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *MainActivity
 * */
public class Elements_Activity_Main extends PageObjectBase {

    public Elements_Activity_Main(WebDriver driver) {
        super(driver);
    }

    /**
     * 首页－h5入口
     */
    @AndroidFindBy(name = "h5_sdk入口")
    @iOSFindBy(xpath = "xxxx")
    public WebElement h5_lancher;
    /**
     * 首页－h5入口
     */
    @AndroidFindBy(name = "sdk源生入口")
    @iOSFindBy(xpath = "xxxx")
    public WebElement sdk_lancher;
}