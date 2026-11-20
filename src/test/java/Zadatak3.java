import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //Zadatak 3
//Otvoriti bing pretrazivac, pretrazite 'Wikipedia'
//otvorite wikipedia stranicu i na njoj uradite pretragu 'Nikola Tesla'
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(3000);
        WebElement search = driver.findElement(By.id("sb_form_q"));
        search.sendKeys("Wikipedia");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement klasa = driver.findElement(By.className("b_tpcn"));
        klasa.click();
        Thread.sleep(3000);
        ArrayList<String> lista = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(lista.get(1));
        WebElement wiki = driver.findElement(By.id("searchInput"));
        wiki.sendKeys("Nikola Tesla");
    }
}
