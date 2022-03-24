package com.semihshn.passengerservice.adapter.jpa.contactInfo;

import com.semihshn.passengerservice.adapter.jpa.common.Status;
import com.semihshn.passengerservice.adapter.jpa.passenger.PassengerEntity;
import com.semihshn.passengerservice.domain.contactInfo.ContactInfo;
import com.semihshn.passengerservice.domain.exception.ExceptionType;
import com.semihshn.passengerservice.domain.exception.SemDataNotFoundException;
import com.semihshn.passengerservice.domain.passenger.Passenger;
import com.semihshn.passengerservice.domain.port.ContactInfoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactInfoJpaAdapter implements ContactInfoPort {
    private final ContactInfoJpaRepository contactInformationJpaRepository;

    @Override
    public ContactInfo create(ContactInfo contactInformation, Passenger passenger) {

        PassengerEntity passengerEntity=PassengerEntity.from(passenger);

        return contactInformationJpaRepository.save(ContactInfoEntity
                .from(contactInformation,passengerEntity))
                .toModel();
    }

    @Override
    public void delete(Long id) {
        contactInformationJpaRepository.findById(id)
                .ifPresent(user -> {
                    user.setStatus(Status.DELETED);
                    contactInformationJpaRepository.save(user);
                });
    }

    @Override
    public ContactInfo retrieve(Long id) {
        return contactInformationJpaRepository.findById(id)
                .orElseThrow(() -> new SemDataNotFoundException(ExceptionType.CONTACT_INFO_DATA_NOT_FOUND))
                .toModel();
    }
}
