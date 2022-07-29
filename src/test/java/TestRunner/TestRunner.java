package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",
        glue= {"Steps"},
        plugin ={"pretty","json:target/cucumber.json"})
public class TestRunner {
}
