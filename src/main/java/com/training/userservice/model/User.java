package com.training.userservice.model;

import com.training.userservice.persistence.AddressEntity;
import com.training.userservice.persistence.UserEntity;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 15.02.22.
 */
public record User(UUID id, String firstName, String lastName, String email, Set<Address> addresses) {
    public static User from(UserEntity user) {
        Set<Address> addresses = user.getAddresses().stream().map(Address::from).collect(Collectors.toSet());
        return new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), addresses);
    }

    public UserEntity toUserEntity() {
        Set<AddressEntity> addressEntities =
                this.addresses.stream().map(Address::toAddressEntity).collect(Collectors.toSet());
        return new UserEntity(id(), firstName(), lastName(), email(), addressEntities);
    }
}
