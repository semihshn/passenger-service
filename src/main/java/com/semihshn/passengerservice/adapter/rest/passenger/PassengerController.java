package com.semihshn.passengerservice.adapter.rest.passenger;

import com.semihshn.passengerservice.adapter.rest.passenger.request.PassengerCreateRequest;
import com.semihshn.passengerservice.adapter.rest.passenger.response.PassengerCreateResponse;
import com.semihshn.passengerservice.adapter.rest.passenger.response.PassengerResponse;
import com.semihshn.passengerservice.domain.passenger.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) {
        passengerService.delete(userId);
    }

    @GetMapping("{passengerId}")
    public PassengerResponse retrieve(@PathVariable Long passengerId) {
        return PassengerResponse.from(passengerService.retrieve(passengerId));
    }

    @GetMapping("users/{userId}")
    public PassengerResponse retrieveByUserId(@PathVariable Long userId) {
        return PassengerResponse.from(passengerService.retrieveByUserId(userId));
    }
}
