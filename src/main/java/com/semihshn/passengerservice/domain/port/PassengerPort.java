package com.semihshn.passengerservice.domain.port;

import com.semihshn.passengerservice.domain.passenger.Passenger;

public interface PassengerPort {
    Passenger create(Passenger passenger);

    Passenger retrieve(Long id);
}
