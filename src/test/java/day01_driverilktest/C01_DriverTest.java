package day01_driverilktest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C01_DriverTest {
    public static void main(String[] args) {
        //  WebDriverManager.chromedriver().setup();
        // WebDriver chromeDriver  = new ChromeDriver();
        // chromeDriver.get("https://amazon.com");

        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://google.com");

        /*
        WebDriverMAnager sayesinde istedigimiz browseri rahatlikla setup yaparak otomasyonda kullanabiliriz
        bu sayede gerekli olan browseri bilgisayarimiza indirmek, yapilandirmak... zorunda kalmayiz
         */

    }
}
