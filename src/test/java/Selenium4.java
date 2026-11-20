import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class Selenium4 {
    static void main(String[] args) throws InterruptedException {
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
        wiki.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        /*
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        Assert.assertEquals(actualURL, expectedURL);

         */
        /*
        String ActualTitle = driver.getTitle();
        String expectedTitle = "Nikola Tesla - Wikipedia";
        Assert.assertEquals(ActualTitle, expectedTitle);
         */
        WebElement headingPage = driver.findElement(By.id("firstHeading"));
        String actHead = headingPage.getText();
        String exphead = "Nikola Tesla";
        Assert.assertEquals(actHead,exphead);

        WebElement pageImage = driver.findElement(By.className("infobox-image"));
        Assert.assertTrue(pageImage.isDisplayed());

        String expectedAltText = "Head-and-shoulder photograph of a slender man with dark hair and moustache, dark suit and white-collar shirt";
        WebElement imagealt = pageImage.findElement(By.tagName("img"));
        String actualaltt = imagealt.getAttribute("alt");
        Assert.assertEquals(actualaltt, expectedAltText);
    }
}
