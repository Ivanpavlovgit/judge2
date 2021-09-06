package com.example.judge2.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private RoleNameEnum role;

    public Role (RoleNameEnum role) {
        this.role=role;
    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnum getRole () {
        return this.role;
    }

    public Role setRole (RoleNameEnum role) {
        this.role = role;
        return this;
    }

    public Role () {
    }
}
