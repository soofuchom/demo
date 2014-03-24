package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Attribute {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 获取测试对象的属性及内容
	 * 场景：
	 * 获取测试对象的内容是前端自动化测试里一定会使用到的技术。
	 * 比如我们要判断页面上是否显示了一个提示，那么我们就需要找到这个提示对象，
	 * 然后获取其中的文字，再跟我们的预期进行比较。
	 * 在webdriver中使用element.getAttribute()方法可以获取dom元素(测试对象)的属性。
	 * 测试对象的属性：getAttribute();
	 * 
	 * 获取测试对象的属性能够帮我们更好的进行对象的定位。
	 * 比如页面上有很多class都是'btn'的div，而我们需要定位其中1个有具有title属性的div。
	 * 由于selenium-webdriver是不支持直接使用title来定位对象的，所以我们只能先把所有class是btn的div都找到，
	 * 然后遍历这些div，获取这些div的title属性，一旦发现具体title属性的div，那么返回这个div既可。
	 * 在webdriver中，使用element.getText()方法可以返回dom节点的内容(text)。
	 * 对象的文字内容：getText();
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver dr = new FirefoxDriver();

		File file = new File("src/Demopage/attribute.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);

		dr.get(filePath);
		Thread.sleep(1000);
		
		//***重要：<a id="tooltip" title="" data-toggle="tooltip" href="#" data-original-title="watir-webdriver better than selenium-webdriver">hover to see tooltip</a>
		//getAttribute()方法是获取DOM属性的值，比如id/title/data-toggle/data-original-title
		//getText()方法是获取文本的值，hover to see tooltip****
		
		WebElement link = dr.findElement(By.id("tooltip"));
		//获得tooltip的内容
		System.out.println(link.getAttribute("data-original-title"));
		System.out.println(link.getAttribute("id"));
		System.out.println(link.getAttribute("title"));
		System.out.println(link.getAttribute("data-toggle"));
		System.out.println(link.getAttribute("href"));


		
		//获取该链接的text
		System.out.println(link.getText());
	    
		Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();  

	}
	

}
