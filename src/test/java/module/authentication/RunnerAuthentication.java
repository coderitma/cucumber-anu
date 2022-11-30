package module.authentication;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/test/java/module/authentication",
	glue="module/authentication")
public class RunnerAuthentication extends AbstractTestNGCucumberTests {

}
