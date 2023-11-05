package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Techpro ana sayfasina gidelim https://www.techproeducation.com/
        driver.navigate().to("https://www.techproeducation.com");

        //Amazon soyfasina gidelim. https://www.amazon.com/
        Thread.sleep(3000);
        driver.navigate().to("https://www.amazon.com"); //get() methodu gibi string olarak girilen url e gider



        //Tekrar YouTube'sayfasina donelim
        Thread.sleep(3000);
        driver.navigate().back(); // web sayfasinda geri dönme islemi yapar

        //Yeniden Amazon sayfasina gidelim
        Thread.sleep(3000);
        driver.navigate().forward(); // web sayfasinda ileri gitme islemi yapar

        //Sayfayi Refresh(yenile) yapalim
        Thread.sleep(3000);
        driver.navigate().refresh();

        Thread.sleep(3000);
        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();






    }
}
