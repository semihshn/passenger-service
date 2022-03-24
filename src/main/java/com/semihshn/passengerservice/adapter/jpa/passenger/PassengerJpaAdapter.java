package com.semihshn.passengerservice.adapter.jpa.passenger;

import com.semihshn.passengerservice.domain.exception.ExceptionType;
import com.semihshn.passengerservice.domain.exception.SemDataNotFoundException;
import com.semihshn.passengerservice.domain.passenger.Passenger;
import com.semihshn.passengerservice.domain.port.PassengerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerJpaAdapter implements PassengerPort {
    private final PassengerJpaRepository passengerJpaRepository;

    @Override
    public Passenger create(Passenger passenger) {
        return passengerJpaRepository.save(PassengerEntity.from(passenger)).toModel();
    }

    @Override
    public Passenger retrieve(Long id) {
        return retrievePassengerEntity(id)
                .toModel();
    }

    private PassengerEntity retrievePassengerEntity(Long id) {
        return passengerJpaRepository.findById(id)
                .orElseThrow(() -> new SemDataNotFoundException(ExceptionType.PASSENGER_DATA_NOT_FOUND));
    }
}
