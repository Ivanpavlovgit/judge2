package com.example.judge2.service.impl;

import com.example.judge2.model.entity.Role;
import com.example.judge2.model.entity.RoleNameEnum;
import com.example.judge2.repository.RoleRepository;
import com.example.judge2.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles () {
        if (this.roleRepository.count () == 0) {
            var adminRole = new Role (RoleNameEnum.ADMIN);
            var userRole  = new Role (RoleNameEnum.USER);
            this.roleRepository.save (adminRole);
            this.roleRepository.save (userRole);
        }
    }

    @Override
    public Role findRole (RoleNameEnum roleNameEnum) {
        return this.roleRepository
                .findByRole (roleNameEnum)
                .orElse (null);

    }
}
