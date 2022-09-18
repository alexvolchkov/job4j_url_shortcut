package ru.job4j.shortcut.exception;

public class PersonAlreadyExistException extends Exception {
    public PersonAlreadyExistException(String message) {
        super(message);
    }
}
