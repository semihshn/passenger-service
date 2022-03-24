package com.semihshn.passengerservice.domain.passenger;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Passenger {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birhDate;
}
