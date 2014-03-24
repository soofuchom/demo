package com.yichun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CloseBrowser {

	/**
	 * @author fc_song
	 * @function 关闭浏览器
	 * @Comment:关闭浏览器有两种方式：close方法 、quit方法
	 * close方法关闭当前的浏览器窗口，quit方法不仅关闭窗口，还会彻底的退出webdriver，释放与driver server之间的连接。
	 * 所以简单来说quit是更加彻底的close，quit会更好的释放资源，适合强迫症和完美主义者。
	 */
	public static void main(String[] args) {
		WebDriver dr = new FirefoxDriver();
		System.out.println("browser will be closed");
		dr.quit();
		System.out.println("browser is closed");
	}

}
