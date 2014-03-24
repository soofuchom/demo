package com.yichun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class download {

	/**
	 * @author fc_song
	 * @function 下载
	 * webdriver允许我们设置默认的文件下载路径。也就是说文件会自动下载并且存在设置的那个目录中。
	 */
	public static void main(String[] args) {
		// 都是什么意思，没看懂
//		Webdriver设置Firefox自动下载
		
		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.download.downloadDir", "c:\\excelData");
//		profile.setPreference("browser.download.defaultFolder", "c:\\excelData");
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
//		
//		profile.setPreference("browser.download.folderList",2);
//		profile.setPreference("browser.download.manager.showWhenStarting",false);
//		profile.setPreference("browser.download.dir","c:\\downloads");
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
		
		
		 WebDriver driver = new FirefoxDriver(profile);
		 
		 
//		目前可以自动保存到Firefox默认的下载位置，但是没有保存到指定的位置
//		Firefox profiel 配置

	}

}
