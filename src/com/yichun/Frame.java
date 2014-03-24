package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frame {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 定位frame中的元素
	 * 处理frame需要用到2个方法，分别是switchTo().frame(element|index|id)和switchTo.defaultContent();
	 * 
	 * switchTo().frame()方法的参数值得一提。其支持
	 * WebElement， 可以传入一个已经定位的frame元素。如 switchTo().frame(dr.findElement(By.id("myFrame")))
	 * int index， 可以传入页面上frame的索引，如0表示第1个frame
	 * String id, 可以传入frame的id
	 * 
	 * switchTo().frame()方法把当前定位的主体切换了frame里。
	 * 怎么理解这句话呢？我们可以从frame的实质去理解。
	 * frame中实际上是嵌入了另一个页面，而webdriver每次只能在一个页面识别，
	 * 因此才需要用switch_to.frame方法去获取frame中嵌入的页面，对那个页面里的元素进行定位。
	 * switchTo.defaultContent方法的话则是从frame中嵌入的页面里跳出，跳回到最外面的原始页面中。
	 * 如果页面上只有1个frame的话那么这一切都是很好理解的，但如果页面上有多个frame，情况有稍微有点复杂了。
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver dr = new FirefoxDriver();

		File file = new File("src/Demopage/frame.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);

		dr.get(filePath);
		Thread.sleep(1000);
		
		//先到f1再到f2 先定位到 f1的frame
		//如果嵌套frame的话，一定要先跳到外层的frame后再跳到内层的frame
		dr.switchTo().frame("f1");
		dr.switchTo().frame("f2");
		dr.findElement(By.id("kw1")).sendKeys("hello");
		Thread.sleep(1000);

		//直接跳出所有的frame
		dr.switchTo().defaultContent();
		
		//再到f1
		dr.switchTo().frame("f1");
		dr.findElement(By.linkText("click"));
		
		Thread.sleep(1000);
		System.out.println("browser will be close");
		dr.quit();

		
		
	}

}
