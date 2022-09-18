package ru.job4j.shortcut.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.shortcut.domain.Role;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    List<Role> findByName(String name);
}
