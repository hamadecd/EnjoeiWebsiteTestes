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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DetalhesSteps {

    WebDriver driver;
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
        if(driver != null) {
            driver.quit();
        }
    }

    @Dado("que o usuario esteja na pagina do produto")
    public void queOUsuarioEstejaNaPaginaDoProduto() {
        driver.get("https://www.enjoei.com.br/p/puffer-jaqueta-84535478?rsid=c1937c67-79ef-4a5b-b29c-586573ce698c");
    }

    @Entao("a imagem do produto deve estar visível")
    public void aImagemDoProdutoDeveEstarVisível() {
        WebElement imagemProduto = driver.findElement(By.cssSelector("img.c-photo-gallery__image.did-succeed-load"));
        String tituloImagem = imagemProduto.getAttribute("title");
        String linkImagem = imagemProduto.getAttribute("src");

        Assertions.assertEquals("puffer jaqueta - casaquinhos zara", tituloImagem);
        Assertions.assertNotNull(linkImagem);
    }

    @Entao("as formas de pagamento devem estar visíveis")
    public void asFormasDePagamentoDevemEstarVisíveis() {
        driver.findElement(By.cssSelector("ul > li.l-payment-methods__item.-last-item > button > svg")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String formasDePagamento = driver.findElement(By.cssSelector("div.c-modal__content > [id='modalTitle'] + p")).getText();
        String texto = "você pode pagar no cartão de crédito em até 12x ou à vista no boleto bancário ou pix.";
        Assertions.assertEquals(texto, formasDePagamento);
        Assertions.assertTrue(driver.findElement(By.className("l-payment-methods")).isDisplayed());
    }

    @Entao("deve ser possível ler a descrição do produto")
    public void deveSerPossívelLerADescriçãoDoProduto() {
        WebElement descricaoProduto = driver.findElement(By.cssSelector("div.o-text.-xs-regular.-xs-brevier.-xs-extra-dark.-xs-lowercase.l-about__description"));
        Assertions.assertTrue(descricaoProduto.isDisplayed());
        Assertions.assertFalse(descricaoProduto.getText().isEmpty());
    }

    @Entao("pagina deve mostrar tambem produtos similares")
    public void paginaDeveMostrarTambemProdutosSimilares() {
        /*
        * Tentei de várias maneiras validar esse teste, chegou a funcionar uma vez, aí alterava, funcionava mais uma vez
        * e depois não funciona mais. Tentei por xpath, cssSelector, mas não adianta.
        */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Boolean h2 = driver.getPageSource().contains("você também vai curtir");
        System.out.println(h2);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='você também vai curtir']")));
        WebElement produtosSimilares = driver.findElement(By.xpath("//h2[text()='você também vai curtir']"));
        Assertions.assertTrue(produtosSimilares.isDisplayed());
        Assertions.assertEquals("você também vai curtir", produtosSimilares.getText());
    }

    @Entao("nome do produto deve aparecer no titulo da pagina")
    public void nomeDoProdutoDeveAparecerNoTituloDaPagina() {
        String nomeProduto = driver.findElement(By.cssSelector("div.o-grid__item.-xs-24.-md-10 h1")).getText();
        String titulo = driver.getTitle().toLowerCase();
        Assertions.assertTrue(titulo.contains(nomeProduto));
    }
}
