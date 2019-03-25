package com.sauro.loans.dal.models.enums;

public enum TypeClient {
    PRT("particular"),
    EMP("empresa"),
    GOB("gobierno"),
    SID("sindicato"),
    ASC("asociacion"),
    COP("coperativa");

    private String text;

    TypeClient(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static TypeClient fromString(String text) {
        for (TypeClient b : TypeClient.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
