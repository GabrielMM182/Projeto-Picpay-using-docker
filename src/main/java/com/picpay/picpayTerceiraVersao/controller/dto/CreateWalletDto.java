package com.picpay.picpayTerceiraVersao.controller.dto;

import com.picpay.picpayTerceiraVersao.entity.Wallet;
import com.picpay.picpayTerceiraVersao.entity.WalletType;
import com.picpay.picpayTerceiraVersao.repository.WalletTypeRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CreateWalletDto(
        @NotBlank String fullName,

        @NotBlank String cpfCnpj,
                              @NotBlank String email,
                              @NotBlank String password,

        @NotNull WalletType.Enum walletType) {

    public Wallet toWallet(WalletTypeRepository walletTypeRepository) {
        WalletType walletTypeEntity = walletTypeRepository.findByDescription(walletType.get().getDescription())
                .orElseThrow(() -> new IllegalArgumentException("WalletType inválido: " + walletType));
        return new Wallet(
                fullName,
                cpfCnpj,
                email,
                password,
                walletType.get()
        );
    }
}