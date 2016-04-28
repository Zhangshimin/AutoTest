package com.xiaoneng.uiautotest.business.page_object.app.android.sdk;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.xiaoneng.uiautotest.base.PageObjectBase;

/**
 *MainActivity
 * */
public class Elements_h5_sdk extends PageObjectBase {

    public Elements_h5_sdk(WebDriver driver) {
        super(driver);
//        AndroidDriver<WebElement> androiddriver = (AndroidDriver<WebElement>) driver;
//        Set<String> contextNames = androiddriver.getContextHandles(); //system.print(contextNames);
//        System.out.println(contextNames);
    }

    /**
     * h5-button-确认
     */
    @AndroidFindBy(name = "确认")
    @iOSFindBy(xpath = "xxxx")
    public WebElement button_h5_confirm;
    /**
     * h5-input-输入网址
     */
    @AndroidFindBy(id = "com.example.androidsdk:id/et_h5")
    @iOSFindBy(xpath = "xxxx")
    public WebElement input_h5_weburl;
    
}