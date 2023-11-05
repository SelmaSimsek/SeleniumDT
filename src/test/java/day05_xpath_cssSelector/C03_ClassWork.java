package day05_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(3000);

        //Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[type='button']")).click();


        //Login alanine  "username" yazdirin
        //Password alanine "password" yazdirin
        //Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.cssSelector("input[type='text']"));
        login.sendKeys("username", Keys.TAB, "password",Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().back();

        //Online Banking altındaki Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("li[id='onlineBankingMenu']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[.='Pay Bills']")).click();

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //tarih kismina "2020-09-10" yazdirin
        //Pay buttonuna tiklayin
        WebElement amount = driver.findElement(By.cssSelector("input[id='searchTerm']"));
        amount.sendKeys("500",Keys.TAB,"2020-09-10",Keys.TAB, Keys.TAB);
        Thread.sleep(3000);
        amount.sendKeys(Keys.ENTER);


        //"The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement message = driver.findElement(By.cssSelector("(//span)[1]"));
        String actualSuccesMessage = message.getText();
        String expectedSuccesMessage = "The payment was successfully submitted.";
        if (actualSuccesMessage.equals(expectedSuccesMessage)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //sayfayı kapatınız
        driver.close();



    }
}
