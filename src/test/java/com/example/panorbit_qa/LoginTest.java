package com.example.panorbit_qa;

import com.example.panorbit_qa.Functions.Read_Write_Excel;
import com.example.panorbit_qa.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;

public class LoginTest {

    public static ChromeDriver driver;
    Read_Write_Excel readWriteExcel = new Read_Write_Excel();
    LoginPage loginPage = new LoginPage(driver);

    public LoginTest() throws IOException {
    }

    @BeforeTest()
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(description = "Verify Invalid login credential verification from Test_Data Excel ", priority = 0)
    public void check_invalid_login() throws IOException {
        driver.get("https://www.facebook.com/login/");
        driver.manage().window().maximize();
        readWriteExcel.Read_invalid_TestData();
        System.out.println(readWriteExcel.getEmail_data());
        System.out.println(readWriteExcel.getPassword_Data());
        //loginPage.getEmail().sendKeys(readWriteExcel.getEmail_data());
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(readWriteExcel.getEmail_data());
        //loginPage.getPassword().sendKeys(readWriteExcel.getPassword_Data());
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(readWriteExcel.getPassword_Data());
        driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
        //loginPage.getLogin_btn().click();
        System.out.println(readWriteExcel.getExpacted_status_data());
    }
    @Test(description = "Update Actual Test result from Excel Testdata", priority = 1)
    public void Test_Result_f() throws IOException {
        System.out.println(readWriteExcel.getEmail_data());
        System.out.println(readWriteExcel.getPassword_Data());
        System.out.println(readWriteExcel.getExpacted_status_data());
        readWriteExcel.Write_Status_Fail();
    }
    @Test(description = "Verify valid login credential verification from Test_Data Excel", priority = 2)
    public void check_Valid_login() throws IOException, InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        readWriteExcel.Read_valid_Testdata();
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(readWriteExcel.getEmail());
        driver.findElement(By.xpath("//input[@id='pass']")).clear();
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(readWriteExcel.getPassword());
        driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
        System.out.println(readWriteExcel.getStatus());
        readWriteExcel.Write_Status_pass();
        driver.close();
    }
    @Test(description = "Verify Update Actual Test result from Excel Testdata from valida credentials", priority = 3)
    public void Test_Result() throws IOException {
        System.out.println(readWriteExcel.getEmail());
        System.out.println(readWriteExcel.getPassword());
        System.out.println(readWriteExcel.getStatus());
        readWriteExcel.Write_Status_pass();
    }
}
