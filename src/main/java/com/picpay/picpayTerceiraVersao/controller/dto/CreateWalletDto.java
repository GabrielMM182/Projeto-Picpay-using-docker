package com.picpay.picpayTerceiraVersao.controller.dto;

import com.picpay.picpayTerceiraVersao.entity.Wallet;
import com.picpay.picpayTerceiraVersao.entity.WalletType;
import com.picpay.picpayTerceiraVersao.repository.WalletTypeRepository;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Dados necessários para criar uma carteira")

public record CreateWalletDto(
        @Schema(description = "Nome completo do usuário", example = "João da Silva")
        @NotBlank String fullName,
        @Schema(description = "CPF ou CNPJ do usuário", example = "12345678909")

        @NotBlank String cpfCnpj,
                              @NotBlank String email,
                              @NotBlank String password,
        @Schema(description = "Tipo da carteira", example = "USER OU MERCHANT")

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