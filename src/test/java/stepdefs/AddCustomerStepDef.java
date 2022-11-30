package stepdefs;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCustomerStepDef {
  private String baseURL = "https://demo.guru99.com/telecom/index.html";
  private WebDriver driver;
  private WebDriverWait wait;
  
  @Given("ada di halaman dashboard")
  public void ada_di_halaman_dashboard() {
    System.setProperty("webdriver.chrome.driver", 
        "C:\\webdrivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(baseURL);
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    
  }

  @When("tekan menu customer")
  public void tekan_menu_customer() {
    String linkAddCustomerPath = "//a[text()=\"Add Customer\"]";
    WebElement linkAdd = driver.findElement(By.xpath(linkAddCustomerPath));
    linkAdd.click();
  }

  @When("ada di halaman customer")
  public void ada_di_halaman_customer() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @When("ceklis done")
  public void ceklis_done() {
    String radioDonePath = "//label[@for=\"done\"]";
    WebElement radioDoneElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(radioDonePath)));
    radioDoneElem.click();
  }

  @When("isi first name {string}")
  public void isi_first_name(String string) {
    String fnamePath = "//input[@id=\"fname\"]";
    WebElement fnameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fnamePath)));
    fnameElem.sendKeys(string);
  }

  @When("isi last name {string}")
  public void isi_last_name(String string) {
    String lnamePath = "//input[@id=\"lname\"]";
    WebElement lnameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lnamePath)));
    lnameElem.sendKeys(string);
  }

  @When("isi email {string}")
  public void isi_email(String string) {
    String emailPath = "//input[@id=\"email\"]";
    WebElement emailElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailPath)));
    emailElem.sendKeys(string);
  }

  @When("isi address {string}")
  public void isi_address(String string) {
    String messagePath = "//textarea[@id=\"message\"]";
    WebElement messageElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(messagePath)));
    messageElem.sendKeys(string);
  }

  @When("isi mobile phone {string}")
  public void isi_mobile_phone(String string) {
    String phonePath = "//input[@id=\"telephoneno\"]";
    WebElement phoneElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(phonePath)));
    phoneElem.sendKeys(string);
  }

  @When("klik submit")
  public void klik_submit() {
    String submitPath = "//input[@name=\"submit\"]";
    WebElement submitElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submitPath)));
    submitElem.click();
  }

  @Then("dapat kode customer")
  public void dapat_kode_customer() {
    String numberPath = "//tr/td/h3";
    WebElement numberElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(numberPath)));
    
    assertTrue(numberElem.getText().length() == 6);
    driver.quit();
  }
}
