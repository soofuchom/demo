package com.yichun;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SimpleLocate {

	/**  
	 * @author fs_song
	 * @throws InterruptedException 
	 * @function 定位一组对象
	 * 有时候我们需要定位一组对象，这时候就需要使用findElements方法。
	 * 定位一组对象一般用于以下场景：
	 * 批量操作对象，比如将页面上所有的checkbox都勾上
	 * 先获取一组对象，再在这组对象中过滤出需要具体定位的一些对象。比如定位出页面上所有的checkbox，然后选择最后一个
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new FirefoxDriver();
		
		//声明一个文件对象，以及文件存放的相对路径
		File file = new File("src/Demopage/checkbox.html");

		//获取文件绝对路径
		String filePath = "file:///"+file.getAbsolutePath();
		//获取文件名字
		String fileName=file.getName();
		System.out.printf("now access %s \n",filePath);
		System.out.printf("file name is %s \n",fileName);	
		
		dr.get(filePath);//这块的filePath是个变量，不能加上双引号！！
		Thread.sleep(2000);
		
//      选择所有的checkbox并全部勾上
		List<WebElement> checkboxes = dr.findElements(By.cssSelector("input[type=checkbox]"));
		/*css选择器定位
		 * a.结合id来定位，driver.findElement(By.cssSelector("input#username")); 在标签与id之间使用#连接
		 * 		该方法也可简写为driver.findElement(By.cssSelector("#username")); 有点儿类似于id选择器
		 * b.使用元素的任何属性来定位元素
		 * 	driver.findElement(By.cssSelector("标签名[属性名='属性值']"));
		 * c.匹配部分属性值
		 * 	^=        driver.findElement(By.cssSelector("标签名[属性名^='xxx']"));  匹配属性值以xxx开头的元素
		 *  $=        driver.findElement(By.cssSelector("标签名[属性名$='xxx']"));  匹配属性值以xxx结尾的元素
		 *  *=        driver.findElement(By.cssSelector("标签名[属性名^='xxx']"));  匹配属性值包含xxx的元素
		 */
        for(WebElement checkbox : checkboxes) {  //checkbox 元素在 checkboxes 元素集合里的话，就会点击，就是遍历
            checkbox.click();
        }
        System.out.println("=================");

        Thread.sleep(3000);
        dr.navigate().refresh();
        Thread.sleep(9000);
        System.out.println("都点击上~~~");
        //打印当前页面上有多少个checkbox
        System.out.printf("%d\n", checkboxes.size());//checkboxex的大小即元素个数？
        Thread.sleep(9000);
        System.out.println("=================");
        
        //选择页面上所有的input，然后从中过滤出所有的checkbox并勾选之
        List<WebElement> inputs = dr.findElements(By.tagName("input"));
        for(WebElement input : inputs){
            if(input.getAttribute("type").equals("checkbox")){//如果input的type属性的属性值等于checkbox，就点击
                input.click();
            }
        }

        //把页面上最后1个checkbox的勾给去掉
        List<WebElement> allCheckboxes = dr.findElements(By.cssSelector("input[type=checkbox]"));
        allCheckboxes.get(allCheckboxes.size() - 1).click();//选择元素集合里最后一个元素

        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit(); 
		
		

	}

}
