package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
	@CucumberOptions(
		features="src/test/java/feature/placeValidation.feature", 
		plugin="json:/target/jsonReports/cucumber-report.json",
		glue={"stepDefinations"})
	public class TestRunneraddPlace {
		


}
