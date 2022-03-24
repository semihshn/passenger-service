package com.semihshn.passengerservice.domain.contactInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactInfo {

    private Long id;
    private Long passengerId;
    private String type;
    private String address;
}
