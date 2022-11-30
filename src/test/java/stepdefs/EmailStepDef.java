package stepdefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailStepDef {
  private String email;
  private boolean actual;
	@Given("saya memasukkan email {string}")
	public void saya_memasukkan_email(String string) {
	    this.email = string;
	}

	@When("saya test formatnya")
	public void saya_test_formatnya() {
	    if (this.email.length() > 4) {
	      this.actual = true;
	    } else {
	      this.actual = false;
	    }
	}

	@Then("hasilnya harus {string}")
	public void hasilnya_harus(String string) {
	    boolean expect = Boolean.parseBoolean(string);
	    
	    assertEquals(actual, expect);
	}
}
