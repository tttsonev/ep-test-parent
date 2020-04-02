package com.ep.api.tests.models;

public class JSONs {

  public static String paymentTransactionJson(TransactionImpl transaction) {
    return "{\n" +
            "    \"payment_transaction\": {\n" +
            "      \"card_number\": \""+transaction.getCard_number()+"\",\n" +
            "      \"cvv\": \""+transaction.getCvv()+"\",\n" +
            "      \"expiration_date\": \""+transaction.getExpiration_date()+"\",\n" +
            "      \"amount\": \""+transaction.getAmount()+"\",\n" +
            "      \"usage\": \""+transaction.getUsage()+"\",\n" +
            "      \"transaction_type\": \""+transaction.getTransaction_type()+"\",\n" +
            "      \"card_holder\": \""+transaction.getCard_holder()+"\",\n" +
            "      \"email\": \""+transaction.getEmail()+"\",\n" +
            "      \"address\": \""+transaction.getAddress()+"\"\n" +
            "    }\n" +
            "}";
  }

  public static String paymentTransactionRallbackJson(TransactionImpl transaction) {
    return "{\n" +
            "    \"payment_transaction\": {\n" +
            "      \"reference_id\": \""+transaction.getReference_id()+"\",\n" +
            "      \"transaction_type\": \""+transaction.getTransaction_type()+"\"\n" +
            "    }\n" +
            "}";
  }

}
