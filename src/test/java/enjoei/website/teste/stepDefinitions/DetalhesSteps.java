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
import org.openqa.selenium.WebElement;
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
        options.addArguments("--headless=new");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage().window().maximize();
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
//        driver.findElement(By.className("l-payment-methods__btn")).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
//        Assertions.assertTrue(driver.findElement(By.id("modalTitle")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        Assertions.assertTrue(driver.findElement(By.className("l-payment-methods")).isDisplayed());
    }

    @Entao("deve ser possível ler a descrição do produto")
    public void deve_ser_possível_ler_a_descrição_do_produto() {
        WebElement descricaoProduto = driver.findElement(By.xpath("/html/body/main/section/div[1]/div/div[2]/div[3]/div/div[1]/section[2]/div[1]"));
        Assertions.assertTrue(descricaoProduto.isDisplayed());
    }

    @Entao("pagina deve mostrar tambem produtos similares")
    public void pagina_deve_mostrar_tambem_produtos_similares() {
        WebElement produtosSimilares = driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div[3]/div/div/div[2]"));
        Assertions.assertTrue(produtosSimilares.isDisplayed());
    }

    @Entao("nome do produto deve aparecer no titulo da pagina")
    public void nome_do_produto_deve_aparecer_no_titulo_da_pagina() {
        WebElement nomeProduto = driver.findElement(By.xpath("/html/body/main/section/div[1]/div/div[2]/div[1]/div/h1"));
        String titulo = driver.getTitle().toLowerCase();
        Assertions.assertTrue(titulo.contains(nomeProduto.getText()));
    }
}
