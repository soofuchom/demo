package com.yichun;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertExample {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 处理alert/confirm/prompt
	 * 场景：
	 * webdriver中处理原生的js alert confirm 以及prompt是很简单的。
	 * 具体思路是使用switch_to.alert()方法定位到alert/confirm/prompt。然后使用text/accept/dismiss/send_keys按需进行操作：
	 * getText。返回alert/confirm/prompt中的文字信息
	 * accept。点击确认按钮
	 * dismiss。点击取消按钮，如果有的话
	 * sendKeys。向prompt中输入文字
	 */
	public static void main(String[] args) throws InterruptedException {
		//alert是HTML语言的弹出框中的一种方法
		
		WebDriver dr = new FirefoxDriver();
		
		File file = new File("src/Demopage/alert.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);

		dr.get(filePath);
		Thread.sleep(1000);
		
		//点击链接弹出alert
        dr.findElement(By.id("tooltip")).click();
        
        Alert alert = dr.switchTo().alert();
        alert.accept();
        
        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();  
	}

}
