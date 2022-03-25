package com.semihshn.passengerservice.domain.passenger;

import com.semihshn.passengerservice.domain.port.PassengerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerPort passengerPort;

    public Long create(Passenger passenger) {
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
