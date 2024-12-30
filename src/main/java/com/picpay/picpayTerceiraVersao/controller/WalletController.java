package com.picpay.picpayTerceiraVersao.controller;

import com.picpay.picpayTerceiraVersao.controller.dto.CreateWalletDto;
import com.picpay.picpayTerceiraVersao.entity.Wallet;
import com.picpay.picpayTerceiraVersao.repository.WalletRepository;
import com.picpay.picpayTerceiraVersao.repository.WalletTypeRepository;
import com.picpay.picpayTerceiraVersao.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Carteiras", description = "Gerenciamento de carteiras")
public class WalletController {

private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    @Operation(
            summary = "Criar uma nova carteira",
            description = "Endpoint para criar uma nova carteira com base nos dados fornecidos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Carteira criada com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Erro de validação")
            }
    )
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDto dto) {

      var wallet = walletService.createWallet(dto);
        return ResponseEntity.ok(wallet);
    }
}
