package ru.job4j.shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4j.shortcut.domain.Person;
import ru.job4j.shortcut.domain.RegDto;
import ru.job4j.shortcut.domain.SiteDto;
import ru.job4j.shortcut.exception.PersonAlreadyExistException;
import ru.job4j.shortcut.utilite.RandomGeneration;

import java.util.Optional;

@Service
public class RegService {
    private final PersonService persons;

    public RegService(PersonService persons) {
        this.persons = persons;
    }

    public RegDto registration(SiteDto siteDao) {
        RegDto rsl = RegDto.of(false, siteDao.getSite());
        Optional<Person> person = persons.findByUsername(siteDao.getSite());
        if (person.isEmpty()) {
            String password = RandomGeneration.generatePassword();
            rsl = RegDto.of(true, siteDao.getSite(), password);
            try {
                persons.save(rsl);
            } catch (PersonAlreadyExistException e) {
                rsl = RegDto.of(false, siteDao.getSite());
            }
        }
        return rsl;
    }
}
