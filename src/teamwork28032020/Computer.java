package teamwork28032020;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.concurrent.TimeUnit;


public class Computer extends Utility {

    @Before

    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);


    }

    @Test

    public void verifyUserShouldNavigateToComputerPage() throws InterruptedException {

        clickonElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));

        Thread.sleep(2000);

        String expectedResult = "Computers";
        String actualResult = getTextFromElement(By.xpath("//div[@class='page-title']//h1[contains(text(),'Computers')]"));

        Assert.assertEquals(expectedResult, actualResult);

        System.out.println("Expected message on Page : " + expectedResult);
        System.out.println("Actual message on Page : " + actualResult);

    }

    @Test

    public void deskTopPage() throws InterruptedException {

        clickonElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));

        clickonElement(By.xpath("//div[@class='page-title']//h1[contains(text(),'Computers')]"));

        clickonElement(By.xpath("//h2[@class='title']//a[contains(text(),'Desktops')]"));

        Thread.sleep(3000);

        clickonElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Build your own computer')]"));

        clickonElement(By.xpath("//input[@id='product_attribute_3_7']"));

        clickonElement(By.xpath("//input[@id='add-to-cart-button-1']"));

        String expectedResult = "The product has been added to your shopping cart";
        String actualResult = getTextFromElement(By.xpath("//p[@class='content']"));

        Assert.assertEquals(expectedResult, actualResult);

        System.out.println("Expected message on Page : " + expectedResult);
        System.out.println(" Actual message on Page : " +actualResult);





    }

    @After
    public void closingBrowser() {
        driver.close();
    }
}
