package enjoei.website.teste.stepDefinitions;

import enjoei.website.teste.hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.pt.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuscaSteps {
    WebDriver driver = Hooks.getDriver();

    @Dado("abrir o navegador no site da enjoei")
    public void abrir_o_navegador_no_site_da_enjoei() {
        driver.get("https://www.enjoei.com.br/");

    }
    @Quando("clicar na busca sem texto digitado")
    public void clicar_na_busca_sem_texto_digitado() throws InterruptedException {
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//button[@class=\"c-modal__close\"]")).click();
        String xpath = "/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/input[1]";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();


    }
    @Então("exibir sugestão de categorias e buscas recentes")
    public void exibir_sugestão_de_categorias_e_buscas_recentes() {
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/header/div[3]/div/div/div/div/div/div/div[1]/h3")).isDisplayed());

    }

    @Quando("clicar na busca por produto")
    public void clicar_na_busca_por_produto() throws InterruptedException {

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class=\"c-modal__close\"]")).click();
        String xpath = "/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/input[1]";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys("calça");
        xpath = "/html/body/div[2]/header/div[3]/div/div/div/div/div/div/div[1]/div[2]/button[1]";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
        xpath = "/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/button[1]";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();



    }
    @Então("exibir a busca do produto")
    public void exibir_a_busca_do_produto() {
        String str = "calça";
        String str2 = driver.findElement(By.xpath("/html/body/main/section/div/div/div/div/div[3]/div[1]/div/div/div[1]/div/div[2]/div[1]")).getText();

        //cria array de strings usando o espaço como separador
        String[] arr = str2.split(" ");

        // busca na string alvo cada pedaço da string separada
        for (String s : arr) {
            if (str.contains(s)) {
                System.out.println("match: " + s);
                Assertions.assertEquals("calça", s);
            }
        }

    }
    @Quando("clicar na busca por loja")
    public void clicar_na_busca_por_loja() throws InterruptedException {

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class=\"c-modal__close\"]")).click();
        String xpath = "/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/input[1]";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys("calça");
        xpath = "/html/body/div[2]/header/div[3]/div/div/div/div/div/div/div[1]/div[2]/button[2]";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
        xpath = "/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/button[1]";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();


    }
    @Então("exibir a busca da loja")
    public void exibir_a_busco_da_loja() {
        Assertions.assertEquals("@calcacurta",driver.findElement(By.xpath("/html/body/main/section/div/div[2]/div[1]/div/div/a/span[2]")).getText());

    }
}