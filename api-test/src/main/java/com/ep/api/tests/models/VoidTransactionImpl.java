package com.ep.api.tests.models;

import org.json.JSONObject;

import static com.ep.api.tests.BaseTest.epRestClient;
import static com.ep.api.tests.enums.TransactionTypes.VOID;
import static com.ep.api.tests.models.JSONs.paymentTransactionRallbackJson;

public class VoidTransactionImpl extends TransactionImpl {

    private SaleTransactionImpl saleTransaction;

    public VoidTransactionImpl() {
        super();
        this.transaction_type = VOID.label;
    }

    public VoidTransactionImpl(SaleTransactionImpl saleTransaction) {
        super();
        this.saleTransaction = saleTransaction;
        this.reference_id = saleTransaction.getUnique_id();
        this.transaction_type = VOID.label;
    }

    public void createExampleTransaction(){

    }

    public JSONObject run(){
        return epRestClient.postObject(epRestClient.getUrl()+"/payment_transactions", paymentTransactionRallbackJson(this));
    }
}
