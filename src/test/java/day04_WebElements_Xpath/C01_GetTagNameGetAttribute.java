package day04_WebElements_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");

        //arama kutusunun tag name'inin input olduğunu test ediniz
        WebElement searchbox = driver.findElement(By.id("searchHeaderInput"));
        String actualTagName = searchbox.getTagName();
        String expectedTagName = "input";

        if (actualTagName.equals(expectedTagName)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }



        //arama kutusunun class attribütunun değerinin form-input olduğunu test ediniz
        //sayfayı kapatınız
        String actualAttribute = searchbox.getAttribute("class");
        String expectedAttribute = "form-input";

        if (actualAttribute.equals(expectedAttribute)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");

        }



    }
}
