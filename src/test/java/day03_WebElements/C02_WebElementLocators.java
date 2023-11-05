package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Google sayfasına gidelim
        driver.get("https://google.com");
        // Arama kutusunu "name" attribute e göre bularak "selenium" yazalim
        WebElement searchbox=driver.findElement(By.name("q"));
        searchbox.sendKeys("selenium");
        // Aramayı yapalim
        searchbox.submit();
        Thread.sleep(3000);

        //Başlığın selenium içerdiğini test edelim#

        String actualTitle = driver.getTitle();
        if (actualTitle.contains("selenium")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TESR FAILED");
        }

        //Sayfada kaç tane link olduğunu yazdıralım
        List <WebElement> links=  driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayisi = " +links.size());

        //Sayfadaki linklerin metinleri varsa konsola yazdıralım
        for (WebElement w : links) {
            if (!w.getText().isEmpty()){
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
    }
}
