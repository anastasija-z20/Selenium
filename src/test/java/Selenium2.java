import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {
    static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        //skripta da se izvrsi u browseru, za otvaranje tabova i skrol za neki element
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeAsyncScript("window.open()");
        js.executeAsyncScript("window.open()");
        js.executeAsyncScript("window.open()");
        driver.navigate().to("https://www.linkedin.com");
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.youtube.com");
        //prebacujemo na drugi tab
        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.google.com");
        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.joberty.com");
        driver.close();
        //quit zatvara sve, close samo jedan tab


    }
}
