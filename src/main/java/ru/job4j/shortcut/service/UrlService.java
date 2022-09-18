package ru.job4j.shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4j.shortcut.domain.Url;
import ru.job4j.shortcut.repository.UrlRepository;

import java.util.Optional;

@Service
public class UrlService {
    private final String symbolUrl = "0123456789abcdefghijklmnopqrstuvwxyz";
    private final UrlRepository urls;

    public UrlService(UrlRepository urls) {
        this.urls = urls;
    }

    public Optional<Url> findByUrl(String url) {
        return urls.findByUrl(url);
    }

    public String convert(Url url) {
        Optional<Url> urlDB = findByUrl(url.getUrl());
        String code;
        if (urlDB.isEmpty()) {
            urls.save(url);
            code = convertUrl(url.getId());
            url.setCode(code);
            urls.save(url);
        } else {
           code = urlDB.get().getCode();
        }
        return code;
    }

    private String convertUrl(int id) {
        int base = symbolUrl.length();
        StringBuilder rsl = new StringBuilder();
        while (id > 0) {
            rsl.append(symbolUrl.charAt(id % base));
            id /= base;
        }
        return rsl.reverse().toString();
    }

    public Optional<Url> findByCode(String code) {
        return urls.findByCode(code);
    }
}
