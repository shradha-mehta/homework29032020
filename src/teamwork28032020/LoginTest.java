package teamwork28032020;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;


public class LoginTest extends Utility {
    @Before
    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessFully() {

        clickonElement(By.xpath("//a[@class=\"ico-login\"]"));

        String expectedText = "Welcome, Please Sign In!";

        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        Assert.assertEquals(expectedText,actualText);

        System.out.println("Expected Message On The Screen : " + expectedText);
        System.out.println("Actual Message On The Screen : " + actualText);

    }


    @Test
    public void userShouldLoginSuccessfully() throws InterruptedException {

        clickonElement(By.xpath("//a[@class=\"ico-login\"]"));

        Thread.sleep(3000);

        sendTextToElement(By.id("Email"),"alpha@gmail.com");

        sendTextToElement(By.id("Password"),"Tiger123");

        clickonElement(By.xpath("//input[@class=\"button-1 login-button\"]"));

        String expectedText = "Welcome to our store";

        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));

        Assert.assertEquals(expectedText,actualText);

        System.out.println("Expected Message On The Screen : " + expectedText);
        System.out.println("Actual Message On The Screen : " + actualText);
    }

    @Test

    public void userShouldNotLoginSuccessfully() throws InterruptedException {
        clickonElement(By.xpath("//a[@class=\"ico-login\"]"));

        Thread.sleep(3000);

        sendTextToElement(By.id("Email"),"alpha@gmail.com");

        sendTextToElement(By.id("Password"),"Tiger124");

        clickonElement(By.xpath("//input[@class=\"button-1 login-button\"]"));

        String expectedText = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";

        String actualText = getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']"));

        Assert.assertEquals(expectedText,actualText);

        System.out.println("Expected Message On The Screen : " + expectedText);
        System.out.println("Actual Message On The Screen : " + actualText);










    }

    @After


    public void browserClosing() throws InterruptedException {

        Thread.sleep(3000);

        driver.quit();
    }
}
