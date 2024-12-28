package com.picpay.picpayTerceiraVersao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InvalidWalletType extends PicPayException{

    private final String invalidType;

    public InvalidWalletType(String invalidType) {
        this.invalidType = invalidType;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb =  ProblemDetail.forStatus(HttpStatus.BAD_GATEWAY);
        pb.setTitle("Invalid Wallet Type");
        pb.setDetail("The provided wallet type '" + invalidType + "' is not valid. Allowed types are 'USER' and 'MERCHANT'.");
        return pb;
    }
}