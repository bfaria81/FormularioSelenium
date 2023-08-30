package org.example.Testes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TesteNavegador {


   private WebDriver driver;

   @BeforeMethod
   public void iniciar(){
      driver = new ChromeDriver();
      System.setProperty("webdriver.chrome.driver", "/Users/brunofaria/Desktop/SENAI/Teste Sistemas/FormularioSelenium/Driver");
   }

   @Test
   public void testarPaginaHome() throws InterruptedException {
      driver.get("https://demo.automationtesting.in/");

      driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("teste@gmail.com");
      Thread.sleep(2000);
      driver.findElement(By.id("email")).clear();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("teste@gmail.com");
      //driver.findElement(By.id("email")).sendKeys("teste@gmail.com");
      Thread.sleep(2000);
      driver.findElement(By.id("enterimg")).click();
      Thread.sleep(500);
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Nome");
      Thread.sleep(500);
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Sobrenome");
      Thread.sleep(500);
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"))
              .sendKeys("Rua XYZ, 44, Curitiba-PR");
      Thread.sleep(500);
      driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("teste@gmail.com");
      Thread.sleep(500);
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("44 99999-9999");
      Thread.sleep(500);
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).click();
      Thread.sleep(500);
      driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();
      Thread.sleep(500);
      // Preenche o campo Languages que é um tipo multi-select
      // Para isso, foi criada uma variável do tipo WebElement e receber o XPath do elemento
      WebElement multSelect = driver.findElement(By.xpath("//*[@id=\"msdd\"]"));
      // Inclua o método click()
      multSelect.click();
      // Crie outra variável do tipo WebElement e receberá o texto Portugues
      WebElement opcaoPortuguese = driver.findElement(By.xpath("//a[contains(text(), 'Portuguese')]"));
      opcaoPortuguese.click();
      // E outra para English
      WebElement opcaoEnglish = driver.findElement(By.xpath("//a[contains(text(), 'English')]"));
      opcaoEnglish.click();
      driver.findElement(By.xpath("//*[@id=\"section\"]/div/div")).click();

      Select skill = new Select(driver.findElement(By.xpath("//*[@id=\"Skills\"]")));
      skill.selectByVisibleText("Java");
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id=\"select2-country-container\"]")).click();

      Thread.sleep(500);

     // driver.findElement(By.xpath("driver.findElement(By.xpath(\"//*[@id=\\\"basicBootstrapForm\\\"]/div[1]/div[1]/input\")).sendKeys(\"Nome\");\n")).sendKeys("United States of America");
      Thread.sleep(500);

      Select year = new Select(driver.findElement(By.id("yearbox")));
      year.selectByVisibleText("2000");
      Select month = new Select(driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")));
      month.selectByVisibleText("April");
      Select day = new Select(driver.findElement(By.id("daybox")));
      day.selectByVisibleText("23");


      //finalizar();

   }



   @Test
   public void testarLoginInvalido() {

      //Abrir a URL informada
      driver.get("https://demo.automationtesting.in");

      //Clicar em elementos como botões ou links
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).click();

      //Digitar em elementos de input
      driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("email@gmail.com");

      // Limpa o texto digitado
      driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).clear();

      // Armazena o texto do elemento
      String Texto = driver.findElement(By.xpath("XPATH")).getText();

      //Compara o texto retornado com o que deveria retornar de fato
      Assert.assertEquals("SEU_TEXTO", Texto);

      // Elementos Select
      Select Day = new Select(driver.findElement(By.xpath("XPATH")));
      Day.selectByVisibleText("Atributo_que_deseja_selecionar");

   }

// Finalizar teste e fechar o navegador
   @AfterMethod
   public void finalizar() throws InterruptedException {
      Thread.sleep(5000); // aguarda 5 segundos e fecha o navegador
      // Esse metodo irá fechar o navegador
      driver.quit();
   }


}
