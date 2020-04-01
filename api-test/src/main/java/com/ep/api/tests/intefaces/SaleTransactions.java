package com.ep.api.tests.intefaces;

import org.json.JSONObject;

import java.util.Map;

public interface SaleTransactions {


    JSONObject makeSaleTransaction(Map<String, String> properties);
}
