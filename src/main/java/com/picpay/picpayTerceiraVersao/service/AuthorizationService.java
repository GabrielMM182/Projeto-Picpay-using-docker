package com.picpay.picpayTerceiraVersao.service;

import com.picpay.picpayTerceiraVersao.client.AuthorizationClient;
import com.picpay.picpayTerceiraVersao.entity.Transfer;
import com.picpay.picpayTerceiraVersao.exception.PicPayException;
import org.springframework.stereotype.Service;

import java.awt.print.PrinterException;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(Transfer transfer) {
        var resp = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return resp.getBody().authorized();
    }
}
