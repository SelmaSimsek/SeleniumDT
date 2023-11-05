package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Homework {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //ChromeDriver kullanarak, facebook sayfasina gidin
        driver.get("https://facebook.com");

        //sayfa basliginin (title) “Facebook” icerdigini dogrulayin (verify), degilse dogru basligi yazdirin.
        Thread.sleep(3000);
        if(driver.getTitle().contains("Facebook")){
            System.out.println(" TEST PASSED");
        }else {
            System.out.println("Sayfa basligi : " + driver.getTitle());
        }

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i  yazdirin.
        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("Sayfa Url'i : "+driver.getCurrentUrl());
        }

        // https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com");


        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String wlwartTitle = driver.getTitle().contains("Walmart.com") ? "TEST PASSED" : "TEST FAILED";

        //Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        //Sayfayi yenileyin
        driver.navigate().refresh();

        //sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //Sayfayi kapatin
        driver.close();

    }
}
