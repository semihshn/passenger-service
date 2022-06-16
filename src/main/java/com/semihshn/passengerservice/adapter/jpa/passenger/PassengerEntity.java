package com.semihshn.passengerservice.adapter.jpa.passenger;

import com.semihshn.passengerservice.adapter.jpa.common.BaseEntity;
import com.semihshn.passengerservice.adapter.jpa.common.Status;
import com.semihshn.passengerservice.adapter.jpa.contactInfo.ContactInfoEntity;
import com.semihshn.passengerservice.domain.passenger.Passenger;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "passengers")
@Table(name = "passengers")
@Where(clause = "status <> 'DELETED'")
public class PassengerEntity extends BaseEntity {

    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "passenger")
    private List<ContactInfoEntity> contactInformationEntities;

    public static PassengerEntity from(Passenger passenger) {
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.id = passenger.getId();
        passengerEntity.userId=passenger.getUserId();
        passengerEntity.firstName = passenger.getFirstName();
        passengerEntity.lastName = passenger.getLastName();
        passengerEntity.birthDate = passenger.getBirhDate();
        passengerEntity.status = Status.ACTIVE;
        return passengerEntity;
    }

    public Passenger toModel() {
        return Passenger.builder()
                .id(id)
                .userId(userId)
                .firstName(firstName)
                .lastName(lastName)
                .birhDate(birthDate)
                .build();
    }
}
