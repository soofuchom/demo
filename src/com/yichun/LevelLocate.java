package com.yichun;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LevelLocate {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function 层级定位
	 * 页面上有很多个属性基本相同的元素，现在需要具体定位到其中的一个。
	 * 由于属性基本相当，所以在定位的时候会有些麻烦，这时候就需要用到层级定位。
	 * 先定位父元素，然后再通过父元素定位子孙元素
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new FirefoxDriver();
//
        File file = new File("src/Demopage/level_locate.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now access %s \n", filePath);

        dr.get(filePath);
        Thread.sleep(1000);
        dr.findElement(By.linkText("Link1")).click();
        

        (new WebDriverWait(dr, 10)).until(new ExpectedCondition<Boolean>(){//什么意思？
            public Boolean apply(WebDriver d){
                return d.findElement(By.id("dropdown1")).isDisplayed();
            }
        } );
        Thread.sleep(5000);
        /*
         * 一个显式等待就是在继续执行代码之前编码等待定义一个特定条件发生。
         * 最糟糕的例子是Thread.sleep()，这设置了一个准确的等待时间。
         * WebDriver提供了一些方便的方法帮助您些代码来等待要求的时间。
         * WebDriverWait和ExpectedCondition的结合就是一种实现的方法。
         */
        WebElement menu = dr.findElement(By.id("dropdown1")).findElement(By.linkText("Another action"));
        (new Actions(dr)).moveToElement(menu).perform();//什么意思？
        
        
        Thread.sleep(5000);
        System.out.println("browser will be close");
        dr.quit();  
        
	}

}
