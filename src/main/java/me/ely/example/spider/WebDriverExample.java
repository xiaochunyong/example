package me.ely.example.spider;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 1. 安装Chrome
 * 2. 下载chromedriver https://chromedriver.chromium.org/
 * @author <a href="mailto:xiaochunyong@gmail.com">Ely</a>
 * @see
 * @since 2019/11/28
 */
public class WebDriverExample {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/Ely/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(835, 855));
        driver.get("https://www.baidu.com/s?wd=test");
        // driver.get("/itm.html");
        Thread.sleep(500);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(screenshot.getAbsolutePath());
        FileInputStream fis = new FileInputStream(screenshot);
        FileOutputStream fos = new FileOutputStream("/Users/Ely/Downloads/chromedriver_screen_" + System.currentTimeMillis() + ".png");
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        fis.close();


        driver.close();
    }
}
