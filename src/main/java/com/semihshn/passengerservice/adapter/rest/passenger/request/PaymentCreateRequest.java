package com.semihshn.passengerservice.adapter.rest.passenger.request;

import com.semihshn.passengerservice.adapter.jpa.common.Status;
import com.semihshn.passengerservice.adapter.jpa.passenger.PassengerEntity;
import com.semihshn.passengerservice.domain.passenger.Passenger;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Setter
@Builder
@ToString
public class PaymentCreateRequest {

    private Long userId;
    private String cvv;

    private String expireDate;

    @Enumerated(EnumType.STRING)
    private CardType cardType;
    private String ccNo;
    private BigInteger amount;

    public enum CardType {
        DEBIT, CREDIT
    }
}
