package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


/** Тест 1. Проверка строки поиска и табы выбора фирмы изготовителя */

public class App 
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("start-maximized"); /** открытие в полноэкранном формате*/
        options.addArguments("disable-popup-blocking"); /** блокировка всплывающих окон*/
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.wildberries.ru/");

        /** В строке поиска попробуем найти "Ноутбук игровой"*/
        driver.findElement(By.id("searchInput")).sendKeys("Ноутбук игровой");
        driver.findElement(By.id("applySearchBtn")).click();

        /** Для сортировки по фирме MSI кликаем по соответствющей табе "ноутбук msi" */
        driver.findElement(By.xpath("//a[@href=\"/catalog/0/search.aspx?search=%d0%bd%d0%be%d1%83%d1%82%d0%b1%d1%83%d0%ba+msi&targeturl=ST&xsearch=true\"]")).click();

        /** Закроем браузер */
        driver.close();
    }
}
