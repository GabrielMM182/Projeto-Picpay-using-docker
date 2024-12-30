package com.picpay.picpayTerceiraVersao.controller;

import com.picpay.picpayTerceiraVersao.controller.dto.TransferDto;
import com.picpay.picpayTerceiraVersao.entity.Transfer;
import com.picpay.picpayTerceiraVersao.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto dto) {

        var resp = transferService.transfer(dto);

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/transfer/{uuid}")
    public ResponseEntity<Transfer> getTransfer(@PathVariable UUID uuid) {
        return ResponseEntity.ok(transferService.getTransfer(uuid));
    }

    @GetMapping("/transfer")
    public ResponseEntity<List<Transfer>> getListTransfer() {
        return ResponseEntity.ok(transferService.getListTransfer());
    }

}