package com.yichun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Get {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 访问链接
	 * webdriver的api里有2种访问url的方式，分别是get和navigate.to方法。
	 * 一般情况下建议使用get，因为其字母比较少，不太容易出错。
	 * navigate方法实际上会产生1个Navigator对象，其封装了与导航相关的一些方法，比如前进后退等。
	 */
	public static void main(String[] args) throws InterruptedException {
		  WebDriver dr = new FirefoxDriver();
		  String url1 = "http://www.baidu.com";
		  String url2 = "http://www.qq.com";
		  //get方法
		  dr.get(url1);
		  System.out.printf("now access %s \n", url1);
		  Thread.sleep(2000);
		  System.out.println("成功进入百度首页");
//		  dr.close();  //注意：此处不能用close close了就干不了别的了，销毁了的对象就用不了了
		  //navigate方法
		  dr.navigate().to(url2);
		  System.out.printf("now access %s \n", url2);
		  System.out.println("成功进入腾讯网首页");
	}

}
