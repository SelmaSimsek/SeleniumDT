package day04_WebElements_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Xpath {
    public static void main(String[] args) throws InterruptedException {
        // Xpath

        /*
        / => bu direkt bir cocugu secer
            /html/body

        //=> bu belgenin herhangi bir yerindeki bir elementi secmek icin kullanilir
        öncekileri atlar

        @ => bu bir web elementin attribute ünü secmek icin kullanilir
        // input[@ name = 'field-keywords']

        []=> kosullar veya index belirtmek icin kullanilir
        //input [2]

        * Hepsini secer

        SYNTAX

        //tagname [@attributeName ='attributeDegeri']
        //* [@* = 'attributeDegeri']  tagname ve attributename farketmeksizin bu degere sahip olanlar
        eger bu kullanimda birden fazla sonuc verirse * koydugumuz yerlere tagname ve attributename i
        belirtebiliriz.
        buna ragmen birden fazla sonuc verirse, o webelementin indexini asagidaki sekilde alabiliriz


        (//tagname [@attributeName ='attributeDegeri']) [index]

        //
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Arama kutusunda "city bike" aratin (arama kutusunu xpath ile locate edin)
        WebElement aramaKutusu = driver.findElement
                (By.xpath("//input [@ id ='twotabsearchtextbox' ]"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);


        //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement aramaSonucu = driver.findElement
                (By.xpath("//div [@ class = 'sg-col-inner'] [1]"));
        System.out.println(aramaSonucu.getText());


        //Sadece sonuc sayısını yazdırınız
        String [] sonucSayisi = aramaSonucu.getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi[2]);

        //Sonra karşınıza çıkan ilk sonucun metnine tıklayın.
       driver.findElement(By.xpath("(//h2) [1]/a")).click();
       //=> xpath alirken direkt taglari kullanarak unique sonuc vermezse yukarida yaptigimiz
        // gibi index ile location alinir
        Thread.sleep(3000);


        //sayfayi kapatınız
        driver.close();






    }
}
