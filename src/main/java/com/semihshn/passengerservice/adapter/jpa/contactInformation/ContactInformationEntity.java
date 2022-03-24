package com.semihshn.passengerservice.adapter.jpa.contactInformation;

import com.semihshn.passengerservice.adapter.jpa.passenger.PassengerEntity;
import com.semihshn.passengerservice.adapter.jpa.common.BaseEntity;
import com.semihshn.passengerservice.domain.contactInformation.ContactInformation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "contact_informations")
@Table(name = "contact_informations")
public class ContactInformationEntity extends BaseEntity {

    private String type;
    private String address;

    @ManyToOne
    private PassengerEntity passenger;

    public static ContactInformationEntity from(ContactInformation contactInformation, PassengerEntity passenger) {
        ContactInformationEntity contactInformationEntity = new ContactInformationEntity();
        contactInformationEntity.type= contactInformation.getType();
        contactInformationEntity.address=contactInformation.getAddress();
        contactInformationEntity.passenger=passenger;
        return contactInformationEntity;
    }

    public ContactInformation toModel() {
        return ContactInformation.builder()
                .id(id)
                .type(type)
                .address(address)
                .build();
    }
}
