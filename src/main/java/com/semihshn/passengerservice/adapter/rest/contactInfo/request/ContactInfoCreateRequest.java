package com.semihshn.passengerservice.adapter.rest.contactInfo.request;

import com.semihshn.passengerservice.domain.contactInfo.ContactInfo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContactInfoCreateRequest {

    @NotNull
    private Long passengerId;

    @NotBlank
    private String type;

    @NotBlank
    private String address;

    public ContactInfo convertToContactInformation() {
        return ContactInfo.builder()
                .type(type)
                .address(address)
                .passengerId(passengerId)
                .build();
    }

}
