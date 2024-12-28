package com.picpay.picpayTerceiraVersao.repository;

import com.picpay.picpayTerceiraVersao.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
