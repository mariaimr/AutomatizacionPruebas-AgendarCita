package pruebaWeb;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/prueba.feature", 
							"src/test/resources/pruebaMerqueo.feature"})
public class RunTest {

}
