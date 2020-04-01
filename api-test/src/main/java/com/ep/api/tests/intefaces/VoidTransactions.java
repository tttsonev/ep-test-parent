package com.ep.api.tests.intefaces;

import org.json.JSONObject;

import java.util.Map;

public interface VoidTransactions {
    JSONObject makeVoidTransaction(Map<String, String> properties);
}
