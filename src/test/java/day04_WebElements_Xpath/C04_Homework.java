package day04_WebElements_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Homework {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

       // cookies uyarisi cikarsa kabul ederek kapatin
        driver.findElement(By.xpath("(//div [@ class = 'QS5gu sy4vM']) [1]")).click();

       // Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        System.out.println(actualTitle.contains(expectedTitle) ? "TEST PASSED" : "TEST FAILED");

       // Arama cubuguna “Selenium” yazip aratin
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

      // Bulunan sonuc sayisini yazdirin
       WebElement aramaSonucu = driver.findElement(By.xpath("//div [@ id='result-stats']"));
       String [] aramaSonucuSayisi = aramaSonucu.getText().split(" ");
       System.out.println("Arama Sonucu Sayisi = " + aramaSonucuSayisi[1]);

       //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisi = aramaSonucuSayisi[1].replaceAll("[^0-9]","");
        int sonucSayisiInt  =Integer.parseInt(sonucSayisi);
        System.out.println(sonucSayisiInt > 10000000 ? "TEST PASSED" : "TEST FAILED");

       //Sayfayi kapatin
        driver.close();

    }
}
