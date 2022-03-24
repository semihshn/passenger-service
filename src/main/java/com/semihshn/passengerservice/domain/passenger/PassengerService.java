package com.semihshn.passengerservice.domain.passenger;

import com.semihshn.passengerservice.domain.contactInformation.ContactInformation;
import com.semihshn.passengerservice.domain.port.ContactInformationPort;
import com.semihshn.passengerservice.domain.port.PassengerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerPort passengerPort;

    public Long create(Passenger passenger) {
        Passenger temp=passengerPort.create(passenger);
        return temp.getId();
    }

    public Passenger retrieve(Long id) {
        return passengerPort.retrieve(id);
    }
}
