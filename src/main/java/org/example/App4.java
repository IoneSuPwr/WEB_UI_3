package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/** Тест 4. Проверка добавления выбранного товара в корзину*/

public class App4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); /** открытие в полноэкранном формате*/
        options.addArguments("disable-popup-blocking"); /** блокировка всплывающих окон*/
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.wildberries.ru/");


        /** В строке поиска попробуем найти "Термос" */
        driver.findElement(By.id("searchInput")).sendKeys("Термос");
        driver.findElement(By.id("applySearchBtn")).click();


        /** Кликнем ЛКМ по картинке "aciess / Термос" */
        driver.findElement(By.xpath("//a[@href=\"https://www.wildberries.ru/catalog/11965735/detail.aspx?targetUrl=XS\"]")).click();


        /** Клик ЛКМ по кнопке "Добавить в корзину"  */
        driver.findElement(By.xpath("//button[@class=\"btn-main\"]")).click();
        /** На иконке "Корзина", справа в шапке сайта, появляется подтверждение,что товар добавлен*/


        new WebDriverWait(driver, 5);
        /** Переходим в "Корзину", для подтверждения */
        driver.findElement(By.xpath("//a[@href=\"/lk/basket\"]")).click();





        /** Закроем браузер*/
        driver.close();
    }
}
