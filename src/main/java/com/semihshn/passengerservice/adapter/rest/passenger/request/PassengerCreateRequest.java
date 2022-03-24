package com.semihshn.passengerservice.adapter.rest.passenger.request;

import com.semihshn.passengerservice.domain.passenger.Passenger;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
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
