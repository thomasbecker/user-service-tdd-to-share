package com.training.userservice.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 17.02.22.
 */
@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity extends IdEntity {
    private String street;

    private String streetNo;

    private String postalCode;

    private String city;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private UserEntity user;

    public AddressEntity() {
    }

    public AddressEntity(UUID id, String street, String streetNo, String postalCode, String city) {
        this.id = id;
        this.street = street;
        this.streetNo = streetNo;
        this.postalCode = postalCode;
        this.city = city;
    }
}
