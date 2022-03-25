package com.semihshn.passengerservice.adapter.rest.passenger;

import com.google.gson.Gson;
import com.semihshn.passengerservice.adapter.api.retrofit.RetrofitUtil;
import com.semihshn.passengerservice.adapter.rest.passenger.request.PassengerCreateRequest;
import com.semihshn.passengerservice.adapter.rest.passenger.request.PaymentCreateRequest;
import com.semihshn.passengerservice.adapter.rest.passenger.response.PassengerCreateResponse;
import com.semihshn.passengerservice.adapter.rest.passenger.response.PassengerResponse;
import com.semihshn.passengerservice.domain.passenger.PassengerService;
import com.semihshn.passengerservice.domain.port.PaymentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService passengerService;
    private final PaymentPort paymentPort;

    @PostMapping()
    public PassengerCreateResponse create(@RequestBody @Valid PassengerCreateRequest request) {
        PaymentCreateRequest createRequest=PaymentCreateRequest.builder()
                .userId(1L)
                .cvv("225")
                .expireDate("2020-08-22")
                .cardType(PaymentCreateRequest.CardType.CREDIT)
                .ccNo("1123456894067408")
                .amount(new BigInteger("12423"))
                .build();

        RetrofitUtil.executeInBlock(paymentPort.savePayment(new Gson().toJsonTree(createRequest)));

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
