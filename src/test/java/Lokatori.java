import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lokatori {
    static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(3000);
        WebElement searchbox = driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div[1]/textarea"));
        searchbox.sendKeys("ITBootcamp");
        searchbox.sendKeys(Keys.ENTER);
        //lokatori (po vaznosti)- ID, Class, CSS, Link Text, Tag name, RElative xpath, Absolute xpath
        Thread.sleep(3000);
        WebElement lokatorPoID = driver.findElement(By.id("b_results")); //ID
        WebElement lokatorPoName = driver.findElement(By.name("vrednost lokatora"));
        WebElement lokatorPoClass = driver.findElement(By.className("b_algo"));
        WebElement lokatorPoCSS = driver.findElement(By.cssSelector("b_algo.b_vtl_deeplinks"));
        WebElement lokatorPoCSSSelektor = driver.findElement(By.cssSelector("textarea[type='search']"));//tag[atribut ='vrednost']
        //Link Text- a tag, href,
        WebElement LokatorPoLt = driver.findElement(By.linkText("ITBootcamp - Besplatna IT prekvalifikacija - Free IT Bootcamp in ..."));
        WebElement lokatorPoTagu= driver.findElement(By.tagName("button"));
        WebElement lokatorPoAbsoluteXpathu = driver.findElement(By.xpath("full Xpath"));

    }
}
