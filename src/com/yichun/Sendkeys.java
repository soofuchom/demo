package com.yichun;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Sendkeys {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function send keys模拟按键输入
	 * sendKeys方法可以模拟一些组合键操作，比如ctrl+a等。
	 * 另外有时候我们需要在测试时使用tab键将焦点转移到下一个元素，这时候也需要sendKeys。
	 * 在某些更复杂的情况下，还会出现使用sendKeys来模拟上下键来操作下拉列表的情况。
	 */
	public static void main(String[] args) throws InterruptedException {
		//演示了如何将A多行文本框中的内容清空并复制到B文本框中。
		WebDriver dr = new FirefoxDriver();
		File file = new File("src/Demopage/send_keys.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now access is %s \n",filePath);
		
		dr.get(filePath);
		Thread.sleep(1000);
		
		//全部选中A文本框里的内容
		// copy content of A
		dr.findElement(By.id("A")).sendKeys(Keys.chord(Keys.CONTROL + "a"));
		Thread.sleep(3000);
		System.out.println("A文本框里的内容已处于全部选中状态");
		dr.findElement(By.id("A")).sendKeys(Keys.chord(Keys.CONTROL + "x"));
		Thread.sleep(3000);
		System.out.println("A文本框里的内容已处于全部剪切中状态");
		//paste to B
		dr.findElement(By.id("B")).sendKeys(Keys.chord(Keys.CONTROL + "v"));
		Thread.sleep(3000);
		System.out.println("A文本框里的内容已粘贴到文本框B中");
		dr.findElement(By.id("A")).sendKeys("123456");
		
        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();  
		
		
		
		
		
	}

}
