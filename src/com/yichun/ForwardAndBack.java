package com.yichun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ForwardAndBack {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 前进和后退
	 * 这两个功能一般不太常用。所能想到的场景大概也就是在几个页面间来回跳转，省去每次都get url
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new FirefoxDriver();
		Thread.sleep(2000);
		String firstUrl = "http://www.baidu.com";
		System.out.printf("now access %s \n",firstUrl);
		dr.get(firstUrl);
		Thread.sleep(1000);
		
		String secondUrl = "www.soso.com";
		System.out.printf("now access %s \n",secondUrl);
		dr.get(secondUrl);
		Thread.sleep(1000);
		
		System.out.printf("now back to %s \n",firstUrl);
		dr.navigate().back();
		Thread.sleep(1000);
		
		System.out.printf("forward to %s \n",secondUrl);
		dr.navigate().forward();
		Thread.sleep(1000);
		
		System.out.println("browser will be close");
		dr.quit();
		
		


	}

}
