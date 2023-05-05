package com.training.userservice.persistence;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 17.02.22.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class IdEntity {
    @Id
    @GeneratedValue
    @org.hibernate.annotations.Type(type = "uuid-char")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    protected UUID id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdEntity idEntity = (IdEntity) o;
        return Objects.equals(id, idEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
