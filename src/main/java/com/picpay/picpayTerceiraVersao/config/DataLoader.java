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
    public void run(String... args) throws Exception {
//        if (walletTypeRepository.count() == 0) {
//            WalletType userWalletType = new WalletType(1L, "user");
//            WalletType merchantWalletType = new WalletType(2L, "merchant");
//
//            walletTypeRepository.save(userWalletType);
//            walletTypeRepository.save(merchantWalletType);
//        }
//    }
        Arrays.stream(WalletType.Enum.values()).forEach(walletTypeEnum -> {
            String description = walletTypeEnum.get().getDescription();

            // Verifica se já existe um WalletType com essa descrição no banco
            if (walletTypeRepository.findByDescription(description).isEmpty()) {
                walletTypeRepository.save(walletTypeEnum.get());
            }
        });
    }
}
