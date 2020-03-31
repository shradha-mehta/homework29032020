package teamwork28032020;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.concurrent.TimeUnit;


public class Electronics extends Utility {



    @Before
    public void openBrowser() {

        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test
    public void mouseOverElectronics() throws InterruptedException {

        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));

        Thread.sleep(3000);

        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));

        String expectedResult = "Camera & photo";
        String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));

        Assert.assertEquals(expectedResult, actualResult);

        System.out.println("Expected message on page : " +expectedResult);
        System.out.println("Actual message on page : " +actualResult);
    }

    @Test
    public void assertPositionLowToHigh() throws InterruptedException {

        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));

        Thread.sleep(3000);

        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));

        selectByVisibleTextFromDropDownMenu(By.xpath("//select[@id='products-orderby']"),"Price: Low to High");

        sortPriceLowToHigh(By.className("prices"));

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
