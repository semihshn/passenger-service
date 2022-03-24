package com.semihshn.passengerservice.adapter.rest.passenger.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.semihshn.passengerservice.domain.contactInformation.ContactInformation;
import com.semihshn.passengerservice.domain.passenger.Passenger;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PassengerCreateRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private LocalDate birhDate;

    public Passenger convertToPassenger() {
        return Passenger.builder()
                .firstName(firstName)
                .lastName(lastName)
                .birhDate(birhDate)
                .build();
    }
}
