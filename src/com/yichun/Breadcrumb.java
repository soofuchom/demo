package com.yichun;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Breadcrumb {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 处理面包屑
	 * 面包屑导航的作用是告诉访问者他们目前在网站中的位置以及如何返回。
	 * 处理面包屑主要是获取其层级关系，以及获得当前的层级。
	 * 一般来说当前层级都不会是链接，而父层级则基本是以链接，所以处理面包屑的思路就很明显了。
	 * 找到面包屑所在的div或ul，然后再通过该div或ul找到下面的所有链接，这些链接就是父层级。
	 * 最后不是链接的部分就应该是当前层级了。
	 * "Home /Library /Data"
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new FirefoxDriver();
		File file = new File("src/Demopage/breadcrumb.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now access is %s \n",filePath);
		
		dr.get(filePath);
		Thread.sleep(1000);
		
		//List<WebElement> ~ findElements
		List<WebElement> ancestors = dr.findElement(By.className("breadcrumb")).findElements(By.tagName("a"));
		for(WebElement link : ancestors){
			System.out.println(link.getText());//getText获取当前元素的值
		}
		Thread.sleep(5000);
		
//		获取当前层级，层级定位
//		由于页面上可能有很多class为active的元素
//		所以使用层级定位最为保险
		WebElement current = dr.findElement(By.className("breadcrumb")).findElement(By.className("active"));
		System.out.println(current.getText());

		Thread.sleep(1000);
		System.out.println("browser will be close");
		dr.quit();

	}

}
