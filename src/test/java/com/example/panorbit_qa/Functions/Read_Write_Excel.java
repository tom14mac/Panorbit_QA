package com.example.panorbit_qa.Functions;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.function.Function;

public class Read_Write_Excel {
    public String Email, Password, status;
    public String Email_data, Password_Data, Expacted_status_data;
    File file = new File("C:\\Users\\tejaskumar.macwan\\IdeaProjects\\Panorbit_QA\\src\\test\\java\\com\\example\\panorbit_qa\\Testdata\\Testdata.xlsx");
    FileInputStream fileInputStream = new FileInputStream(file);
    XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

    public Read_Write_Excel() throws IOException {
    }

    public void Read_invalid_TestData() throws IOException {
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        Email_data = sheet.getRow(1).getCell(0).getStringCellValue();
        Password_Data = sheet.getRow(1).getCell(1).getStringCellValue();
        Expacted_status_data = sheet.getRow(1).getCell(2).getStringCellValue();
    }

    public void Write_Status_Fail() throws IOException {
        Sheet sheet1 = xssfWorkbook.getSheetAt(0);
        Cell lastRow = sheet1.getRow(1).getCell(4);
        Row row = sheet1.getRow(1);
        Cell cell = row.createCell(3);
        cell.setCellValue("Fail");
        FileOutputStream fos = new FileOutputStream(file);
        xssfWorkbook.write(fos);
    }
    public void Read_valid_Testdata() {
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        Email = sheet.getRow(2).getCell(0).getStringCellValue();
        Password = sheet.getRow(2).getCell(1).getStringCellValue();
        status = sheet.getRow(2).getCell(2).getStringCellValue();
    }
    public void Write_Status_pass() throws IOException {
        FileInputStream fileInputStream1 = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook1 = new XSSFWorkbook(fileInputStream1);
        Sheet sheet1 = xssfWorkbook1.getSheetAt(0);
        Cell lastRow = sheet1.getRow(2).getCell(4);
        Row row = sheet1.getRow(2);
        Cell cell = row.createCell(3);
        cell.setCellValue("Pass");
        FileOutputStream fos1 = new FileOutputStream(file);
        xssfWorkbook1.write(fos1);
    }

    public String getEmail_data() {
        Email_data.toString();
        return Email_data;
    }

    public String getPassword_Data() {
        Password_Data.toString();
        return Password_Data;
    }

    public String getExpacted_status_data() {
        Expacted_status_data.toString();
        return Expacted_status_data;
    }

    public String getEmail() {
        Email.toString();
        return Email;
    }

    public String getPassword() {
        Password.toString();
        return Password;
    }

    public String getStatus() {
        status.toString();
        return status;
    }
}
