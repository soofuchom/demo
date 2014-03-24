package com.yichun;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CookieExample {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function cookie
	 * webdriver可以读取并添加cookie。
	 * 有时候我们需要验证浏览器中是否存在某个cookie，因为基于真实的cookie的测试是无法通过白盒和集成测试完成的。
	 * 另外更加常见的一个场景是自动登陆。
	 * 有很多系统的登陆信息都是保存在cookie里的，因此只要往cookie中添加正确的值就可以实现自动登陆了。
	 * 什么图片验证码、登陆的用例就都是浮云了。
	 * webdriver读写cookie的接口有以下一些：
	 * addCookie(Cookie cookie)。添加cookie，参数是Cookie对象
	 * deleteAllCookies。删除所有cookie
	 * getCookies。返回所有的cookie
	 * deleteCookieNamed(String name)。删除name这个cookie
	 * getCookieNamed(String name)。返回特定name的cookie值
	 */
	public static void main(String[] args) throws InterruptedException {
		//演示了如何自动登陆百度。
		WebDriver dr = new FirefoxDriver();
		String url ="http://www.baidu.com";
		dr.get(url);
		Thread.sleep(2000);
		
		System.out.println(dr.manage().getCookies());
        dr.manage().deleteAllCookies();

	    Cookie c1 = new Cookie("BAIDUID", "XXXXXX");
	    Cookie c2 = new Cookie("BDUSS", "XXXXXX");//这块是啥意思？？
	    dr.manage().addCookie(c1);
	    dr.manage().addCookie(c2);
		Thread.sleep(12000);

	    System.out.println("browser will be close");
	    dr.quit();
	        }
	}

