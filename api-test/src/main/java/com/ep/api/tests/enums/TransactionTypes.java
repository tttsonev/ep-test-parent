package com.ep.api.tests.enums;

public enum TransactionTypes {
    SALE("sale"),
    VOID("void");

    public final String label;

    private TransactionTypes(String label) {
        this.label = label;
    }
}
