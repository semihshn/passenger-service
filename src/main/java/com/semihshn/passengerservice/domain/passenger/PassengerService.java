package com.semihshn.passengerservice.domain.passenger;

import com.semihshn.passengerservice.domain.api.Payment;
import com.semihshn.passengerservice.domain.port.PassengerPort;
import com.semihshn.passengerservice.domain.port.PaymentPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerPort passengerPort;
    private final PaymentPort paymentPort;

    public Long create(Passenger passenger) {

        log.info("payment creating...");
        paymentPort.savePayment(
                Payment.builder()
                        .userId(1L)
                        .cvv("225")
                        .expireDate("2020-08-22")
                        .cardType(Payment.CardType.CREDIT)
                        .ccNo("1123456894067408")
                        .amount(new BigInteger("12423"))
                        .build()
        );

        Passenger temp = passengerPort.create(passenger);
        return temp.getId();
    }

    public Passenger retrieve(Long id) {
        return passengerPort.retrieve(id);
    }

    public Passenger retrieveByUserId(Long id) {

        return passengerPort.retrieveByUserId(id);
    }

    public void delete(Long id) {
        passengerPort.delete(id);
    }
}
