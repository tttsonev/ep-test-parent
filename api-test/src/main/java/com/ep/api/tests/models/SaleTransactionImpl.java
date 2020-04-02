package com.ep.api.tests.models;

import org.json.JSONObject;

import static com.ep.api.tests.BaseTest.epRestClient;
import static com.ep.api.tests.enums.TransactionTypes.SALE;
import static com.ep.api.tests.models.JSONs.paymentTransactionJson;

public class SaleTransactionImpl extends TransactionImpl {

    public SaleTransactionImpl() {
        super();
        super.transaction_type = SALE.label;
    }

    @Override
    public void createExampleTransaction(){
        super.card_number = "4200000000000000";
        super.cvv = "123";
        super.expiration_date = "06/2019";
        super.amount = "500";
        super.usage = "Coffeemaker";
        super.card_holder = "Panda Panda";
        super.email = "panda@example.com";
        super.address = "Panda Street, China";
    }

    public JSONObject run(){

        JSONObject response = null;
        response = epRestClient.postObject(epRestClient.getUrl()+"/payment_transactions", paymentTransactionJson(this));
        if(epRestClient.getStatusCode()==200){
            super.setUnique_id(response.getString("unique_id"));
        }
        return response;


    }
}
