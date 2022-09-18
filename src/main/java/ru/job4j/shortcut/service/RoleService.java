package ru.job4j.shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4j.shortcut.domain.Role;
import ru.job4j.shortcut.repository.RoleRepository;

import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roles;

    public RoleService(RoleRepository roles) {
        this.roles = roles;
    }

    public Optional<Role> findByName(String name) {
        return roles.findByName(name).stream().findAny();
    }

}
