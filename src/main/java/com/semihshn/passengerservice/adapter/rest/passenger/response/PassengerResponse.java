package com.semihshn.passengerservice.adapter.rest.passenger.response;

import com.semihshn.passengerservice.domain.passenger.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerResponse {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate birhDate;

    public static PassengerResponse from(Passenger passenger) {
        return PassengerResponse.builder()
                .id(passenger.getId())
                .userId(passenger.getUserId())
                .firstName(passenger.getFirstName())
                .lastName(passenger.getLastName())
                .birhDate(passenger.getBirhDate())
                .build();
    }
}
