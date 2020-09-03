package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Maven_Cucumber_BDD/cucumber/features/MenuManagement.feature",
		glue = "stepdefinitions",
		plugin= {"pretty"})
public class MenuManagementTester {

}
