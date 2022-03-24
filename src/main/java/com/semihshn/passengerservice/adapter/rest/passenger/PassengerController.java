package com.semihshn.passengerservice.adapter.rest.passenger;

import com.semihshn.passengerservice.adapter.rest.passenger.request.PassengerCreateRequest;
import com.semihshn.passengerservice.adapter.rest.passenger.response.PassengerCreateResponse;
import com.semihshn.passengerservice.adapter.rest.passenger.response.PassengerResponse;
import com.semihshn.passengerservice.domain.passenger.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping()
    public PassengerCreateResponse create(@RequestBody @Valid PassengerCreateRequest request) {
        Long createdPassengerId = passengerService.create(request.convertToPassenger());
        return PassengerCreateResponse.builder().id(createdPassengerId).build();
    }

    @GetMapping("{passengerId}")
    public PassengerResponse retrieve(@PathVariable Long passengerId) {
        return PassengerResponse.from(passengerService.retrieve(passengerId));
    }
}
