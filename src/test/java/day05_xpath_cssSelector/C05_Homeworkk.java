package day05_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_Homeworkk {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(3000);

        // Add Element butonuna basin 100 kez basınız
        WebElement addElement = driver.findElement(By.xpath("//button [.='Add Element']"));
        int expectedeAddElemantTiklamaSayisi = 100;
        int actualAddElementTiklamaSayisi = 0;
        for (int i = 0; i < 100; i++) {
            addElement.click();
            actualAddElementTiklamaSayisi++;
        }
        System.out.println("Add Element Tiklanma Sayisi : " + actualAddElementTiklamaSayisi);

        if (actualAddElementTiklamaSayisi==expectedeAddElemantTiklamaSayisi){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }



        //Delete butonuna 90 kez basınız
        List <WebElement> deleteButton = driver.findElements(By.xpath("//button[.='Delete']"));

        int sayac = 0;
            for (WebElement each : deleteButton) {
                if (sayac < 90) {
                each.click();
                sayac++;
            }
        }
        System.out.println("sayac = " + sayac);

        //Ve 90 kez basıldığını doğrulayınız

    }
}
