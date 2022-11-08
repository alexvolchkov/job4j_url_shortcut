package ru.job4j.shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4j.shortcut.domain.Url;
import ru.job4j.shortcut.domain.UrlStatisticDto;
import ru.job4j.shortcut.repository.UrlRepository;
import ru.job4j.shortcut.utilite.RandomGeneration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UrlService {
    private final UrlRepository urls;

    public UrlService(UrlRepository urls) {
        this.urls = urls;
    }

    public Optional<Url> findByUrl(String url) {
        return urls.findByUrl(url);
    }

    @Transactional
    public String convert(Url url) {
        Optional<Url> urlDB = findByUrl(url.getUrl());
        String code;
        if (urlDB.isPresent()) {
            code = urlDB.get().getCode();
        } else {
                do {
                    code = RandomGeneration.convertUrl();
                } while (findByCode(code).isPresent());
                url.setCode(code);
                urls.save(url);
        }
        return code;
    }

    public Optional<Url> findByCode(String code) {
        return urls.findByCode(code);
    }

    public List<UrlStatisticDto> statistic() {
        List<UrlStatisticDto> rsl = new ArrayList<>();
        rsl.add(UrlStatisticDto.of("URL", 0));
        urls.findAll().forEach(el -> rsl.add(UrlStatisticDto.of(el.getUrl(), el.getCountStatistic())));
        return rsl;
    }

    public void incrementCount(String code) {
        urls.incrementCount(code);
    }
}
