import com.github.javafaker.Faker;
import io.netty.util.concurrent.FastThreadLocalThread;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.swing.*;
import java.security.Key;

import static java.lang.Thread.sleep;

public class AutomationProject_1 {

    public static void main (String[] args) {

        WebDriver driver = new ChromeDriver();
        // Navigate to web
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        //verify title
        Assert.assertEquals(driver.getCurrentUrl(),"http://duotify.us-east-2.elasticbeanstalk.com/register.php");
       Assert.assertEquals(driver.getTitle(), "Welcome to Duotify!");
        // Thread.sleep(400);


        //signup here
        driver.findElement(By.id("hideLogin")).click();
        Faker faker = new Faker();
        //Thread.sleep(500);
        String userName =faker.name().username();
        driver.findElement(By.id("username")).sendKeys(userName, Keys.ENTER);
        String firstname =faker.name().firstName();
        driver.findElement(By.id("firstname")).sendKeys(firstname, Keys.ENTER);
        String lastName =faker.name().lastName();
        driver.findElement(By.id("lastname")).sendKeys(lastName, Keys.ENTER);
        String email =faker.internet().emailAddress();
        driver.findElement(By.id("email")).sendKeys(email, Keys.ENTER);
        driver.findElement(By.id("email2")).sendKeys(email, Keys.ENTER);
        String password =faker.internet().password();
        driver.findElement(By.name("password")).sendKeys(password, Keys.ENTER);
        driver.findElement(By.name("password2")).sendKeys(password);
        driver.findElement(By.name ("registerButton")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        Assert.assertEquals(firstname+ " "+lastName,(driver.findElement(By.id("nameFirstAndLast"))).getText());

        driver.findElement(By.id("nameFirstAndLast")).click();
       //Thread.sleep(500);

     Assert.assertEquals(driver.findElement(By.name("userInfo")).getText(), (firstname+" "+lastName));

     Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");
     driver.findElement(By.id("loginUsername")).sendKeys(firstname+lastName);
     driver.findElement(By.id("LoginPassword")).sendKeys(Keys.ENTER);
     driver.findElement(By.id("LoginButton")).sendKeys(Keys.ENTER);
     WebElement homePageText = driver.findElement(By.id("mainContent"));
     Assert.assertTrue(homePageText.getText().trim().contains("You Might Also Like"));






















    }

}
