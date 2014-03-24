package com.yichun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Maximize {

	/**
	 * @author fc_song
	 * @throws InterruptedException 
	 * @function
	 * @Comment:当我们在测试中使用一些基于图像和坐标的辅助测试工具时，
	 * 我们就会需要使浏览器在每次测试时保存最大化，
	 * 以便在同一分辨率下进行图像比对和坐标点选。
	 */
	public static void main(String[] args) throws InterruptedException {
			WebDriver dr = new FirefoxDriver();
			Thread.sleep(2000);
			System.out.println("maximize browser");
			dr.manage().window().maximize();
			Thread.sleep(2000);
			System.out.println("browser will be close");
			dr.quit();

	}

}
