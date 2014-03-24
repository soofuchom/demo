package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Status {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 获取测试对象的状态
	 * 场景：
	 * 在web自动化测试中，我们需要获取测试对象的四种状态
	 * 1、是否显示。使用element.isDisplayed()方法；
	 * 2、是否存在。使用findElement方法，捕获其抛出的异常，如果是NoSuchElementException的话则可以确定该元素不存在；
	 * 3、是否被选中。一般是判断表单元素，比如radio或checkbox是否被选中。使用element.isSelected()方法；
	 * 4、是否enable，也就是是否是灰化状态。使用element.isEnabled()方法
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver dr = new FirefoxDriver();

		File file = new File("src/Demopage/status.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.printf("now accesss %s \n", filePath);

		dr.get(filePath);
		Thread.sleep(1000);
		
		WebElement textField = dr.findElement(By.name("user"));
		System.out.println(textField.getAttribute("placeholder"));
		
		System.out.println(textField.isEnabled()); //false
		
	    //直接用isEnabled方法去判断该button的话返回的会是true
	    //这是因为button是使用css方法去disabled的，并不是真正的disable
	    //这时候需要判断其class里是否有disabled这值来判断其是否处于disable状态?? 这块不太明白
	    System.out.println(dr.findElement(By.className("btn")).isEnabled());
	    
	    //隐藏掉textField
	    //判断其是否显示    js $(arguments[0]).hide()是什么意思？
        ((JavascriptExecutor)dr).executeScript("$(arguments[0]).hide()", textField);
        System.out.println(textField.isDisplayed());
        
        //使用click方法选择raido
        WebElement radio = dr.findElement(By.name("radio"));
        radio.click();
        System.out.println(radio.isSelected());//判断radio是否是处于选中状态
        
        //isSelected()、isDisplayed()、isEnabled()都是返回true或者false
        
        try{
            dr.findElement(By.id("none"));
        } catch(NoSuchElementException e){  //没有找到这个元素
            System.out.println("element does not exist");
        }

        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();

	}

}
