import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        SeleniumTest seleniumTest = new SeleniumTest();
        seleniumTest.test();
    }

    public void test() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://sv.wikipedia.org/wiki/Portal:Huvudsida");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        Thread.sleep(4*1000);

        String siteName = webDriver.getTitle();
        System.out.println(siteName);

        WebElement searchBox = webDriver.findElement(By.id("searchInput"));
        WebElement searchButton = webDriver.findElement(By.id("searchButton"));

        searchBox.sendKeys("TDD");
        searchButton.click();

    }


}