package com.training.userservice.model;

import com.training.userservice.persistence.AddressEntity;

import java.util.UUID;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 18.02.22.
 */
public record Address(UUID id, String street, String streetNo, String city, String postalCode) {
    public static Address from(AddressEntity address) {
        return new Address(address.getId(), address.getStreet(), address.getStreetNo(), address.getCity(),
                address.getPostalCode());
    }

    public AddressEntity toAddressEntity() {
        return new AddressEntity(id(), street(), streetNo(), city(), postalCode());
    }
}
