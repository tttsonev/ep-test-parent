package healthchecktest;
import com.ep.api.tests.ParameterizedTestsRunner;
import org.junit.*;
import org.slf4j.Logger;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ContextConfiguration;

@IfProfileValue(name = "spring.profiles.active", value = "local")
@ContextConfiguration(classes = PositiveTests.class)

public class PositiveTests extends ParameterizedTestsRunner {

  private final static Logger log = org.slf4j.LoggerFactory.getLogger(PositiveTests.class);


  @IfProfileValue(name = "spring.profiles.active", value = "local")
  @Test
  public void t1_saleAndVoid() {
    int i = 3;


  }


}
