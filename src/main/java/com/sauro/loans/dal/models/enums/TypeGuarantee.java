package com.sauro.manageloans.dal.models.enums;

public enum TypeGuarantee {
    JYA("joyas"),
    ELE("electrodomesticos"),
    COM("computadoras"),
    VHC("vehiculos"),
    MTO("motocicletas"),
    MAQ("maquinas"),
    IMS("impresoras"),
    OTR("otros");

    private String text;

    TypeGuarantee(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static TypeGuarantee fromString(String text) {
        for (TypeGuarantee b : TypeGuarantee.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
