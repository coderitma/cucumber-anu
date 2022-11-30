package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/test/java/module/testdasar/features",
	glue="module/testdasar/steps")
public class RunnerTestNGTestModuleTestDasar extends AbstractTestNGCucumberTests {

}
