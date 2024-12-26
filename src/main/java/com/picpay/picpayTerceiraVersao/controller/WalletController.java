package com.picpay.picpayTerceiraVersao.controller;

import com.picpay.picpayTerceiraVersao.controller.dto.CreateWalletDto;
import com.picpay.picpayTerceiraVersao.entity.Wallet;
import com.picpay.picpayTerceiraVersao.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody CreateWalletDto dto) {

      var wallet = walletService.createWallet(dto);
        return ResponseEntity.ok(wallet);
    }
}
