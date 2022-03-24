package com.semihshn.passengerservice.domain.contactInformation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactInformation {

    private Long id;
    private Long passengerId;
    private String type;
    private String address;
}
