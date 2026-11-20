import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class zadatak2b {
    static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.open()");
        j.executeScript("window.open()");
        j.executeScript("window.open()");
        j.executeScript("window.open()");
        j.executeScript("window.open()");
        ArrayList<String> lista = new ArrayList<>(driver.getWindowHandles());
        driver.navigate().to("https://www.linkedin.com");
        driver.switchTo().window(lista.get(1));
        driver.navigate().to("https://www.youtube.com");
        driver.switchTo().window(lista.get(2));
        driver.navigate().to("https://www.google.com");
        driver.switchTo().window(lista.get(3));
        driver.navigate().to("https://www.linkedin.com");
        driver.switchTo().window(lista.get(4));
        driver.navigate().to("https://www.youtube.com");
        driver.switchTo().window(lista.get(5));
        driver.navigate().to("https://www.joberty.com");
        for(int i=0;i< lista.size();i++){
            driver.switchTo().window(lista.get(i));
            if(!driver.getCurrentUrl().equals("https://www.google.com/")) {
                driver.close();
            }
        }
    }
}
