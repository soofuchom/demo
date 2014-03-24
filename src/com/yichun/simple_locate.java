package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class simple_locate {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 简单的对象定位
	 * 定位对象的目的一般有下面几种：操作对象，获得对象的属性(如获得测试对象的class属性、name属性等等)，获得对象的text，获得对象的数量
	 * webdriver提供了对象定位方法，常用的	有以下几种：id、name、class name、link text、partial link text、tag name、xpath、css selector
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new FirefoxDriver();
		//声明一个文件对象，以及文件存放的相对路径
		File file = new File("src/Demopage/simple_form.html");
		//获取文件绝对路径
		String filePath = "file:///"+file.getAbsolutePath();
		//获取文件名字
		String fileName=file.getName();
		System.out.printf("now access %s \n",filePath);
		System.out.printf("file name is %s \n",fileName);
		dr.get(filePath);
		Thread.sleep(5000);
		//by id
		dr.findElement(By.id("inputEmail")).sendKeys("qhdsfc@126.com");
		Thread.sleep(1000);
		
		//by name
		dr.findElement(By.name("password")).sendKeys("123456");
		Thread.sleep(1000);
		
		//by tagname
		//获取标签是form,的class属性
		String classOfForm = dr.findElement(By.tagName("form")).getAttribute("class");
		System.out.printf("%s \n",classOfForm);
		Thread.sleep(1000);
		
		//by link text
		WebElement link = dr.findElement(By.linkText("register"));
		((JavascriptExecutor)dr).executeScript("$(arguments[0]).fadeOut().fadeIn()", link);//啥意思？
		Thread.sleep(1000);
		
	/*	WebDriver中可以使用JavaScript，通地使用JavascriptExector对象
	 *  首先要通过向下转型 JavascriptExecutor js = (JavascriptExecutor) driver; 转为JavascriptExector对象
	 *  然后再调用executeScript()方法来执行JS。
	 *  由于html文件中引用了jquery，所以在执行js时可以使用jquery的$()及fadeIn()等方法。如果你测试的页面没用包含jquery的话，这些方法是无效的。
	 */
		

		//by partial link test
		//根据链接的部分文字
		WebElement sameLink = dr.findElement(By.partialLinkText("reg"));
		((JavascriptExecutor)dr).executeScript("$(arguments[0]).fadeOut().fadeIn()", sameLink);//这句啥意思？JS
		
	    //by css selector  CSS不会
        WebElement div = dr.findElement(By.cssSelector(".controls"));
        ((JavascriptExecutor)dr).executeScript("$(arguments[0]).fadeOut().fadeIn()", div);
        Thread.sleep(1000);
        
        //by xpath
        dr.findElement(By.xpath("/html/body/form/div[3]/div/label/input")).click();
        Thread.sleep(1000);
        
        System.out.println("browser will be close");
        dr.quit();
        

	}

}
