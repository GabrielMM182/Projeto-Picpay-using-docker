package com.picpay.picpayTerceiraVersao.entity;

public enum WalletTypeEnum {
    USER(1L, "user"),
    MERCHANT(2L, "merchant");

    private final Long id;
    private final  String description;

    WalletTypeEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public WalletType getWalletType() {
        return new WalletType(id, description);
    }
}
