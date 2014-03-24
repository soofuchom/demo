package com.yichun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TitleAndUrl {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 打印当前页面的title及url
	 * 获取当前页面的url也是非常重要的一个操作。在某些情况下，你访问一个url，这时系统会自动对这个url进行跳转，这就是所谓的'重定向'。
	 * 一般测试重定向的方法是访问这个url，然后等待页面重定向完毕之后，获取当前页面的url，判断该url是否符合预期。
	 * 另外的一个常见的测试场景是提交了一个表单，如果表单内容通过了验证，那么则会跳转到一个新页面，
	 * 如果未通过验证，则会停留在当前页面，此时获取当前页面的url则可以帮助我们判断表单提交的跳转是否符合预期。
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new FirefoxDriver();
		Thread.sleep(2000);
		String url ="http://www.baidu.com";
		System.out.printf("now access %s \n",url);
		dr.get(url);
		Thread.sleep(2000);
		System.out.printf("title of current page is %s\n",dr.getTitle());
		System.out.printf("url of current page is %s\n",dr.getCurrentUrl());
		System.out.println("browser will be close");
		dr.quit();

	}

}
