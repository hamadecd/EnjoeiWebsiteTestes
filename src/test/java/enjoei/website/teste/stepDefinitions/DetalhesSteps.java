package enjoei.website.teste.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DetalhesSteps {

    static WebDriver driver;
    ChromeOptions options;

    @Before
    public void setupTest() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Dado("que o usuario esteja na home page")
    public void que_o_usuario_esteja_na_home_page() {
        driver.get("https://www.enjoei.com.br/");
    }
    @Quando("clicar sobre um produto")
    public void clicar_sobre_um_produto() {
        // fecha um modal antes de clicar no produto
        driver.findElement(By.xpath("//button[@class=\"c-modal__close\"]")).click();
        driver.findElement(By.className("c-content-widget-item__link")).click();
    }
    @Entao("a imagem do produto deve estar visível")
    public void a_imagem_do_produto_deve_estar_visível() {
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class=\"c-photo-gallery\"]")).isDisplayed());
    }

    @Entao("as formas de pagamento devem estar visíveis")
    public void as_formas_de_pagamento_devem_estar_visíveis() {
        driver.findElement(By.className("l-payment-methods__btn")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        Assertions.assertTrue(driver.findElement(By.id("modalTitle")).isDisplayed());
    }
}
