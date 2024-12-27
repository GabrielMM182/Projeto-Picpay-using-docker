package com.picpay.picpayTerceiraVersao.service;

import com.picpay.picpayTerceiraVersao.controller.dto.CreateWalletDto;
import com.picpay.picpayTerceiraVersao.entity.Wallet;
import com.picpay.picpayTerceiraVersao.entity.WalletType;
import com.picpay.picpayTerceiraVersao.exception.WalletDataAlreadyExistsException;
import com.picpay.picpayTerceiraVersao.repository.WalletRepository;
import com.picpay.picpayTerceiraVersao.repository.WalletTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    private final WalletTypeRepository walletTypeRepository;


    public WalletService(WalletRepository walletRepository, WalletTypeRepository walletTypeRepository) {
        this.walletRepository = walletRepository;
        this.walletTypeRepository = walletTypeRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if(walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("cpfCnpj or emaail already exists");
        }

        // Busca o WalletType baseado na descrição fornecida no DTO
        WalletType walletType = walletTypeRepository
                .findByDescription(dto.walletType().get().getDescription())
                .orElseThrow(() -> new IllegalArgumentException("WalletType inválido: " + dto.walletType()));

        // Converte o DTO para Wallet, associando o WalletType encontrado
        Wallet wallet = new Wallet(
                dto.fullName(),
                dto.cpfCnpj(),
                dto.email(),
                dto.password(),
                walletType
        );

        return walletRepository.save(wallet);
    }
}
