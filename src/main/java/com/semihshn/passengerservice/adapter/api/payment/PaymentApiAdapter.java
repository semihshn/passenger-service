package com.semihshn.passengerservice.adapter.api.payment;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.semihshn.passengerservice.adapter.api.retrofit.RetrofitUtil;
import com.semihshn.passengerservice.domain.api.Payment;
import com.semihshn.passengerservice.domain.passenger.Passenger;
import com.semihshn.passengerservice.domain.port.PaymentPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class PaymentApiAdapter implements PaymentPort {

    @Autowired
    private PaymentRequest paymentServiceRequest;

    @Override
    public JsonElement savePayment(Payment payment) {
        return RetrofitUtil.executeInBlock(paymentServiceRequest.savePayment(new Gson().toJsonTree(payment)));
    }

    @Override
    public void deletePayment(Long paymentId) {

    }

    @Override
    public JsonElement getPaymentById(Long paymentId) {
        return null;
    }
}
