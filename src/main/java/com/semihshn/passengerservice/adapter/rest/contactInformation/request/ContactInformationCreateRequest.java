package com.semihshn.passengerservice.adapter.rest.contactInformation.request;

import com.semihshn.passengerservice.domain.contactInformation.ContactInformation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContactInformationCreateRequest {

    @NotNull
    private Long passengerId;

    @NotBlank
    private String type;

    @NotBlank
    private String address;

    public ContactInformation convertToContactInformation() {
        return ContactInformation.builder()
                .type(type)
                .address(address)
                .passengerId(passengerId)
                .build();
    }

}
