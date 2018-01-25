package LearnSelenium;

import net.sourceforge.htmlunit.corejs.javascript.EcmaError;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.plugin.dom.html.HTMLInputElement;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class SeleniumLevel_1 {
    @Test()
    public void test() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://ptest011.nsc-tech.ru/");
        WebElement login = driver.findElement(By.cssSelector("input[name=\"_username\"]"));
//        login.clear();
        login.sendKeys("admin");
        WebElement password = driver.findElement(By.cssSelector("input[name=\"_password\"]"));
        password.sendKeys("Superadmin1");
        WebElement submit = driver.findElement(By.cssSelector("form[class=\"pull-right auth-form\"] button"));
        submit.click();
        String text = driver.findElement(By.cssSelector("div.page-header h1")).getText();
        assertThat("h1 text is correct displayed", text, equalTo("Заявки на подключение"));
//        WebElement


    }

    @Test()
    public void HomeWork() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://test02.nsc-tech.ru/");

        WebElement submit = driver.findElement(By.cssSelector("input[id=\"search-text\"]"));
        submit.sendKeys("МТС");
        submit.sendKeys(Keys.ENTER);
        List<WebElement> hrefs = driver.findElements(By.cssSelector("div.service-list a"));
        for (WebElement webElement : hrefs) {
            if (webElement.getText().equals("МТС")) {
                webElement.click();
                break;
            }
        }
        WebElement phone = driver.findElement(By.cssSelector("input[name=\"form[phonenumber]\"]"));
        phone.sendKeys("9035010393");
        WebElement phonePay = driver.findElement(By.cssSelector("input[name=\"user_phonenumber\"]"));
        phonePay.sendKeys("9035010344");
        WebElement sum = driver.findElement(By.cssSelector("input[name=\"form[amount]\"]"));
        sum.clear();
        sum.sendKeys("150");
        int i = 0;
        for (; i < 10; i++) {
            WebElement checkbox = driver.findElement(By.id("agree"));
            if (checkbox.isDisplayed()) {
                checkbox.click();
                break;
            }
            Thread.sleep(2000);
        }
        if (i == 10) {
            throw new Exception("webElement is not displayed");
        }

        WebElement pay = driver.findElement(By.cssSelector("input[id=\"payment_submit\"]"));
        pay.click();
        int y = 0;
        for (; y < 10; y++) {
            WebElement search = driver.findElement(By.cssSelector("#success-overlay-content > div.success-overlay-header > h2"));
            Thread.sleep(2000);
            if (search.isDisplayed() && search.getText().equals("Оплата успешно проведена.")) {
                System.out.println("Текущий статус на странице: " + search.getText());
                break;
            }
            System.out.println("Текущий статус на странице: " + search.getText());
            Thread.sleep(2000);
        }
        if (y == 10) {
            throw new Exception("webElement is not displayed");
        }
    }

    @Test()
    public void HomeWork3() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        driver.get("https://test02.nsc-tech.ru/"); //открывается сайт RURU
        WebElement search = driver.findElement(By.id("search-text"));
        search.sendKeys("МТС"); //вводим МТС в поиск услуг
        search.sendKeys(Keys.ENTER); //нажимаем ENTER
        List<WebElement> String = driver.findElements(By.cssSelector("div.service-list a"));
        for (WebElement webElement : String) {
            if (webElement.getText().equals("МТС")) ; //Если видим надпись МТС, то следующим щагом клмкаем
            webElement.click(); //увидили - кликнули
            break; // завершаем цикл
        }
        WebElement phone = driver.findElement(By.cssSelector("input[name=\"form[phonenumber]\""));
        phone.sendKeys("9035010909");
        WebElement userphone = driver.findElement(By.name("user_phonenumber"));
        userphone.sendKeys("9067778121"); //вводим номер, на котором не достаточно средств 9067778***
        WebElement sum = driver.findElement(By.name("form[amount]"));
        Thread.sleep(2000);//ждем 2 секунды
        sum.sendKeys("151");//вводим сумму платежа
        int y = 0;
        for (; y < 10; y++) {
            WebElement button = driver.findElement(By.id("payment_submit"));
            if (button.isDisplayed()) {
                button.click();
                break;       //Даным циклом мы ожидаем, пока не появится чекбокс наш на принятия оферты и ждем появление кнопки "Оплатить"
            }            //Как только дождались, нажимаем кнопку "Оплатить", не нажимаем на принятие оферты.
            Thread.sleep(2000);
        }
        if (y == 10) {
            throw new Exception("webElement is not displayed");
        }

        int q = 0;
        for (; q < 10; q++) {
            WebElement search1 = driver.findElement(By.id("qtip-2"));
            if (search1.isDisplayed() && search1.getText().equals("Для продолжения необходимо согласиться с условиями предоставления услуг")) {
                System.out.println("Выдается ошибка: " + search1.getText());
                break;
            }
            System.out.println("Выдается ошибка: " + search.getText());
            Thread.sleep(2000);
        }
        if (q == 10) {
            throw new Exception("Пипец, ошибка в тексте");//Выдается ошибка, что надо принять оферту
        }
        int i = 0;
        for (; i < 10; i++) {


            WebElement checkbox = driver.findElement(By.id("agree"));
            if (checkbox.isDisplayed()) {
                checkbox.click();
                break;
            }
            Thread.sleep(2000);
        }
        if (i == 10) {
            throw new Exception("webElement is not displayed");
        }
        WebElement pay = driver.findElement(By.id("payment_submit"));
        pay.click();
        int a = 0;
        for (; a < 10; a++) {
            WebElement h2 = driver.findElement(By.cssSelector("#success-overlay-content > div.success-overlay-header > h2"));
             if (h2.isDisplayed() && h2.getText().equals("Оплата не произведена.")) {
                System.out.println("Выдается ошибка: " + h2.getText());
                break;
            }
            if (a == 10) {
                throw new Exception("Лажа у тебя");
            }
        }
    }
}




