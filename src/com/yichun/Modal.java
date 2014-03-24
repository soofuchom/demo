package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Modal {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 处理对话框
	 * 场景：
	 * 页面上弹出的对话框是自动化测试经常会遇到的一个问题。
	 * 很多情况下这个弹出的对话框是一个iframe，处理起来有点麻烦，需要进行switch_to操作。
	 * 但现在很多前端框架的对话框都是div形式的，这就让我们的处理变得十分简单了。
	 * 
	 * 处理对话框一般会做下面的一些事情：
	 * 打开对话框
	 * 关闭对话框
	 * 操作对话框中的元素
	 */
	public static void main(String[] args) throws InterruptedException {
		// 如何打开、关闭以及点击对话框中的链接
		WebDriver dr = new FirefoxDriver();
		File file = new File("src/Demopage/pagination.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now access is %s \n",filePath);
		
		dr.get(filePath);
		Thread.sleep(1000);
		
		//获得所有分页的数量
		//-2是因为要去掉上一个和下一个
		//获取元素组长度时，要用findElements().size() 注意是要加"s"的
		int total_pages = dr.findElement(By.className("pagination")).findElements(By.tagName("li")).size() -2 ;
		System.out.printf("Total page is %d\n", total_pages);
		Thread.sleep(1000);


		//取当前页面的url以及当前页面是第几页
		dr.findElement(By.xpath("//div/ul/li[4]/a")).click(); //为何点击完之后，获取的当前页面还是第1页？？
		Thread.sleep(3000);

		WebElement current_page = dr.findElement(By.className("pagination")).findElement(By.className("active"));
		System.out.printf("Current page is %s\n", current_page.getText());

		Thread.sleep(1000);
		System.out.println("browser will be close");
		dr.quit();	

	}

}
