package com.semihshn.passengerservice.domain.port;

import com.semihshn.passengerservice.domain.api.Payment;

public interface PaymentPort {

    Object savePayment(Payment payment);

    void deletePayment(Long paymentId);

    Object getPaymentById(Long paymentId);
}
