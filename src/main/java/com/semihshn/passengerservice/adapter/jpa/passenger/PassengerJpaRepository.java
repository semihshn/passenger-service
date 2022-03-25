package com.semihshn.passengerservice.adapter.jpa.passenger;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerJpaRepository extends JpaRepository<PassengerEntity, Long> {
    Optional<PassengerEntity> findByUserId(Long userId);
}
