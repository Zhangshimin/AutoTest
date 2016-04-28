package com.xiaoneng.uiautotest.business.page_object.app.android.sdk;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.xiaoneng.uiautotest.base.PageObjectBase;

/**
 *Elements_h5_sdk_webview
 * */
public class Elements_h5_sdk_webview extends PageObjectBase {
//	private AndroidDriver<WebElement> androiddriver;
    public Elements_h5_sdk_webview(WebDriver driver) {
        super(driver);
//        androiddriver = (AndroidDriver<WebElement>) driver;
//       Set<String> contextNames = androiddriver.getContextHandles(); //system.print(contextNames);
//        [NATIVE_APP, WEBVIEW_com.sohu.inputmethod.sogou:push_service, WEBVIEW_com.tencent.mobileqq, WEBVIEW_com.example.androidsdk, WEBVIEW_com.youloft.calendar]
        //WEBVIEW_com.example.androidsdk  webwiew名称
//        androiddriver.context("WEBVIEW_com.example.androidsdk");
//        toWebview();

    }
    /**
     * 测试webview，首先转到对应的webview，，找完元素后转换回
     */
//    public void toWebview() {
//    	androiddriver.context("WEBVIEW_com.example.androidsdk");
//	}
//    public void toNative_app() {
//    	androiddriver.context("NATIVE_APP");
//	}
  
    
    /**
     * webview打开聊窗
     */
    @FindBy(id = "openchat")
    public WebElement button_openchat;
}