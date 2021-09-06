package com.example.judge2.service;

import com.example.judge2.model.entity.Role;
import com.example.judge2.model.entity.RoleNameEnum;

public interface RoleService {
    void initRoles ();

    Role findRole (RoleNameEnum roleNameEnum);
}
