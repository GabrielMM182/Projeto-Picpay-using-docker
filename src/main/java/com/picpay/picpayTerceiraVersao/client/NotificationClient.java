package com.picpay.picpayTerceiraVersao.client;

import com.picpay.picpayTerceiraVersao.client.dto.AuthorizationResponse;
import com.picpay.picpayTerceiraVersao.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "NotificationClient",
        url = "${client.notification-service.url}"
)
public interface NotificationClient {

    @PostMapping
    ResponseEntity<AuthorizationResponse> sendNotification(@RequestBody Transfer transfer); // se não tivesse retorno seria void no lugar de Authorization
}