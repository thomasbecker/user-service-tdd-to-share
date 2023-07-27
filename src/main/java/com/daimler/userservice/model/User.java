package com.daimler.userservice.model;

import java.util.UUID;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 27.07.23.
 */
public record User(UUID id, String firstName, String lastName, String email) {
}

