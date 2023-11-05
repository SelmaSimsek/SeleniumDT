package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementLocatorss {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Google sayfasına gidelim
        driver.get("https://google.com");

        // Arama kutusunu "name" attribute e göre bularak "selenium" yazalim
        WebElement seacrhBox=driver.findElement(By.name("q"));
        seacrhBox.sendKeys("selenium");

        // Aramayı yapalim
        seacrhBox.submit();

        Thread.sleep(3000);

        //Başlığın selenium içerdiğini test edelim
        String actualTitle = driver.getTitle();

        if (actualTitle.contains("selenium")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }


        //Sayfada kaç tane link olduğunu yazdıralım
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayisi = " + links.size());


        //Sayfadaki linklerin metinleri varsa konsola yazdıralım
        for ( WebElement  w : links ) {
            if(!w.getText().isEmpty()){
                System.out.println(w.getText());
            }
        }


        //sayfayı kapatalım
        driver.close();

        /*
        Eger birden fazla webelementi locate etmek istiyorsak findElements methodu kullaniriz.
        Bu method bize elemanlari weblement olan bir list return eder

        Bir webelemente ait yaziyi alabilmek icin getText() methodunu kullaniriz
         */
        /*
     driver.get("https://google.com");


        WebElement buttonKapa = driver.findElement(By.id("L2AGLb"));
        buttonKapa.click();

         */

    }
}
