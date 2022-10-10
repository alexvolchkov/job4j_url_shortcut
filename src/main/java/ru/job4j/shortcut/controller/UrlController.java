package ru.job4j.shortcut.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.shortcut.domain.Url;
import ru.job4j.shortcut.domain.UrlStatisticDto;
import ru.job4j.shortcut.service.UrlService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@RestController
public class UrlController {
    private final UrlService urls;

    public UrlController(UrlService urls) {
        this.urls = urls;
    }

    @PostMapping("/convert")
    public ResponseEntity<Map<String, String>> convert(@RequestBody Url url) {
        String code = urls.convert(url);
        return ResponseEntity.ok(Map.of("code", code));
    }

    @GetMapping("/redirect/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) throws URISyntaxException {
        Url url = urls.findByCode(code).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Url с кодом " + code + " не найден.")
        );
        urls.incrementCount(code);
        return ResponseEntity.status(HttpStatus.FOUND).location(new URI(url.getUrl())).build();
    }

    @GetMapping("/statistic")
    public List<UrlStatisticDto> statistic() {
        return urls.statistic();
    }
}
