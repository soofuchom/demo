package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Css {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 获取测试对象的css属性
	 * 场景：
	 * 当你的测试用例纠结细枝末节的时候，你就需要通过判断元素的css属性来验证你的操作是否达到了预期的效果。
	 * 比如你可以通过判断页面上的标题字号以字体来验证页面的显示是否符合预期。
	 * 当然，这个是强烈不推荐的。因为页面上最不稳定的就是css了，css变动频繁，
	 * 而且通过属性也不能直观的判断页面的显示效果，还不如让人为的去看一眼，大问题一望即知。
	 */
	public static void main(String[] args) throws InterruptedException {
		// 演示了如何获取测试对象的css属性。
		//这个类 通过css的还不明白、color、font
		WebDriver dr = new FirefoxDriver();

		File file = new File("src/Demopage/css.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);

		dr.get(filePath);
		Thread.sleep(1000);
		
        WebElement link = dr.findElement(By.id("tooltip"));
        
        System.out.println(link.getCssValue("color"));//是在firebug 右侧的样式里看到的颜色和字体吗？？
        
        System.out.println(dr.findElement(By.tagName("h3")).getCssValue("font"));

        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();  

	}

}
