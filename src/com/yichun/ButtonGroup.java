package com.yichun;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ButtonGroup {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 处理button group
	 * button group就是按钮组，将一组按钮排列在一起。
	 * 处理这种对象的思路一般是先找到button group的包裹(wrapper)div，然后通过层级定位，用index或属性去定位更具体的按钮。
	 * ===============自己查资料搞清楚detect方法的作用。===============
	 */
	public static void main(String[] args) throws InterruptedException {
		//演示了如何找到second这个按钮。其处理方法是先找到button group的父div，class为btn-group的div，
		//然后再找到下面所有的div(也就是button)，返回text是second的div。
		WebDriver dr = new FirefoxDriver();

		File file = new File("src/Demopage/button_group.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now access %s \n", filePath);
		
		dr.get(filePath);
		Thread.sleep(1000);
		
		//定位text是second的按钮
		List<WebElement> btns = dr.findElement(By.className("btn-group")).findElements(By.className("btn"));
		
		for(WebElement btn : btns){
			if (btn.getText().equals("second")){
				btn.click();
				System.out.println("second button已点击！");
				break;
			}
		}
		
        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();  
		
	}

}
