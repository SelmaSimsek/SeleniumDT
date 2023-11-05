package day05_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {
         /*
        SYNTAX
        1) tagName [ attributeName = 'attributeValue' ]
        2) eger id ile css locate almak istersek  #idAttributeDegeri
        3) eger class ile css locate almak istersek .classAttributeDegeri

        X PATH ile CSS SELECTOR arasindaki Farklar

        1) cssSelector x path a gore daha hizli calisir
        2) x path ile bir webelement icin birden fazla sonuc verirse index ile bunu tek e dusurebilirz
            fakat css selector ile index rahatça kullanamayiz
        3) x path ile bir tag'a sahip webelementi sadece texti ile locate edebiliriz
            fakat css ile bunu yapamayiz
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        driver.findElement(By.cssSelector("button[onclick ='addElement()' ]")).click();
        Thread.sleep(3000);

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='added-manually']"));
        if(deleteButton.isDisplayed()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //Delete tusuna basin
        Thread.sleep(3000);
        deleteButton.click();

        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        Thread.sleep(2000);
        WebElement addRemoveText = driver.findElement(By.cssSelector("h3"));
        System.out.println(addRemoveText.isDisplayed() ? "TEST PASSED" : "TEST FAILED");

        //sayfayı kapatınız
        driver.close();

    }
}
