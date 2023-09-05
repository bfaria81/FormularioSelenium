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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class TesteNavegador {


   private WebDriver driver;

   @BeforeMethod
   public void iniciar(){
      driver = new ChromeDriver();
      System.setProperty("webdriver.chrome.driver", "/Users/brunofaria/Desktop/SENAI/Teste Sistemas/FormularioSelenium/Driver");
   }

   @Test
   public void testarPaginaHome() throws InterruptedException, AWTException {
      //Abre a URL informada
      driver.get("https://demo.automationtesting.in/");
      driver.manage().window().maximize();

      //Inclui o e-mail no campo e depois deleta caso ocorra erro
      driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("teste@gmail.com");
      Thread.sleep(2000);
      //Reenvia outro e-mail
      driver.findElement(By.id("email")).clear();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("teste@gmail.com");
      //driver.findElement(By.id("email")).sendKeys("teste@gmail.com");
      Thread.sleep(500);
      //Clica no botão enviar
      driver.findElement(By.id("enterimg")).click();
      Thread.sleep(500);
      //Preenche o Nome
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Nome");
      Thread.sleep(500);
      //Preenche o sobrenome
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Sobrenome");
      Thread.sleep(500);
      //Preenche o endereço
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"))
              .sendKeys("Rua XYZ, 44, Curitiba-PR");
      Thread.sleep(500);
      //Preenche o e-mail
      driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("teste@gmail.com");
      Thread.sleep(500);
      //Preenche o telefone
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("44 99999-9999");
      Thread.sleep(500);
      //Preenche o campo male
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).click();
      Thread.sleep(500);
      //Preenche a linguagem
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

      //Thread.sleep(2000);

      //Select form-control para skills
      driver.findElement(By.xpath("//*[@id=\"Skills\"]")).sendKeys("Java");

      // Select Country
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span/span[2]/b")).click();
      driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("United States of America");
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span/span[2]/b")).click();

      // Preencher o ano do aniversário, mês e dia, respectivamente
      driver.findElement(By.xpath("//*[@id=\"yearbox\"]")).sendKeys("2023");
      driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).sendKeys("April");
      driver.findElement(By.xpath("//*[@id=\"daybox\"]")).sendKeys("23");

      // Preencher os dois campos: Password e Confirm Password. Obviamente, cada campo deverá ter o seu próprio XPath
      driver.findElement(By.xpath("//*[@id=\"firstpassword\"]")).sendKeys("senha");
      driver.findElement(By.xpath("//*[@id=\"secondpassword\"]")).sendKeys("senha");

       //Anexar a imagem ao clicar no botão "Escolher ficheiro"
      driver.findElement(By.xpath("//*[@id=\"section\"]/div/div/div[3]/div[2]")).click();
      // Armazene o caminho da URL onde está a imagem
      String urlImagem = "/Users/brunofaria/Desktop/SENAI/Teste Sistemas/FormularioSelenium/avatar.jpg";

      Robot robot = new Robot();

      // Aguardar a janela ser aberta
      Thread.sleep(1000);

      // Copie o caminho do arquivo para a área de transferência
      StringSelection selection = new StringSelection(urlImagem);
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

      // Pressione Ctrl + V para colar o caminho do arquivo na janela de diálogo
      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_CONTROL);

      // Pressione Enter para confirmar o upload
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);

      // Espera para que o envio do arquivo seja concluído
      Thread.sleep(5000);

      // Clique no botão "Submit"
      driver.findElement(By.xpath("//*[@id=\"submitbtn\"]")).click();



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
