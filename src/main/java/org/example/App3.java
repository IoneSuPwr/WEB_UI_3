package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/** Тест 3. Проверка burger-button, выпадающего меню, ссылкок на странице выбранного товара*/

public class App3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); /** открытие в полноэкранном формате*/
        options.addArguments("disable-popup-blocking"); /** блокировка всплывающих окон*/
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.wildberries.ru/");


        /** Кликаем ЛКМ по кнопке-бургер слева в шапке сайта*/
        driver.findElement(By.xpath("//button[@class=\"nav-element__burger j-menu-burger-btn\"]")).click();

        /** Кликаем ЛКМ вкладку "Мужчинам" в выпавшем меню*/
        driver.findElement(By.xpath("//a[@class=\"menu-burger__main-list-link menu-burger__main-list-link--566\"]")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        /** Кликнем ЛКМ по картинке "Рюкзаки" на страничке*/
        driver.findElement(By.xpath("//a[@href=\"/catalog/aksessuary/sumki-i-ryukzaki/ryukzaki?xsubject=138&fkind=1&bid=c35ccd4b-6f9f-49cf-b26c-faa9c719cda5\"]")).click();

        /** Выберем рюкзак Swiss STANDARD на открывшейся страничке и кликнем ЛКМ */
        driver.findElement(By.xpath("//a[@href=\"https://www.wildberries.ru/catalog/27656086/detail.aspx?targetUrl=GP\"]")).click();

        /** Клик ЛКМ по ссылке SWISS STANDARD для перехода на страничку продавца*/
        driver.findElement(By.xpath("//a[@class=\"seller-details__title seller-details__title--link\"]")).click();




        /** Закроем браузер*/
        driver.close();
    }
}

