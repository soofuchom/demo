package com.yichun;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Form {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @funtion form的操作
	 * 场景：
	 * 表单对象的操作比较简单，只需要记住下面几点
	 * 1、使用sendKeys方法往多行文本框和单行文本框赋值；
	 * 2、使用click方法选择checkbox
	 * 3、使用click方法选择radio
	 * 4、使用click方法点击button
	 * 5、使用click方法选择option，从而达到选中select下拉框中某个具体菜单项的效果
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver dr = new FirefoxDriver();

		File file = new File("src/Demopage/form.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);

		dr.get(filePath);
		Thread.sleep(1000);
		
		//选中checkbox
		//By Css的定位不会写
		dr.findElement(By.cssSelector("input[type=checkbox]")).click();
		System.out.println(dr.findElement(By.cssSelector("input[type=checkbox]")).isSelected());
		Thread.sleep(1000);
		
		//选中radio
		dr.findElement(By.cssSelector("input[type=radio]")).click();
		System.out.println(dr.findElement(By.cssSelector("input[type=radio]")).isSelected());
		Thread.sleep(1000);
		
		//选择下拉菜单中的最后一项
		List<WebElement> options = dr.findElement(By.tagName("select")).findElements(By.tagName("option"));
		options.get(options.size()-1).click();//定位到元素组内最后一个元素，并点击		
		Thread.sleep(1000);
		
		//点击提交按钮
		dr.findElement(By.cssSelector("input[type=submit]")).click();
//		dr.findElement(By.className("btn")).click();
		
		// 用如下方法获取Alert上的Message
		Alert alert = dr.switchTo().alert();
		System.out.println(alert.getText());//输出点击提交后，弹出框内容
		alert.accept();//点击弹出框确定按钮

		Thread.sleep(1000);
		System.out.println("browser will be close");
		dr.quit();

		
		
		
		
		
	}

}
