import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class PointMD {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        baseUrl = "http://point.md/";
        browser bro;
        bro = new browser();

        driver = bro.getBrowser();
    }

    @Test
    public void testPointMD() throws Exception {
         driver.get(baseUrl + "/ru/");


    driver.findElement(By.id("money-input-USD")).clear();
    driver.findElement(By.id("money-input-USD")).sendKeys("300");
    driver.findElement(By.id("money-input-USD")).sendKeys(Keys.RETURN);
    assertEquals("1 215.85", driver.findElement(By.id("money-input-RON")).getAttribute("value"));


    driver.findElement(By.id("money-input-USD")).clear();
    driver.findElement(By.id("money-input-USD")).sendKeys("200");
    driver.findElement(By.id("money-input-USD")).sendKeys(Keys.RETURN);
    assertEquals("813.20", driver.findElement(By.id("money-input-RON")).getAttribute("value"));

}

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}


class browser {


    public WebDriver getBrowser() {
        WebDriver driver;
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}

