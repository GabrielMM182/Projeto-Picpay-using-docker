package com.picpay.picpayTerceiraVersao.service;

import com.picpay.picpayTerceiraVersao.controller.dto.CreateWalletDto;
import com.picpay.picpayTerceiraVersao.entity.Wallet;
import com.picpay.picpayTerceiraVersao.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        return walletRepository.save(dto.toWallet());
    }
}
