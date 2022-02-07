package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/** Тест 2. Проверка строки поиска, фильтров цены, полей сортировки */

public class App2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); /** открытие в полноэкранном формате*/
        options.addArguments("disable-popup-blocking"); /** блокировка всплывающих окон*/
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.wildberries.ru/");


        /** Ввод и поиск по запросу "Видеокарта amd" */
        driver.findElement(By.id("searchInput")).sendKeys("Видеокарта amd");
        driver.findElement(By.id("applySearchBtn")).click();

        /** Меняем выборку ведиокарт путём добавления цены в фильтр*/
        driver.findElement(By.xpath("//div[@class=\"start-n\"]/div/input[@class=\"j-price c-input-base-sm\"]")).sendKeys("00");
        driver.findElement(By.xpath("//div[@class=\"end-n\"]/div/input")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        /** Отсортирум найденные видеокарты по рейтингу, кликнув по табе "Рейтингу"*/
        driver.findElement(By.xpath("//a[@class=\"sort-item\"]/span[text()='рейтингу']")).click();

        /** Кликнем по первой видеокарте,для перехода на её страничку*/
        driver.findElement(By.xpath("//div[@class=\"product-card__wrapper\"]/a/div//img")).click();


        /** Закроем браузер*/
        driver.close();
    }
}
