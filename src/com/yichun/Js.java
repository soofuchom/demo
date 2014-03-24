package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Js {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 执行js
	 * 场景：
	 * 如果你熟悉js的话，那么使用webdriver执行js就是一件很高效的事情了。
	 * 在webdriver脚本中直接执行js的好处很多，这里就不一一枚举了。
	 * 
	 * webdriver提供了JavascriptExecutor(dr).executeScript()接口来帮助我们完成这一工作。在实际的测试脚本中，以下两种场景是经常遇到的
	 * 在页面直接执行一段js
	 * 在某个已经定位的元素的上执行js
	 */
	public static void main(String[] args) throws InterruptedException {
		// 演示了如何在页面以及在已经定位的元素上执行js
		//JS这个类不明白
		WebDriver dr = new FirefoxDriver();

		File file = new File("src/Demopage/js.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);

		dr.get(filePath);
		Thread.sleep(1000);
		
	    //在页面上直接执行js
        ((JavascriptExecutor)dr).executeScript("$('#tooltip').fadeOut();");//fadeOut() 方法使用淡出效果来隐藏被选元素
        Thread.sleep(1000);

        //在已经定位的元素上执行js
        WebElement button = dr.findElement(By.className("btn"));
        ((JavascriptExecutor)dr).executeScript("$(arguments[0]).fadeOut();", button);//在已经定位的元素上执行js，()后面就加上元素名


        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();  
    }
}
