package com.semihshn.passengerservice.adapter.api.payment;

import com.semihshn.passengerservice.adapter.api.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "payment-service"//Name of payment-service application
        , path = "/api/payments"//Pre-path for payment-service
        , url = "${payment.service.url}"
        , configuration = FeignConfiguration.class
)
public interface PaymentRequest {

    @PostMapping
    Object savePayment(@RequestBody Object requestBody);

    @DeleteMapping("{paymentId}")
    void deletePayment(@PathVariable("paymentId") Long paymentId);

    @GetMapping("{paymentId}")
    Object getPaymentById(@PathVariable("paymentId") Long paymentId);
}
