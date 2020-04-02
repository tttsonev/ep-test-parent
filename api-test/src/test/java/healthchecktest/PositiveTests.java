package healthchecktest;
import com.ep.api.tests.ParameterizedTestsRunner;
import com.ep.api.tests.models.SaleTransactionImpl;
import com.ep.api.tests.models.TransactionImpl;
import com.ep.api.tests.models.VoidTransactionImpl;
import org.json.JSONObject;
import org.junit.*;
import org.slf4j.Logger;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ContextConfiguration;

@IfProfileValue(name = "spring.profiles.active", value = "local")
@ContextConfiguration(classes = PositiveTests.class)

public class PositiveTests extends ParameterizedTestsRunner {

  private final static Logger log = org.slf4j.LoggerFactory.getLogger(PositiveTests.class);


//  @IfProfileValue(name = "spring.profiles.active", value = "local")
  @Test
  public void t1_saleAndVoid() {
      //create sale transaction
      TransactionImpl saleTransaction = new SaleTransactionImpl();
      saleTransaction.createExampleTransaction();
      saleTransaction.run();

      verifyStatusCode(200);

      //create void transaction on success
      TransactionImpl voidTransaction = new VoidTransactionImpl((SaleTransactionImpl) saleTransaction);
      voidTransaction.run();

      verifyStatusCode(200);


  }


}
