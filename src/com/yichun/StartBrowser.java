package com.yichun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class StartBrowser {

	/**
	 * @author fc_song
	 * @function 启动浏览器
	 */
	public static void main(String[] args) {
		// 使用谷歌、IE浏览器时，需要提前下载相应浏览器驱动，FF不需要
		WebDriver dr = new FirefoxDriver(); //使用火狐浏览器
//		WebDriver dr1 = new ChromeDriver(); //使用谷歌浏览器
//		WebDriver dr2 = new InternetExplorerDriver();//使用IE浏览器


	}

}
