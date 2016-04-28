package com.xiaoneng.uiautotest.business.page_object.app.android.sdk;

import com.xiaoneng.uiautotest.base.PageObjectBase;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *home--登陆页面 second
 * */
public class Elements_Home extends PageObjectBase {

    public Elements_Home(WebDriver driver) {
        super(driver);
    }

    /**
     * 注销sdk
     */
    @AndroidFindBy(id = "com.example.androidsdk:id/destory")
    @iOSFindBy(xpath = "xxxx")
    public WebElement sdk_destory;
    /**
     * userid
     */
    @AndroidFindBy(id = "com.example.androidsdk:id/userid")
    @iOSFindBy(xpath = "xxxx")
    public WebElement input_userid;
    /**
     * username
     */
    @AndroidFindBy(id = "com.example.androidsdk:id/username")
    @iOSFindBy(xpath = "xxxx")
    public WebElement input_username;
}