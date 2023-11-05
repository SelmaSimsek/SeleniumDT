package day05_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_Homework {
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

        int actualAddElementTiklamaSayisi = 0;
        for (int i = 0; i < 100; i++) {
            addElement.click();
            actualAddElementTiklamaSayisi++;
        }
        System.out.println("Add Element Tiklanma Sayisi : " + actualAddElementTiklamaSayisi);


        //Delete butonuna 90 kez basınız
        List <WebElement> deleteButton = driver.findElements(By.xpath("//button[.='Delete']"));

        int actualDeleteButtonClickCount = 0;
            for (WebElement each : deleteButton) {
                if (actualDeleteButtonClickCount < 90) {
                each.click();
                actualDeleteButtonClickCount++;
            }
        }
        System.out.println("Delete Buttan Tiklama Sayisi = " + actualDeleteButtonClickCount);

        //Ve 90 kez basıldığını doğrulayınız
        int ecpectedDeleteButtonClickCount = 90;

        if (actualDeleteButtonClickCount ==ecpectedDeleteButtonClickCount){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        Thread.sleep(3000);

        driver.close();

    }
}
