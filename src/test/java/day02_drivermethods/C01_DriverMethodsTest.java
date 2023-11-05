package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C01_DriverMethodsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();

        //Amazon sayfasina gidelim
        String amazonUrl = "https://amazon.com";
        String techProUrl = "https://techproeducation.com";
        driver.get(amazonUrl);

        //Sayfa başlığını konsola yazdıralım
        String actualTitle = driver.getTitle(); //methodu gidilen sayfanin basligini verir
        System.out.println("Amazon sayfasinin baslik bilgisi :" + actualTitle);

        //Sayfanın Url'ini konsola yazdıralım
        String actualUrl = driver.getCurrentUrl(); // gidilen sayfanin url ini verir
        System.out.println("Amazon sayfasi url'i : "+actualUrl);

        //Techproeducation sayfasına gidelim
        driver.get(techProUrl);


        //Sayfa başlığını konsola yazdıralım
        String techProEducationTitle = driver.getTitle();
        System.out.println("Techpro sayfasinin baslik bilgisi : "+techProEducationTitle);

        //Sayfanın Url'ini konsola yazdıralım
        String techProEducationUrl = driver.getCurrentUrl();
        System.out.println("Techpro Sayfasinin Url'i : "+techProEducationUrl);







    }
}
