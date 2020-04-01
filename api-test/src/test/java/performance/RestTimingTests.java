package performance;
import com.ep.api.tests.ParameterizedTestsRunner;
import org.junit.*;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ContextConfiguration;

@IfProfileValue(name = "spring.profiles.active", value = "amb-int")
@ContextConfiguration(classes = RestTimingTests.class)

public class RestTimingTests extends ParameterizedTestsRunner {

    public RestTimingTests()  {
    }

    @Test
    public void t1_checkAverageTime() {

  }

}


