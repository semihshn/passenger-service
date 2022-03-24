package com.semihshn.passengerservice.adapter.jpa.contactInformation;

import com.semihshn.passengerservice.adapter.jpa.passenger.PassengerEntity;
import com.semihshn.passengerservice.adapter.jpa.passenger.PassengerJpaRepository;
import com.semihshn.passengerservice.domain.contactInformation.ContactInformation;
import com.semihshn.passengerservice.domain.exception.ExceptionType;
import com.semihshn.passengerservice.domain.exception.SemDataNotFoundException;
import com.semihshn.passengerservice.domain.passenger.Passenger;
import com.semihshn.passengerservice.domain.port.ContactInformationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactInformationJpaAdapter implements ContactInformationPort {
    private final ContactInformationJpaRepository contactInformationJpaRepository;

    @Override
    public ContactInformation create(ContactInformation contactInformation, Passenger passenger) {

        PassengerEntity passengerEntity=PassengerEntity.from(passenger);

        return contactInformationJpaRepository.save(ContactInformationEntity
                .from(contactInformation,passengerEntity))
                .toModel();
    }

    @Override
    public ContactInformation retrieve(Long id) {
        return contactInformationJpaRepository.findById(id)
                .orElseThrow(() -> new SemDataNotFoundException(ExceptionType.CONTACT_INFO_DATA_NOT_FOUND))
                .toModel();
    }
}
