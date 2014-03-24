package com.yichun;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Pagination {
	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 处理对话框
	 * 面包屑导航: 最右端的地址为当前浏览页，最左端的为起始页面，这种结构使得用户对于所访问页的层次结构一目了然。
	 * 处理面包屑主要是获取其层级关系，以及获得当前的层级。
	 * 一般来说当前层级都不会是链接，而父层级则基本是以链接，所以处理面包屑的思路就很明显了。
	 * 找到面包屑所在的div或ul，然后再通过该div或ul找到下面的所有链接，这些链接就是父层级。
	 * 最后不是链接的部分就应该是当前层级了
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new FirefoxDriver();

		File file = new File("src/Demopage/pagination.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);

		dr.get(filePath);
		Thread.sleep(1000);

//		获得所有分页的数量
//		-2是因为要去掉上一个和下一个
		//findElements 一组元素集合的长度  .siza();
		int total_pages = dr.findElement(By.className("pagination")).findElements(By.tagName("li")).size() - 2;
		System.out.printf("Total page is %d\n", total_pages);

//		取当前页面的url以及当前页面是第几页
		WebElement current_page = dr.findElement(By.className("pagination")).findElement(By.className("active"));
		System.out.printf("Current page is %s\n", current_page.getText());

		Thread.sleep(1000);
		System.out.println("browser will be close");
		dr.quit();	
	}

}
