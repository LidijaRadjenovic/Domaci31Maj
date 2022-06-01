
//Napisati dva smoke testa za https://www.telerik.com/support/demos:
//        Proveriti da klikom na Desktop odlazimo na tu sekciju
//        Proveriti da klikom na Mobile odlazimo na tu sekciju
//        Koristiti TestNG, asserte.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Domaci {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://www.telerik.com/support/demos");
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }

    @Test
    public void desktopSection(){
        WebElement desktopNav = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktopNav.click();
        WebElement desktopHeader = driver.findElement(By.id("desktop"));
        String actualHeader = desktopHeader.getText();
        String expectedHeader = "Desktop";
        Assert.assertEquals(actualHeader, expectedHeader);

    }

    @Test
    public void mobileSection(){
        WebElement mobileNav = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        mobileNav.click();
        WebElement mobileHeader = driver.findElement(By.id("mobile"));
        String actualHeader = mobileHeader.getText();
        String expectedHeader = "Mobile";
        Assert.assertEquals(actualHeader, expectedHeader);

    }
}
