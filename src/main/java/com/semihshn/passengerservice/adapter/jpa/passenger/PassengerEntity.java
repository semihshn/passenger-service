package com.semihshn.passengerservice.adapter.jpa.passenger;

import com.semihshn.passengerservice.adapter.jpa.common.BaseEntity;
import com.semihshn.passengerservice.adapter.jpa.common.Status;
import com.semihshn.passengerservice.adapter.jpa.contactInfo.ContactInfoEntity;
import com.semihshn.passengerservice.domain.passenger.Passenger;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "passengers")
@Table(name = "passengers")
public class PassengerEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    private LocalDate birhDate;

    @OneToMany(mappedBy = "passenger")
    private List<ContactInfoEntity> contactInformationEntities;

    public static PassengerEntity from(Passenger passenger) {
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.id=passenger.getId();
        passengerEntity.firstName= passenger.getFirstName();
        passengerEntity.lastName=passenger.getLastName();
        passengerEntity.birhDate=passenger.getBirhDate();
        passengerEntity.status= Status.ACTIVE;
        return passengerEntity;
    }

    public Passenger toModel() {
        return Passenger.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .birhDate(birhDate)
                .build();
    }
}