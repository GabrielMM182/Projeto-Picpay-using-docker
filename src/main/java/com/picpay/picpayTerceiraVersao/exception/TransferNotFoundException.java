package com.picpay.picpayTerceiraVersao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.util.UUID;

public class TransferNotFoundException extends PicPayException{

    private UUID uuid;

    public TransferNotFoundException(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public ProblemDetail toProblemDetail() {

        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Transfer not found");
        pb.setDetail("There is no Transfer with id " + uuid + ".");

        return pb;
    }
}
