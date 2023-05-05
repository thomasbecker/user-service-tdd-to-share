package com.training.userservice.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 17.02.22.
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity extends IdEntity {

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<AddressEntity> addresses;

    public UserEntity() {
    }

    public UserEntity(UUID id, String firstName, String lastName, String email, Set<AddressEntity> addresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addresses = addresses;
        addresses.forEach(address -> address.setUser(this));
    }

    public UserEntity(String firstName, String lastName, String email, Set<AddressEntity> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addresses = addresses;
    }

    public void addAddress(AddressEntity address) {
        address.setUser(this);
        addresses.add(address);
    }
}
