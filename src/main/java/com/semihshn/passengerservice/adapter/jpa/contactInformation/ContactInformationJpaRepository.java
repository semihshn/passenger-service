package com.semihshn.passengerservice.adapter.jpa.contactInformation;

import com.semihshn.passengerservice.adapter.jpa.passenger.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInformationJpaRepository extends JpaRepository<ContactInformationEntity, Long> {
}
