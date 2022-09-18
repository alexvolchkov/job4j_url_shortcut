package ru.job4j.shortcut.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.shortcut.domain.Person;
import ru.job4j.shortcut.domain.RegDao;
import ru.job4j.shortcut.domain.Role;
import ru.job4j.shortcut.exception.PersonAlreadyExistException;
import ru.job4j.shortcut.repository.PersonRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class PersonService implements UserDetailsService {
    private final PersonRepository persons;
    private final RoleService roles;
    private final BCryptPasswordEncoder encoder;

    public PersonService(PersonRepository persons, RoleService roles, BCryptPasswordEncoder encoder) {
        this.persons = persons;
        this.roles = roles;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return persons.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " не существует"));
    }

    public Person save(RegDao regDao) throws PersonAlreadyExistException {
        if (findByUsername(regDao.getLogin()).isPresent()) {
            throw new PersonAlreadyExistException("Пользователь уже существует с именем " + regDao.getLogin());
        }
        Role role = roles.findByName("ROLE_USER").orElseGet(null);
        Person person = Person.of(regDao.getLogin(), encoder.encode(regDao.getPassword()), Set.of(role));
        return persons.save(person);
    }

    public Optional<Person> findByUsername(String username) {
        return persons.findByUsername(username);
    }
}
