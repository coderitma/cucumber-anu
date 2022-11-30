package stepdefs;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PalindromStepDef {
  private String kata;
  private boolean actual;
  @Given("memasukan kata berupa {string}")
  public void memasukan_kata_berupa(String string) {
      kata = string;
  }

  @When("cek palindrom")
  public void cek_palindrom() {
      String tampungPalindrom = "";
      for (int i=kata.length(); i > 0; i--) {
        String tampung = kata.substring(i-1, i);
        tampungPalindrom += tampung;
      }
      
      if (kata.equals(tampungPalindrom)) {
        actual = true;
      } else {
        actual = false;
      }
  }

  @Then("hasil harus {string}")
  public void hasil_harus(String string) {
    boolean expect = Boolean.parseBoolean(string);
    
    assertEquals(actual, expect);
  }
}
