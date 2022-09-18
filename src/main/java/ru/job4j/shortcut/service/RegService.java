package ru.job4j.shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4j.shortcut.domain.Person;
import ru.job4j.shortcut.domain.RegDao;
import ru.job4j.shortcut.domain.SiteDao;
import ru.job4j.shortcut.exception.PersonAlreadyExistException;

import java.util.Optional;
import java.util.Random;

@Service
public class RegService {
    private final String symbolPassword = "0123456789-+%ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final int lengthPassword = 7;
    private final PersonService persons;

    public RegService(PersonService persons) {
        this.persons = persons;
    }

    public RegDao registration(SiteDao siteDao) {
        RegDao rsl = RegDao.of(false, siteDao.getSite());
        Optional<Person> person = persons.findByUsername(siteDao.getSite());
        if (person.isEmpty()) {
            String password = generatePassword();
            rsl = RegDao.of(true, siteDao.getSite(), password);
            try {
                persons.save(rsl);
            } catch (PersonAlreadyExistException e) {
                rsl = RegDao.of(false, siteDao.getSite());
            }
        }
        return rsl;
    }

    private String generatePassword() {
        Random rnd = new Random();
        char[] text = new char[lengthPassword];
        for (int i = 0; i < text.length; i++) {
            text[i] = symbolPassword.charAt(rnd.nextInt(symbolPassword.length()));
        }
        return String.valueOf(text);
    }
}
