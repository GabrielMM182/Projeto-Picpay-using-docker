package com.picpay.picpayTerceiraVersao.config;

import com.picpay.picpayTerceiraVersao.entity.WalletType;
import com.picpay.picpayTerceiraVersao.repository.WalletTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {
    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Arrays.stream(WalletType.Enum.values()).forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }
}
