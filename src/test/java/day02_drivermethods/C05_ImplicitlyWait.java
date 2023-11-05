package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ImplicitlyWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // MAX 15 saniye, sayfadaki web elementlerin olusmasi icin bekler.
        /*
        Bir sayfaya gittiginizde internetten kaynakli islem yapilmak istenen web elementler hemen olusmayabilir
        dolayisiyla islem yapilmak istenen web element henüz olusmamis ise kaodlariniz bu elemento bulamaz ve hata aliriz
        bu nedenle Implicitly kullanarak isimizin cogunu hallederiz, bazi extra beklemeler icin explicit wait konusunu ögrenecegiz

         */

        //techpro sayfasına gidiniz
        driver.get("https://techproeducation.com");

        //sayfa başlığının TechPro Education olduğunu test ediniz
        String expectedTitle = "TechPro Education";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle.equals(expectedTitle) ? "TEST PASSED" : "TEST FAILED");


        //facebook sayfasına gidiniz
        driver.get("https://facebook.com");

        //sayfa url'inin facebook içerdiğini test ediniz
        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAIKED");
        }


        //techpro sayfasına geri dönününüz
        driver.navigate().back();
        //Geri döndüğünüzü test ediniz
        actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //sayfayı kapatınız
        driver.close();



    }
}
