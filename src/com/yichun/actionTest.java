package com.yichun;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class actionTest {

	/**
	 * @author fc_song
	 * @function action
	 * 场景：
	 * 由于webdriver是要模拟真实的用户操作，因此webdriver的Action类中提供了很多与操作有关的方法。
	 * 下面列举一下Action类的一些主要方法:
	 * keyDown。模拟按键按下
	 * keyUp。模拟按键弹起
	 * click
	 * sendKeys
	 * doubleClick。鼠标左键双击
	 * clickAndHold。鼠标左键点击住不放
	 * release。鼠标左键弹起，可以与click_and_hold配合使用
	 * moveToElement。把鼠标移动到元素的中心点
	 * contextClick。鼠标右键点击
	 * dragAndDrop。拖拽
	 */
	public static void main(String[] args) {
		// 具体使用方法可以参考api文档。action的api文档算是比较全面了
		// 看API
		WebDriver dr = new FirefoxDriver();
		
		dr.get("file:///D:/demo/demo.html");
		
		
		
		Actions action = new Actions(dr);
//		action.keyDown(Keys.SHIFT).
//		              click(dr.findElement(By.linkText("baidu"))).
//		              click(dr.findElement(By.id("radio")).findElement(By.className("Volvo"))).
////		              keyUp(Keys.SHIFT).
////		              dragAndDrop(element, third_element).
//		                            build().
//		              perform();
		
		
		WebElement user = dr.findElement(By.id("user"));
		List<WebElement> options = dr.findElement(By.name("select")).findElements(By.tagName("option"));
		for(WebElement option : options){
			if(option.getText().equals("opel")){
				option.click();
				break;
			}
		}
		
	}

}
