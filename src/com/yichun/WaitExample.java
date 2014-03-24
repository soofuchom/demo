package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExample {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function Wait
	 * 场景：
	 * Wait类的使用场景是在页面上进行某些操作，然后页面上就会出现或隐藏一些元素，
	 * 此时使用WebDriverWait类的until方法来等待这些效果完成以便进行后续的操作。
	 * 另外页面加载时有可能会执行一些ajax，这时候也需要去WebDriverWait的until的等待ajax的请求执行完毕。
	 * 具体一点的例子前面也曾出现过，点击一个链接然后会出现一个下拉菜单，此时需要先等待下拉菜单出现方可进行点击菜单项的操作。
	 * 在实例化WebDriverWait类时，有下面2个构造方法
	 * public WebDriverWait(WebDriver driver, long timeOutInSeconds)
	 * public WebDriverWait(WebDriver driver, long timeOutInSeconds, long sleepInMillis)
	 * 其参数为
	 * WebDriver driver。不言而喻
	 * long timeOutInSeconds。总体的超时时间，最多等这么久。
	 * long sleepInMillis。每隔多久去检查一次until的结果
	 * 另外要注意的是，默认情况下，unitl中的NotFoundException会被忽略，但是其他异常还是正常传播的。
	 * 你可以通过ignoring(exceptions to add)自己定义需要忽略的异常。
	 */
	public static void main(String[] args) throws InterruptedException {
		// 演示了点击按钮后如何等待label出现。这个例子其实没有前面的下拉菜单例子实用
		WebDriver dr = new FirefoxDriver();

		File file = new File("src/Demopage/wait.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);

		dr.get(filePath);
		Thread.sleep(1000);
		
        dr.findElement(By.id("btn")).click();
        (new WebDriverWait(dr,10)).until(new ExpectedCondition<Boolean>(){
        	public Boolean apply(WebDriver d){
        			return d.findElement(By.className("label")).isDisplayed();
        	}
        });
        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();  
	}

}
