package com.semihshn.passengerservice.domain.port;

import com.semihshn.passengerservice.domain.contactInfo.ContactInfo;
import com.semihshn.passengerservice.domain.passenger.Passenger;

public interface ContactInfoPort {
    ContactInfo create(ContactInfo contactInformation, Passenger passenger);

    void delete(Long id);

    ContactInfo retrieve(Long id);
}
