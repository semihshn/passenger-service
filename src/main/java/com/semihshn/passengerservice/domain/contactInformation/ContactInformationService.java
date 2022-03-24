package com.semihshn.passengerservice.domain.contactInformation;

import com.semihshn.passengerservice.adapter.jpa.passenger.PassengerEntity;
import com.semihshn.passengerservice.domain.passenger.Passenger;
import com.semihshn.passengerservice.domain.port.ContactInformationPort;
import com.semihshn.passengerservice.domain.port.PassengerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactInformationService {

    private final ContactInformationPort contactInformationPort;
    private final PassengerPort passengerPort;

    public Long create(ContactInformation contactInformation) {
        Passenger passenger=passengerPort.retrieve(contactInformation.getPassengerId());
        ContactInformation temp=contactInformationPort.create(contactInformation,passenger);
        return temp.getId();
    }

    public ContactInformation retrieve(Long id) {
        return contactInformationPort.retrieve(id);
    }
}
