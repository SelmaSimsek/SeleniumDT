package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://amazon.com");

    //Sayfa basligini(title) yazdirin
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

    //Sayfa basliginin "Amazon" icerdigini test edin
        if (actualTitle.contains("Amazon")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        Thread.sleep(3000); //bu bekleme özelligi javadan gelir,
        //driver ne olursa olsun 3 saniye bekleyecek demektir.

        //Test uzmanlari thread.sleep kullanmaktan kacinmalidir. cunku gereksiz beklemelere neden olur

    //Sayfa adresini(url) yazdirin
        String amazonUrl = driver.getCurrentUrl();

    //Sayfa url'inin "amazon" icerdigini test edin.


        if (amazonUrl.contains("amazon")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //Sayfa handle degerini yazdirin
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("amazonWindowHandle = " + amazonWindowHandle);

        //Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin


        String amazonHtml = driver.getPageSource();

        if (amazonHtml.contains("Gateway")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        //Sayfayi kapatin.
        driver.close(); //en son driver in oldugu sayfayi kapatir
        // driver.quit(); // Bizim otomasyon ile actigimiz birden fazla sekme ya da pencereyi kapatir

    }
}
