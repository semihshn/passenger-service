package com.semihshn.passengerservice.adapter.rest.contactInformation.response;

import com.semihshn.passengerservice.domain.contactInformation.ContactInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactInformationResponse {
    private Long id;
    private String type;
    private String address;

    public static ContactInformationResponse from(ContactInformation contact) {
        return ContactInformationResponse.builder()
                .id(contact.getId())
                .type(contact.getType())
                .address(contact.getAddress())
                .build();
    }
}
