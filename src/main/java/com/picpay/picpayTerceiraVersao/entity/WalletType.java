package com.picpay.picpayTerceiraVersao.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tb_wallet_type")
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public WalletType() {

    }

    public WalletType(Long id, String description) {
    }

    public WalletType(String description) {
        this.description = description;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Enum {
        USER("user"),
        MERCHANT("merchant");

        Enum(String description) {
            this.description = description;
        }

        private final String description;

        public WalletType get() {
            return new WalletType(description);
        }
    }
}
