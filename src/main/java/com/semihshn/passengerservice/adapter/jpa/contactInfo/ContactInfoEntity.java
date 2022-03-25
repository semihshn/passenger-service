package com.semihshn.passengerservice.adapter.jpa.contactInfo;

import com.semihshn.passengerservice.adapter.jpa.common.Status;
import com.semihshn.passengerservice.adapter.jpa.passenger.PassengerEntity;
import com.semihshn.passengerservice.adapter.jpa.common.BaseEntity;
import com.semihshn.passengerservice.domain.contactInfo.ContactInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "contact_informations")
@Table(name = "contact_informations")
public class ContactInfoEntity extends BaseEntity {

    private String type;
    private String address;

    @ManyToOne
    private PassengerEntity passenger;

    public static ContactInfoEntity from(ContactInfo contactInformation, PassengerEntity passenger) {
        ContactInfoEntity contactInformationEntity = new ContactInfoEntity();
        contactInformationEntity.type = contactInformation.getType();
        contactInformationEntity.address = contactInformation.getAddress();
        contactInformationEntity.passenger = passenger;
        contactInformationEntity.status = Status.ACTIVE;
        return contactInformationEntity;
    }

    public ContactInfo toModel() {
        return ContactInfo.builder()
                .id(id)
                .type(type)
                .address(address)
                .build();
    }
}
