package com.semihshn.passengerservice.adapter.jpa.passenger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerJpaRepository extends JpaRepository<PassengerEntity, Long> {
}
