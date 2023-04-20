package enjoei.website.teste.stepDefinitions;

import io.cucumber.java.pt.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BuscaSteps {
    ChromeDriver driver;

    public void IniciarChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }

    @Dado("abrir o navegador no site da enjoei")
    public void abrir_o_navegador_no_site_da_enjoei() {
        IniciarChrome();
        driver.get("https://www.enjoei.com.br/");

    }
    @Quando("clicar na busca sem texto digitado")
    public void clicar_na_busca_sem_texto_digitado() throws InterruptedException {
            driver.findElement(By.xpath("//button[@class=\"c-modal__close\"]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/input[1]")).click();
            Thread.sleep(2000);

    }
    @Então("exibir sugestão de categorias e buscas recentes")
    public void exibir_sugestão_de_categorias_e_buscas_recentes() {
        Assertions.assertEquals("recente",driver.findElement(By.xpath("/html/body")).getText());
    }

    @Quando("clicar na busca por produto")
    public void clicar_na_busca_por_produto() throws InterruptedException {

        driver.manage().window().maximize();
        //Alert alert = driver.switchTo().alert();
        //alert.dismiss();


        driver.findElement(By.xpath("//button[@class=\"c-modal__close\"]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/input[1]")).sendKeys("cal");
        driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div/div[3]/div/form/div[1]/div/div[1]/div/input[1]")).sendKeys("ça" + Keys.ENTER);
        }
    @Então("exibir a busca do produto")
    public void exibir_a_busca_do_produto() {
       Assertions.assertEquals("calça",driver.findElement(By.xpath("/html/body/main/section/div/div/div/div/div[3]/div[1]/div/div/div[1]/div/div[2]/div[1]/h2")).getAttribute("nome"));
    }

    @Quando("clicar na busca por loja")
    public void clicar_na_busca_por_loja() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class=\"c-modal__close\"]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/input[1]")).sendKeys("calça");
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div/div[3]/div/form/div[1]/div/div[1]/div/input[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/input[1]")).sendKeys(Keys.ENTER);
    }
    @Então("exibir a busca da loja")
    public void exibir_a_busco_da_loja() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}