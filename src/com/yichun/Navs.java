package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navs {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @fuction 处理navs/导航
	 * navs可以看作是简单的类似于tab的导航栏。
	 * 一般来说导航栏都是ul+li。先定位ul再去层级定位li中的link基本就能解决问题。
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new FirefoxDriver();
		File file = new File("src/Demopage/navs.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now access is %s \n",filePath);
		
		dr.get(filePath);
		Thread.sleep(1000);
//		方法1：层级定位，先定位ul再定位li
		dr.findElement(By.className("nav")).findElement(By.linkText("About")).click();
		Thread.sleep(5000);

//		方法2: 直接定位link
		dr.findElement(By.linkText("Home")).click();
		Thread.sleep(5000);

		Thread.sleep(1000);
		System.out.println("browser will be close");
		dr.quit();
	}

}
