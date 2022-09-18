package ru.job4j.shortcut.controller;

import org.springframework.web.bind.annotation.*;
import ru.job4j.shortcut.domain.UrlStatisticDao;
import ru.job4j.shortcut.service.UrlStatisticService;

import java.util.List;

@RestController
public class UrStatisticController {
    private final UrlStatisticService urls;

    public UrStatisticController(UrlStatisticService urls) {
        this.urls = urls;
    }

    @GetMapping("/statistic")
    public List<UrlStatisticDao> statistic() {
        return urls.statistic();
    }
}
