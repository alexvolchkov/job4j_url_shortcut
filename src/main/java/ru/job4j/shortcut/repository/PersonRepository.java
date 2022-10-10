package ru.job4j.shortcut.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.shortcut.domain.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query(value = "from Person p left join fetch p.roles where p.username = :username")
    Optional<Person> findByUsername(String username);
}
