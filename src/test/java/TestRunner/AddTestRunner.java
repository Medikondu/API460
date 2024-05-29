package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\features\\AddUser.feature",
glue="StepDefination",
tags="@User",
dryRun=true,
monochrome=false,
plugin= {"pretty","html:target/ReqresReport/UserReport.html","json:target/JsonReport/UserReport.json","junit:target/JunitReport/UserReport.xml"})
public class AddTestRunner {
}
