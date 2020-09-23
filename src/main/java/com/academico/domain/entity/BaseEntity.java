package com.academico.domain.entity;

import java.lang.Class;
import java.util.UUID;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseEntity {

    @Id
    private UUID id;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean isNew() {
        return this.id == null;
    }

    public void create() {
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object entity) {
        if (entity == this) {
            return true;
        } else if (entity instanceof BaseEntity && ((BaseEntity)entity).getId().equals(this.id)) {
            return true;
        } else {
            return false;
        }
    }
}
