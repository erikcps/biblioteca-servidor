package com.sauro.manageloans.dal.models.enums;

public enum TypeStatusLoan {
    CANCEL("cancelado"),
    DEACTIVATE("baja"),
    ACTIVE("vigente");

    private String text;

    TypeStatusLoan(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static TypeStatusLoan fromString(String text) {
        for (TypeStatusLoan b : TypeStatusLoan.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
