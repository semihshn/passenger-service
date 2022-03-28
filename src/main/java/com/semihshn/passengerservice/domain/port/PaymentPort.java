package com.semihshn.passengerservice.domain.port;

import com.google.gson.JsonElement;
import com.semihshn.passengerservice.domain.api.Payment;
import com.semihshn.passengerservice.domain.passenger.Passenger;

public interface PaymentPort {

    JsonElement savePayment(Payment payment);

    void deletePayment(Long paymentId);

    JsonElement getPaymentById(Long paymentId);
}
