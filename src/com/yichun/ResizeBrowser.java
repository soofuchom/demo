package com.yichun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ResizeBrowser {

	/**
	 * @author fc_song
	 * @function 设置浏览器大小
	 * webdriver提供了很多调整浏览器窗口的接口，比如move_to(移动窗口)，position(设置或获取浏览器的位置)。在一般情况下这些功能并不常用。
	 */
	public static void main(String[] args) {
		WebDriver dr = new FirefoxDriver();
		dr.manage().window().setSize(new Dimension(600,400)); //将浏览器的大小自定义为600*400
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		dr.get("http://www.baidu.com");
		System.out.println("成功打开百度页面，浏览器窗口大小是600*400");
		dr.quit();
		
	}

}
