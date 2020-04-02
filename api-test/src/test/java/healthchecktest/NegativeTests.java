package healthchecktest;

import com.ep.api.tests.ParameterizedTestsRunner;
import com.ep.api.tests.models.SaleTransactionImpl;
import com.ep.api.tests.models.TransactionImpl;
import com.ep.api.tests.models.VoidTransactionImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ContextConfiguration;

//@IfProfileValue(name = "spring.profiles.active", value = "local")
@ContextConfiguration(classes = NegativeTests.class)

public class NegativeTests extends ParameterizedTestsRunner {

  private final static Logger log = org.slf4j.LoggerFactory.getLogger(NegativeTests.class);


    @Test
    public void t1_saleTransactionWrongCardNumber() {
        //create sale transaction
        TransactionImpl saleTransaction = new SaleTransactionImpl();
        saleTransaction.setCard_number("sdsdfv");
        saleTransaction.run();

        verifyStatusCode(422);

    }

    @Test
    public void t2_voidTransactionWrongReference() {

        TransactionImpl voidTransaction = new VoidTransactionImpl(new SaleTransactionImpl());
        voidTransaction.setReference_id("sdfdf");
        voidTransaction.run();

        verifyStatusCode(422);
    }


    @Test
    public void t3_saleTransactionBadCredential() {
      //create sale transaction
      TransactionImpl saleTransaction = new SaleTransactionImpl();
      logout();
      saleTransaction.run();

      verifyStatusCode(401);

  }

    @Test
    public void t4_voidTransactionBadCredential() {

        TransactionImpl voidTransaction = new VoidTransactionImpl(new SaleTransactionImpl());
        logout();
        voidTransaction.run();

        verifyStatusCode(401);
    }


}
