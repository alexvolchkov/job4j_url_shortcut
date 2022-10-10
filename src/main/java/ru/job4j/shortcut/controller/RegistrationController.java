package ru.job4j.shortcut.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.shortcut.domain.RegDto;
import ru.job4j.shortcut.domain.SiteDto;
import ru.job4j.shortcut.service.RegService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegService regService;

    public RegistrationController(RegService regService) {
        this.regService = regService;
    }

    @PostMapping("")
    public ResponseEntity<RegDto> registration(@RequestBody SiteDto siteDao) {
        return new ResponseEntity<>(
                regService.registration(siteDao),
                HttpStatus.OK);
    }
}
