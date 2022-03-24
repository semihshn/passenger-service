package com.semihshn.passengerservice.domain.contactInfo;

import com.semihshn.passengerservice.domain.passenger.Passenger;
import com.semihshn.passengerservice.domain.port.ContactInfoPort;
import com.semihshn.passengerservice.domain.port.PassengerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactInfoService {

    private final ContactInfoPort contactInformationPort;
    private final PassengerPort passengerPort;

    public Long create(ContactInfo contactInformation) {
        Passenger passenger=passengerPort.retrieve(contactInformation.getPassengerId());
        ContactInfo temp=contactInformationPort.create(contactInformation,passenger);
        return temp.getId();
    }

    public ContactInfo retrieve(Long id) {
        return contactInformationPort.retrieve(id);
    }
}
