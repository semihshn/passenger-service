package com.semihshn.passengerservice.domain.port;

import com.semihshn.passengerservice.domain.contactInformation.ContactInformation;
import com.semihshn.passengerservice.domain.passenger.Passenger;

public interface ContactInformationPort {
    ContactInformation create(ContactInformation contactInformation, Passenger passenger);

    ContactInformation retrieve(Long id);
}
