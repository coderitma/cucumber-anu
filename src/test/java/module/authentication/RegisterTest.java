package module.authentication;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {
  private String baseURL = "https://demo.guru99.com/";
  private WebDriver driver;
  private WebDriverWait wait;
  private String userIDString;
  
  @Given("User sedang berada di halaman register")
  public void user_sedang_berada_di_halaman_register() {
    System.setProperty("webdriver.chrome.driver", 
        "C:\\webdrivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(baseURL);
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
  }

  @When("User memasukan email {string}")
  public void user_memasukan_email(String string) {
      WebElement inputEmail = driver.findElement(By.xpath("//input[@name=\"emailid\"]"));
      inputEmail.sendKeys(string);
  }

  @When("User menekan tombol submit")
  public void user_menekan_tombol_submit() {
    WebElement btnLogin = driver.findElement(By.xpath("//input[@name=\"btnLogin\"]"));
    btnLogin.click();
  }

  @And("User akan melihat kredensial yang diberikan")
  public void user_akan_melihat_kredensial_yang_diberikan() {
    WebElement userID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), \"mngr\")]")));
    assertTrue(userID.getText().length() > 0);
  }

  @And("User akan melihat pesan validasi {string}")
  public void user_akan_melihat_pesan_validasi(String string) {
    WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id=\"message9\"]")));
    assertEquals(message.getText(), string);
  }
  
  @Then("close driver")
  public void closeDriver() {
    driver.quit();
  }
}
