package ua.com.qatestlab.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CreateAccountReg extends Base {

    @Test
    public void CreateAccountSuccess() {
        driver.get("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("sama@com.ua");
        driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Create an account')]")));
        String textSuccess = driver.findElement(By.xpath("//*[contains(text(),'Create an account')]")).getText();
        Assert.assertEquals(textSuccess, "CREATE AN ACCOUNT");

    }

    @Test
    public void CreateAccountUnSuccess() {
        driver.get("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("samacom.ua");
        driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Invalid email address')]")));
        String textSuccess = driver.findElement(By.xpath("//*[contains(text(),'Invalid email address')]")).getText();
        Assert.assertEquals(textSuccess, "Invalid email address.");
    }


}
