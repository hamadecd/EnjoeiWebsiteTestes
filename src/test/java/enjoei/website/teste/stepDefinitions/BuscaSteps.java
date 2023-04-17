package enjoei.website.teste.stepDefinitions;

import io.cucumber.java.pt.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
    public void clicar_na_busca_sem_texto_digitado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Então("exibir sugestão de categorias e buscas recentes")
    public void exibir_sugestão_de_categorias_e_buscas_recentes() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Quando("clicar na busca por produto")
    public void clicar_na_busca_por_produto() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Então("exibir a busca do produto")
    public void exibir_a_busca_do_produto() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Quando("clicar na busca por loja")
    public void clicar_na_busca_por_loja() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Então("exibir a busco da loja")
    public void exibir_a_busco_da_loja() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}