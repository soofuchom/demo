package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonDropdown {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 处理button dropdown
	 * 场景：
	 * button dropdown就是把按钮和下拉菜单弄到了一起。
	 * 处理这种对象的思路一般是先点击这个按钮，等待下拉菜单显示出来，然后使用层级定位方法来获取下拉菜单中的具体项
	 */
	public static void main(String[] args) throws InterruptedException {
		// 演示了如何找到watir-webdriver这个菜单项。
		// 其处理方法是先点击info按钮，然后等到下拉菜单出现后定位下拉菜单的ul元素，
		// 再定位ul元素中link text为watir-webdriver的link，并点击之
		WebDriver dr = new FirefoxDriver();
		File file = new File("src/Demopage/button_dropdown.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now access is %s \n",filePath);
		
		dr.get(filePath);
		Thread.sleep(1000);
//		定位text是watir-webdriver的下拉菜单
//		首先显示下拉菜单
		dr.findElement(By.linkText("Info")).click();
		
		/*
		 * 代码WebDriverWait类的构造方法接受了一个WebDriver对象和一个等待最长时间（10秒）。
		 * 然后调用until方法，其中重写了ExpectedCondition接口中的apply方法，让其返回一个WebElement,即加载完成的元素，然后判断是否显示。
		 * 默认情况下，WebDriverWait每500毫秒调用一次ExpectedCondition，直到有成功的返回，当然如果超过设定的值还没有成功的返回，将抛出异常。
		 */
		(new WebDriverWait(dr, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d){
				return d.findElement(By.className("dropdown-menu")).isDisplayed();
			}
		});
//		通过ul再层级定位
		dr.findElement(By.className("dropdown-menu")).findElement(By.linkText("watir-webdriver")).click();
		System.out.println("点击Info弹出层后，再点击watir-webdriver");

		Thread.sleep(5000);
		System.out.println("browser will be close");
		dr.quit();

	}

}
