package enjoei.website.teste.stepDefinitions;

import io.cucumber.java.pt.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public void clicar_na_busca_sem_texto_digitado() throws InterruptedException {
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//button[@class=\"c-modal__close\"]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/input[1]")).click();
            Thread.sleep(500);

    }
    @Então("exibir sugestão de categorias e buscas recentes")
    public void exibir_sugestão_de_categorias_e_buscas_recentes() {
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/header/div[3]/div/div/div/div/div/div/div[1]/h3")).isDisplayed());
        driver.quit();
    }

    @Quando("clicar na busca por produto")
    public void clicar_na_busca_por_produto() throws InterruptedException {

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class=\"c-modal__close\"]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/input[1]")).sendKeys("calça");
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[3]/div/div/div/div/div/div/div[1]/div[2]/button[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/button[1]")).click();
        Thread.sleep(500);
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
        driver.quit();
    }
    @Quando("clicar na busca por loja")
    public void clicar_na_busca_por_loja() throws InterruptedException {

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class=\"c-modal__close\"]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/input[1]")).sendKeys("calça");
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[3]/div/div/div/div/div/div/div[1]/div[2]/button[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[3]/div/form/div/div/div[1]/div/button[1]")).click();
        Thread.sleep(500);
    }
    @Então("exibir a busca da loja")
    public void exibir_a_busco_da_loja() {
        Assertions.assertEquals("@calcacurta",driver.findElement(By.xpath("/html/body/main/section/div/div[2]/div[1]/div/div/a/span[2]")).getText());
        driver.quit();
    }
}