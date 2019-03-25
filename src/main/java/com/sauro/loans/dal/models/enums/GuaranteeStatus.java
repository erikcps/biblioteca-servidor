package com.sauro.loans.dal.models.enums;

public enum GuaranteeStatus {
    DEACTIVATED("desactivado"),
    ACTIVE("vigente"),
    CANCEL("cancelado"),
    AVAILABLE("disponible");

    private String text;

    GuaranteeStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static GuaranteeStatus fromString(String text) {
        for (GuaranteeStatus b : GuaranteeStatus.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
