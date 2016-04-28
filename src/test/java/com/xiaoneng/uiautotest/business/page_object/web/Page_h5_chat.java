package com.xiaoneng.uiautotest.business.page_object.web;

import com.xiaoneng.uiautotest.base.PageObjectBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author dell
 *	android-sdk 嵌入的h5页面 元素
 */
public class Page_h5_chat extends PageObjectBase {

    public Page_h5_chat(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "default Open Chat Window")
    public WebElement button_openchat;

//    @FindBy(xpath = ".//*[@id='su']")
//    public WebElement searchButton;

}
