package com.semihshn.passengerservice.domain.port;

import com.semihshn.passengerservice.domain.passenger.Passenger;

public interface PassengerPort {
    Passenger create(Passenger passenger);

    void delete(Long id);

    Passenger retrieve(Long id);

    Passenger retrieveByUserId(Long userId);
}
