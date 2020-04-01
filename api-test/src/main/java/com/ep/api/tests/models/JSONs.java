package com.ep.api.tests.models;
import java.util.Map;

public class JSONs {

  public static String paymentTransactionJson(Map<String, String> paymentTransactionProperties) {
    return "{\n" +
            "    \"payment_transaction\": {\n" +
            "      \"card_number\": \"4200000000000000\",\n" +
            "      \"cvv\": \"123\",\n" +
            "      \"expiration_date\": \"06/2019\",\n" +
            "      \"amount\": \"500\",\n" +
            "      \"usage\": \"Coffeemaker\",\n" +
            "      \"transaction_type\": \"sale\",\n" +
            "      \"card_holder\": \"Panda Panda\",\n" +
            "      \"email\": \"panda@example.com\",\n" +
            "      \"address\": \"Panda Street, China\"\n" +
            "    }\n" +
            "}";
  }

  public static String paymentTransactionRallbackJson(Map<String, String> paymentTransactionProperties) {
    return "{\n" +
            "    \"payment_transaction\": {\n" +
            "      \"reference_id\": \"0e08644635ccb520c2eeb54f33865660\",\n" +
            "      \"transaction_type\": \"void\"\n" +
            "    }\n" +
            "}";
  }

}
