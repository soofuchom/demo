package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Upload {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 上传文件
	 * 场景：
	 * 上传文件的方法是找到上传文件的对象，通常是的对象。
	 * 然后直接往这个对象sendKeys，传入需要上传文件的正确路径。
	 * 绝对路径和相对路径都可以，但是上传的文件必须存在，否则会报错。
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver dr = new FirefoxDriver();

		File file = new File("src/Demopage/upload_file.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);

		dr.get(filePath);
		Thread.sleep(1000);
		
		dr.findElement(By.name("file")).sendKeys("src/Demopage/upload_file.html");
		System.out.println("成功上传第一个文件！");
		Thread.sleep(5000);
		dr.findElement(By.name("file")).sendKeys("C:/Documents and Settings/宋福春/桌面/1013/TestBaidu1.java");
		System.out.println("成功上传第二个文件！");
        Thread.sleep(5000);
        System.out.println("browser will be close");
        dr.quit();  
		
	}

}
